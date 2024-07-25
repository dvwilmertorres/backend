package org.appmatch.controller;

import org.appmatch.services.UserInformationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/userInformation")
public class UserinformationController {
    private final  UserInformationService _userInformationServices;

    public UserinformationController(UserInformationService userInformationServices) {
        _userInformationServices = userInformationServices;
    }
    @PostMapping(value = "/findUserInformation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> FindUserInformation (@RequestBody String request){
        return _userInformationServices.findUserInfromation(request);
    }
}
