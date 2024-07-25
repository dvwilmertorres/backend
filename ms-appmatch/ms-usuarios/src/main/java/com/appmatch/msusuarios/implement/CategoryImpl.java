package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.CatecoryEntity;
import com.appmatch.msusuarios.model.CategoryDto;
import com.appmatch.msusuarios.repository.CategoryRepository;
import com.appmatch.msusuarios.services.CategoryService;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {

    private final CategoryRepository _categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<String> crudCategory(String request) {
        EncoderUtils.validateBase64(request);
        CategoryDto decodeRequest = EncoderUtils.decodeRequest(request, CategoryDto.class);
        ResponseEntity<String> response = findCategory(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return response;
        }
        return null;
    }
    public ResponseEntity<String> findCategory(CategoryDto decodeRequest) {
        Optional<CatecoryEntity> response = _categoryRepository.findById(decodeRequest.getPkid_category());
        //Optional<UserInformationEntity> responseInfo = _infoUserBasicRepository.findById(decodeRequest.getPkid_user());
        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        // Codificar la respuesta en Base64
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
}
