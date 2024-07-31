package com.appmatch.msproduct.implpements;


import com.appmatch.msproduct.entity.ProductEntity;
import com.appmatch.msproduct.model.GroupedProductDto;
import com.appmatch.msproduct.model.KnowledgeDto;
import com.appmatch.msproduct.model.ProductDto;
import com.appmatch.msproduct.repository.ProductRepository;
import com.appmatch.msproduct.services.ProductService;
import com.appmatch.msproduct.utils.EncoderUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements ProductService {
    private final ProductRepository _productRepository;

    public ProductImpl(ProductRepository productRepository) {
        _productRepository = productRepository;
    }
    @Override
    public ResponseEntity<String> crudProduct(String request) {
        EncoderUtils.validateBase64(request);
        ProductDto decodeRequest = EncoderUtils.decodeRequest(request, ProductDto.class);
        ResponseEntity<String> response = findProduct(decodeRequest);
        return null;
    }

    public ResponseEntity<String> findProduct(ProductDto decodeRequest) {
        Optional<ProductEntity> response = _productRepository.findById(decodeRequest.getId());
        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("product not found");
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    @Override
    public ResponseEntity<String> findAllProducts() {
        List<ProductEntity> response = _productRepository.findAll();
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            String encodedResponse = mapper.writeValueAsString(response);
            return ResponseEntity.ok(encodedResponse);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing products");
        }
    }

    @Override
    public ResponseEntity<String> findAll() {
        List<ProductEntity> products = _productRepository.findAll();

        Map<String, GroupedProductDto> groupedProducts = products.stream().collect(Collectors.toMap(
                product -> product.getUserid().toString(),
                product -> new GroupedProductDto(
                        product.getName(),
                        product.getUserid().toString(),
                        product.getImage(),
                        new ArrayList<>(List.of(new KnowledgeDto(
                                product.getId().toString(),
                                product.getKnowledge(),
                                product.getPrice(),
                                product.getRating()
                        )))
                ),
                (existing, replacement) -> {
                    existing.getKnowledge().addAll(replacement.getKnowledge());
                    return existing;
                }
        ));

        String encodedResponse = EncoderUtils.encodeResponse(new ArrayList<>(groupedProducts.values()));
        return ResponseEntity.ok(encodedResponse);
    }
}
