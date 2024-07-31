package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.UserSesionEntity;
import com.appmatch.msusuarios.model.UserDto;
import com.appmatch.msusuarios.repository.UserRepository;
import com.appmatch.msusuarios.services.UserServices;
import com.appmatch.msusuarios.utils.EncodeDecodeMd5;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseEntity<UserSesionEntity> Login(String request) {
        EncoderUtils.validateBase64(request);
        UserDto decodeRequest = EncoderUtils.decodeRequest(request, UserDto.class);
        ResponseEntity<UserSesionEntity> response = authenticateUser(decodeRequest);
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            System.out.println("La respuesta está en blanco o el usuario no está autorizado.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return response;
    }


    public ResponseEntity<String> findUser(UserDto decodeRequest) {
        Optional<UserSesionEntity> response = _userRepository.findByUser(decodeRequest.getUser());

        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }

    public ResponseEntity<UserSesionEntity> authenticateUser(UserDto userDto) {
        String passwordEncoded = EncodeDecodeMd5.encodeMd5(userDto.getPassword());
        return _userRepository.findByUser(userDto.getUser())
                .filter(user -> passwordEncoded.equals(user.getPassword()))
                .map(user -> {
                    UserSesionEntity userSesionEntity = new UserSesionEntity();
                    userSesionEntity.setId(user.getId());
                    userSesionEntity.setUser(user.getUser());
                    userSesionEntity.setCountry(user.getCountry());
                    userSesionEntity.setGender(user.getGender());
                    userSesionEntity.setName(user.getName());
                    userSesionEntity.setRol(user.getRol());
                    return ResponseEntity.ok(userSesionEntity);
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
