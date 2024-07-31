package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.services.DictionaryServices;
import com.appmatch.msusuarios.services.UserProfileServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/userProfile")
public class UserProfileController {

    private final DictionaryServices _dictionaryServices;
    private final UserProfileServices _userProfileServices;

    public UserProfileController(DictionaryServices _dictionaryServices, UserProfileServices _userProfileServices) {
        this._dictionaryServices = _dictionaryServices;
        this._userProfileServices = _userProfileServices;
    }


    @PostMapping(value = "/searchDictionaries" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> searchDictionaries() throws JsonProcessingException {
        return _dictionaryServices.findAll();
    }
    @PostMapping(value = "/crudUserProfile" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crudUserProfile(@RequestBody String request) throws JsonProcessingException {
        return _userProfileServices.crudUser(request);
    }
}
