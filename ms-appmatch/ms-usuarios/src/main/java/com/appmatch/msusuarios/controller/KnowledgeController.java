package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.services.knowledgeServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/knowledge")
@RestController
@CrossOrigin(origins = "*")
public class KnowledgeController {
    public KnowledgeController(knowledgeServices _knowledgeServices) {
        this._knowledgeServices = _knowledgeServices;
    }

    private final knowledgeServices _knowledgeServices;

    @PostMapping(value = "/knowledgeCrud" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> knowledgeCrud(){
        return _knowledgeServices.crudKnowledge();
    }
}
