package org.appmatch.implement;

import org.appmatch.repository.UserInformationRepository;
import org.appmatch.repository.UserRepository;
import org.appmatch.services.UserInformationService;
import org.appmatch.utils.ErrorControlUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserInformationimpl implements UserInformationService {
    private final ErrorControlUtils _errorControlutils;
    private final UserInformationRepository _userInformationRepository;

    public UserInformationimpl(ErrorControlUtils errorControlutils, UserRepository userRepository, UserInformationRepository userInformationRepository) {
        _errorControlutils = errorControlutils;
        _userInformationRepository = userInformationRepository;
    }
    @Override
    public ResponseEntity<String> findUserInfromation(String request) {
        return null;
    }

    @Override
    public ResponseEntity<String> addUserInformation(String request) {
        return null;
    }
}
