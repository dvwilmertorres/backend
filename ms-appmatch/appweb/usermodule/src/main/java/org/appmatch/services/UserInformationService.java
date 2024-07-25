package org.appmatch.services;

import org.springframework.http.ResponseEntity;

public interface UserInformationService {
    ResponseEntity<String> findUserInfromation (String request);
    ResponseEntity<String> addUserInformation (String request);
}
