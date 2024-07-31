package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.DictionaryEntity;
import com.appmatch.msusuarios.model.DictionaryGroupingDto;
import com.appmatch.msusuarios.model.DictionarySubgroupDto;
import com.appmatch.msusuarios.model.DictionaryValueDto;
import com.appmatch.msusuarios.repository.DictionaryRepository;
import com.appmatch.msusuarios.services.DictionaryServices;
import com.appmatch.msusuarios.utils.EncoderUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DictionaryImpl implements DictionaryServices {

    private DictionaryRepository _dictionaryRepository;

    public DictionaryImpl(DictionaryRepository dictionaryRepository) {
        _dictionaryRepository = dictionaryRepository;
    }

    @Override
    public ResponseEntity<String> crudDictionary(String request) {
        return null;
    }

    @Override
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<DictionaryEntity> dictionaries = _dictionaryRepository.findAll();

        // Agrupar por groupname y luego por subgroupname
        Map<String, DictionaryGroupingDto> groupedData = dictionaries.stream().collect(Collectors.toMap(
                DictionaryEntity::getGroupname,
                dictionary -> {
                    DictionaryValueDto valueDto = new DictionaryValueDto(
                            dictionary.getValue(),
                            dictionary.getDescription(),
                            dictionary.getId().toString()
                    );

                    DictionarySubgroupDto subgroupDto = new DictionarySubgroupDto(
                            dictionary.getSubgroupname(),
                            new ArrayList<>(Collections.singletonList(valueDto))
                    );

                    return new DictionaryGroupingDto(
                            dictionary.getId().toString(),
                            dictionary.getGroupname(),
                            new ArrayList<>(Collections.singletonList(subgroupDto))
                    );
                },
                (existing, replacement) -> {
                    DictionarySubgroupDto replacementSubgroup = replacement.getSubgroups().get(0);
                    DictionarySubgroupDto existingSubgroup = existing.getSubgroups().stream()
                            .filter(subgroup -> subgroup.getSubgroupname().equals(replacementSubgroup.getSubgroupname()))
                            .findFirst()
                            .orElse(null);

                    if (existingSubgroup != null) {
                        existingSubgroup.getValues().addAll(replacementSubgroup.getValues());
                    } else {
                        existing.getSubgroups().add(replacementSubgroup);
                    }

                    return existing;
                }
        ));
        List<DictionaryGroupingDto> result = new ArrayList<>(groupedData.values());
        String jsonResponse = "";
        try {
            jsonResponse = new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
        }
        //return ResponseEntity.ok(EncoderUtils.encodeResponse(jsonResponse));
        return ResponseEntity.ok(jsonResponse);
    }
}
