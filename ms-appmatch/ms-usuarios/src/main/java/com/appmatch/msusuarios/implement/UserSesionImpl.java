package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.UserEntity;
import com.appmatch.msusuarios.entity.UserSesionEntity;
import com.appmatch.msusuarios.model.UserDto;
import com.appmatch.msusuarios.model.UserSesionCredentialsDto;
import com.appmatch.msusuarios.repository.UserSesionRepository;
import com.appmatch.msusuarios.services.UserSesionService;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSesionImpl implements UserSesionService {

    private final UserSesionRepository _userSesionRepository;

    public UserSesionImpl(UserSesionRepository userSesionRepository) {
        _userSesionRepository = userSesionRepository;
    }

    @Override
    public ResponseEntity<String> crudUserCredential(String request) {
        EncoderUtils.validateBase64(request);
        UserSesionCredentialsDto decodeRequest = EncoderUtils.decodeRequest(request, UserSesionCredentialsDto.class);
        ResponseEntity<String> response = findUserCredentials(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return response;
        }
        return null;
    }
    public ResponseEntity<String> findUserCredentials(UserSesionCredentialsDto decodeRequest) {
        try{
            Optional<UserSesionEntity> response = _userSesionRepository.findById(decodeRequest.getPkid_user());
            if (response.isEmpty()) {
                return ResponseEntity.status(404).body("User not found");
            }
            String encodedResponse = EncoderUtils.encodeResponse(response.get());
            return ResponseEntity.ok(encodedResponse);
        }
        catch (Exception e){
            return null;
        }
    }
}
