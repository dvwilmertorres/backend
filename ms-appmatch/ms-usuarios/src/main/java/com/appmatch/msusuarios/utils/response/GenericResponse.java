package com.appmatch.msusuarios.utils.response;
import com.appmatch.msusuarios.utils.EncoderUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class GenericResponse {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public String genericRespons(Map<String, Object> entityMap) {

        DynamicDto dynamicDto = new DynamicDto();
        entityMap.forEach(dynamicDto::addProperty);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Correcto");

        ApiResponse.ResponseItem responseItem = new ApiResponse.ResponseItem();
        responseItem.setMensaje("Operación exitosa");
        responseItem.setData(EncoderUtils.encodeResponse(dynamicDto));
        apiResponse.setResponse(new ApiResponse.ResponseItem[]{responseItem});

        return convertToJson(apiResponse);
    }
    private String convertToJson(ApiResponse apiResponse) {
        try {
            return OBJECT_MAPPER.writeValueAsString(apiResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON", e);
        }
    }
}
