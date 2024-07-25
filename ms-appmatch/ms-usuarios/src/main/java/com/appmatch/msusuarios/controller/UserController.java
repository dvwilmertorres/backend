package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.services.UserServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserServices _userService;

    public UserController(UserServices userService) {
        _userService = userService;
    }
    @PostMapping(value = "/crudUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CurdUser(@RequestBody String request)throws Exception{
        return _userService.crudUser(request) ;
    }
}
