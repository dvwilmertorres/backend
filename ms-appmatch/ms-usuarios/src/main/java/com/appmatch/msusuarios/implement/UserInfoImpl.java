package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.UserEntity;
import com.appmatch.msusuarios.entity.UserInfoEntity;
import com.appmatch.msusuarios.model.UserDto;
import com.appmatch.msusuarios.model.UserInfoDto;
import com.appmatch.msusuarios.repository.UserInfoRepository;
import com.appmatch.msusuarios.services.UserInfoService;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserInfoImpl implements UserInfoService {
    private final UserInfoRepository _userInfoRepository;

    public UserInfoImpl(UserInfoRepository userInfoRepository) {
        _userInfoRepository = userInfoRepository;
    }
    @Override
    public ResponseEntity<String> crudInfoService(String request) {
        EncoderUtils.validateBase64(request);
        UserInfoDto decodeRequest = EncoderUtils.decodeRequest(request, UserInfoDto.class);
        ResponseEntity<String> response = findInfoUser(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return response;
        }
        return null;
    }
    public ResponseEntity<String> findInfoUser(UserInfoDto decodeRequest) {
        Optional<UserInfoEntity> response = _userInfoRepository.findByDocument(decodeRequest.getDocument());
        //Optional<UserInfoEntity> response = _userInfoRepository.findById(decodeRequest.getPkid_user_information());
        if (response.isEmpty()) {
            try {
                saveUserInfo(decodeRequest);
                return ResponseEntity.ok("Usuario creado correctamente");
            }catch (Exception e){
                return ResponseEntity.status(404).body("User not found");
            }
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    @Transactional
    public ResponseEntity<String> saveUserInfo(UserInfoDto userInfoDto) {
        try {
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setFirst_name(userInfoDto.getFirst_name());
            userInfoEntity.setLast_name(userInfoDto.getLast_name());
            userInfoEntity.setDocument (userInfoDto.getDocument());
            userInfoEntity.setIndicative(userInfoDto.getIndicative());
            userInfoEntity.setPhone(userInfoDto.getPhone());
            userInfoEntity.setEmail(userInfoDto.getEmail());
            userInfoEntity.setAddress(userInfoDto.getAddress());

            // Save the new UserInfoEntity
            UserInfoEntity savedEntity = _userInfoRepository.save(userInfoEntity);

            // Encode and return the response
            String encodedResponse = EncoderUtils.encodeResponse(savedEntity);
            return ResponseEntity.ok(encodedResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving user information: " + e.getMessage());
        }
    }
}
