package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.implement.CategoryImpl;
import com.appmatch.msusuarios.services.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService _categoryService;

    public CategoryController(CategoryService categoryService) {
        _categoryService = categoryService;
    }


    @PostMapping(value = "/crudcategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Crudcategory(@RequestBody String request)throws Exception{
        return _categoryService.crudCategory(request) ;
    }
}
