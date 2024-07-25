package org.appmatch.controller;

import org.appmatch.entity.UserEntity;
import org.appmatch.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService _userService;
    public UserController(UserService userService) {
        _userService = userService;
    }
    @PostMapping(value = "/crudUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CrudUser(@RequestBody String request){
        return _userService.crudUser(request);
    }
    @PostMapping(value = "/authUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> authUser(@RequestBody String request){
        return _userService.Login(request);
    }

    @GetMapping("/authorized")
    public Map<String, Object> authorized(@RequestParam(name= "code") String code){
        return Collections.singletonMap("code",code);
    }
}
