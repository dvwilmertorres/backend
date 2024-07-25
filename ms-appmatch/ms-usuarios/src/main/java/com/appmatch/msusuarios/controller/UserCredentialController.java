package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.services.UserSesionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credentials")
@CrossOrigin(origins = "*")
public class UserCredentialController {
    private final UserSesionService _userSesionService;

    public UserCredentialController(UserSesionService userSesionService) {
        _userSesionService = userSesionService;
    }
    @PostMapping(value = "/crudCredential", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CrudCredential(@RequestBody String request)throws Exception{
        return _userSesionService.crudUserCredential(request) ;
    }
}
