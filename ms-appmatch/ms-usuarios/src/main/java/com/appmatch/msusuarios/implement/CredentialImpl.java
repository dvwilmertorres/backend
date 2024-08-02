package com.appmatch.msusuarios.implement;

import com.appmatch.msusuarios.entity.CredentialEntity;
import com.appmatch.msusuarios.entity.UserProfileEntity;
import com.appmatch.msusuarios.model.CredentialDto;
import com.appmatch.msusuarios.repository.CredentialsRepository;
import com.appmatch.msusuarios.repository.UserProfileRepository;
import com.appmatch.msusuarios.services.CredentialsServices;
import com.appmatch.msusuarios.utils.EncoderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CredentialImpl implements CredentialsServices {
    public CredentialImpl(CredentialsRepository _credentialsRepository, UserProfileRepository userProfileRepository) {
        this._credentialsRepository = _credentialsRepository;
        _userProfileRepository = userProfileRepository;
    }

    private final CredentialsRepository _credentialsRepository;
    private final UserProfileRepository _userProfileRepository;
    @Override
    public ResponseEntity<String> crudUser(String request) {
        EncoderUtils.validateBase64(request);
        CredentialDto decodeRequest = EncoderUtils.decodeRequest(request, CredentialDto.class);
        ResponseEntity<String> response = saveUserCredentials(decodeRequest);
        if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
            System.out.println("La respuesta está en blanco.");
        } else {
            return response;
        }
        return null;
    }
    public ResponseEntity<String> findUser(CredentialDto decodeRequest) {
        Optional<CredentialEntity> response = _credentialsRepository.findById(UUID.fromString(decodeRequest.getFk_pkid_user_Profile()));

        if (response.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        String encodedResponse = EncoderUtils.encodeResponse(response.get());
        return ResponseEntity.ok(encodedResponse);
    }
    @Transactional
    public ResponseEntity<String> saveUserCredentials(CredentialDto userInfoDto) {
        try {
            UserProfileEntity userProfile = _userProfileRepository.findById(UUID.fromString(userInfoDto.getFk_pkid_user_Profile()))
                    .orElseThrow(() -> new RuntimeException("UserProfile not found"));

            LocalDateTime now = LocalDateTime.now();
            CredentialEntity credentialEntity = new CredentialEntity();
            credentialEntity.setUsername(userInfoDto.getUsername());
            credentialEntity.setPassword(userInfoDto.getPassword());
            credentialEntity.setFkPkidUserProfile(UUID.fromString(userInfoDto.getFk_pkid_user_Profile()));
            CredentialEntity savedEntity = _credentialsRepository.save(credentialEntity);

            return ResponseEntity.ok(EncoderUtils.encodeResponse(savedEntity));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(EncoderUtils.encodeResponse(e.getMessage()));
        }
    }
}
