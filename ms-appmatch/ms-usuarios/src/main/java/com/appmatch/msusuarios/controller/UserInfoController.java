package com.appmatch.msusuarios.controller;

import com.appmatch.msusuarios.services.UserInfoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infobasic")
@CrossOrigin(origins = "*")
public class UserInfoController {
    private final UserInfoService _userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        _userInfoService = userInfoService;
    }
    @PostMapping(value = "/crudInfobasic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> CrudInfobasic(@RequestBody String request)throws Exception{
        return _userInfoService.crudInfoService(request);
    }
}
