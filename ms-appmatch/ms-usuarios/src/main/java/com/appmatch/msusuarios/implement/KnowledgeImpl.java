package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.knowledgeEntity;
import com.appmatch.msusuarios.model.GroupedKnowledgeDto;
import com.appmatch.msusuarios.repository.KnowledgeRepository;
import com.appmatch.msusuarios.services.knowledgeServices;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KnowledgeImpl implements knowledgeServices {
    private final KnowledgeRepository _knowledge;

    public KnowledgeImpl(KnowledgeRepository knowledge) {
        _knowledge = knowledge;
    }

    @Override
    public ResponseEntity<String> crudKnowledge() {
        List<knowledgeEntity> products = _knowledge.findAll();

        Map<String, GroupedKnowledgeDto> groupedKnowledge = products.stream().collect(Collectors.toMap(
                product -> product.getId().toString(),
                product -> {
                    GroupedKnowledgeDto dto = new GroupedKnowledgeDto();
                    dto.setId(UUID.fromString(product.getId().toString()));
                    dto.setGroup_knowledge(product.getName_knowledge());
                    dto.setName_knowledge(product.getGroup_knowledge());
                    return dto;
                },
                (existing, replacement) -> {

                    existing.setGroup_knowledge(existing.getGroup_knowledge() + ", " + replacement.getGroup_knowledge());
                    return existing;
                }
        ));
        String encodedResponse = EncoderUtils.encodeResponse(new ArrayList<>(groupedKnowledge.values()));
        return ResponseEntity.ok(encodedResponse);
    }

}
