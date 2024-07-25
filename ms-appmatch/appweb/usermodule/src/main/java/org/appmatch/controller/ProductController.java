package org.appmatch.controller;

import org.appmatch.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService _productServices;

    public ProductController(ProductService productServices) {
        _productServices = productServices;
    }
    @PostMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> FindAll() {
        return _productServices.findAllProducts();
    }
    @PostMapping(value = "/findProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> FindProduct(@RequestBody String request) {
        return _productServices.crudProduct(request);
    }
}