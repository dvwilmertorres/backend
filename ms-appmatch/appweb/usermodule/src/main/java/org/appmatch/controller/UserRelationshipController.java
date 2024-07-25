package org.appmatch.controller;

import org.appmatch.services.UserRelationshipService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRelationship")
public class UserRelationshipController {
    private final UserRelationshipService _userRelationshipService;

    public UserRelationshipController(UserRelationshipService userRelationshipService) {
        _userRelationshipService = userRelationshipService;
    }
    @PostMapping(value = "/crud", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Crud(@RequestBody String request){
        return _userRelationshipService.addUserRelationship(request);
    }

}
