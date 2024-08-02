package com.appmatch.msusuarios.implement;
import com.appmatch.msusuarios.entity.UserProfileEntity;
import com.appmatch.msusuarios.model.UserProfileDto;
import com.appmatch.msusuarios.repository.UserProfileRepository;
import com.appmatch.msusuarios.services.UserProfileServices;
import com.appmatch.msusuarios.utils.EncoderUtils;
import com.appmatch.msusuarios.utils.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import static com.appmatch.msusuarios.utils.response.EntityUtils.createMapFromEntity;

@Service
public class UserProfileImpl implements UserProfileServices {

    private final UserProfileRepository _userProfileRepository;

    public UserProfileImpl(UserProfileRepository _userProfileRepository) {
        this._userProfileRepository = _userProfileRepository;
    }
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public ResponseEntity<String> crudUser(String request) {
        EncoderUtils.validateBase64(request);
        UserProfileDto decodeRequest = EncoderUtils.decodeRequest(request, UserProfileDto.class);
        ResponseEntity<String> response = findUser(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return ResponseEntity.ok(EncoderUtils.encodeResponse(response));
        }
        return null;
    }

    public ResponseEntity<String> findUser(UserProfileDto decodeRequest) {
        if (decodeRequest.getId() == null || decodeRequest.getId().trim().isEmpty()) {
            return saveUserInfo(decodeRequest);
        } else {
            Optional<UserProfileEntity> response = _userProfileRepository.findById(UUID.fromString(decodeRequest.getId()));
            if (response.isEmpty()) {
                return ResponseEntity.status(404).body("User not found");
            }

            Map<String, Object> entityMap = response.map(EntityUtils::createMapFromEntity)
                    .orElseGet(HashMap::new);
            GenericResponse genericRespons = new GenericResponse();

            return ResponseEntity.ok(EncoderUtils.encodeResponse(genericRespons.genericRespons(entityMap)));
        }
    }


    @Transactional
    public ResponseEntity<String> saveUserInfo(UserProfileDto userInfoDto) {
        try {
            LocalDateTime now = LocalDateTime.now();
            UserProfileEntity userInfoEntity = new UserProfileEntity();
            userInfoEntity.setName(userInfoDto.getName());
            userInfoEntity.setMiddleName(userInfoDto.getMiddleName());
            userInfoEntity.setFathersLastName(userInfoDto.getFathersLastName());
            userInfoEntity.setMothersLastName(userInfoDto.getMothersLastName());
            userInfoEntity.setPhone(userInfoDto.getPhone());
            userInfoEntity.setEmail(userInfoDto.getEmail());
            userInfoEntity.setAddress(userInfoDto.getAddress());
            userInfoEntity.setIdentification_number(userInfoDto.getIdentification_number());
            userInfoEntity.setBirthdate(userInfoDto.getBirthdate());
            userInfoEntity.setImage(userInfoDto.getImage());
            UserProfileEntity savedEntity = _userProfileRepository.save(userInfoEntity);

            return ResponseEntity.ok(EncoderUtils.encodeResponse(savedEntity));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(EncoderUtils.encodeResponse(e.getMessage()));
        }
    }
}
