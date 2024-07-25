package org.appmatch.implement;

import org.appmatch.entity.UserEntity;
import org.appmatch.model.UserDto;
import org.appmatch.repository.UserRepository;
import org.appmatch.services.UserService;

import org.appmatch.utils.EncodeDecodeMd5;
import org.appmatch.utils.EncoderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserImpl implements UserService {
    private final UserRepository _userRepository;

    public UserImpl(UserRepository userRepository) {
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

    @Override
    public ResponseEntity<UserEntity> Login(String request) {
        EncoderUtils.validateBase64(request);
        UserDto decodeRequest = EncoderUtils.decodeRequest(request, UserDto.class);
        ResponseEntity<UserEntity> response = authenticateUser(decodeRequest);
        if (response == null || response.getBody() == null) {
            System.out.println("La respuesta está en blanco.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return response;
        }
    }

    public ResponseEntity<String> findUser(UserDto decodeRequest) {
        Optional<UserEntity> response = _userRepository.findById(decodeRequest.getPkid_user());
        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        // Codificar la respuesta en Base64
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    public ResponseEntity<UserEntity> authenticateUser(UserDto userDto) {
        String passwordEncoded = EncodeDecodeMd5.encodeMd5(userDto.getPassword());
        UserEntity userEntity = _userRepository.findByUser(userDto.getUser());
        if (userEntity != null && passwordEncoded.equals(userEntity.getPassword())) {
            return ResponseEntity.ok(userEntity);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
