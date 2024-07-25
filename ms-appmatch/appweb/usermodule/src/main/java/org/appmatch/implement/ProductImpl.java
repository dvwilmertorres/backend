package org.appmatch.implement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.appmatch.entity.ProductEntity;
import org.appmatch.model.ProductDto;
import org.appmatch.repository.ProductRepository;
import org.appmatch.services.ProductService;
import org.appmatch.utils.EncoderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    private final ProductRepository _productrepository;

    public ProductImpl(ProductRepository productrepository) {
        _productrepository = productrepository;
    }

    @Override
    public ResponseEntity<String> crudProduct(String request) {
        EncoderUtils.validateBase64(request);
        ProductDto decodeRequest = EncoderUtils.decodeRequest(request, ProductDto.class);
        ResponseEntity<String> response = findProduct(decodeRequest);
        return null;
    }

    public ResponseEntity<String> findProduct(ProductDto decodeRequest) {
        Optional<ProductEntity> response = _productrepository.findById(decodeRequest.getPkid_product());
        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("product not found");
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    @Override
    public ResponseEntity<String> findAllProducts() {
        List<ProductEntity> response = _productrepository.findAll();
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

}
