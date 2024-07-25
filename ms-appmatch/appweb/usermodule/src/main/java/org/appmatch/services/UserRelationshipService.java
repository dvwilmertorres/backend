package org.appmatch.services;

import org.springframework.http.ResponseEntity;

public interface UserRelationshipService {
    ResponseEntity<String> finUserRelationship (String request);
    ResponseEntity<String> addUserRelationship(String request);
}
