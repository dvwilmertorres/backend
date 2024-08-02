package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.entity.UserSesionEntity;
import com.appmatch.msusuarios.services.CredentialsServices;
import com.appmatch.msusuarios.services.UserServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserServices _userService;
    private final CredentialsServices _cedentialsServices;

    public UserController(UserServices userService, CredentialsServices cCedentialsServices) {
        _userService = userService;
        _cedentialsServices = cCedentialsServices;
    }
    @PostMapping(value = "/crudUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CurdUser(@RequestBody String request)throws Exception{
        return _userService.crudUser(request) ;
    }
    @PostMapping(value = "/authUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSesionEntity> authUser(@RequestBody String request){
        return _userService.Login(request);
    }

    @PostMapping(value = "/saveCredentials" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCredentials(@RequestBody String request){
        return _cedentialsServices.crudUser(request);
    }
}
