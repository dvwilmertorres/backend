package com.appmatch.msusuarios.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private String status;

    @JsonProperty("Response")
    private ResponseItem[] response;

    // Constructor, getters y setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponseItem[] getResponse() {
        return response;
    }

    public void setResponse(ResponseItem[] response) {
        this.response = response;
    }

    public static class ResponseItem {
        @JsonProperty("Mansaje") // Ajuste para que coincida con el JSON
        private String mensaje;

        private String data;

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

}
