package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.UserEntity;
import com.appmatch.msusuarios.model.UserDto;
import com.appmatch.msusuarios.repository.UserRepository;
import com.appmatch.msusuarios.services.UserServices;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserImpl implements UserServices {

    private final UserRepository _userRepository;

    public UserImpl(UserRepository userRepository ) {
        _userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> crudUser(String request) {
        EncoderUtils.validateBase64(request);
        UserDto decodeRequest = EncoderUtils.decodeRequest(request, UserDto.class);
        ResponseEntity<String> response = findUser(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return response;
        }
        return null;
    }
    public ResponseEntity<String> findUser(UserDto decodeRequest) {
        Optional<UserEntity> response = _userRepository.findById(decodeRequest.getPkid_user());
        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    @Override
    public ResponseEntity<UserEntity> Login(String request) {
        return null;
    }

}
