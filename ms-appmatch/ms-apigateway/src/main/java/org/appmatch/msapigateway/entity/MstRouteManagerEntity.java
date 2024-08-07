package org.appmatch.msapigateway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "mst_route_manager", schema = "appmatch_apigateway")
public class MstRouteManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID pkid_mst_route_manager;
    private String creation_date;
    private String expiration_date;
    private String service_name;
    private String group;
    private String method;
    private String protocol;
    private String uri;
    private String port;
    private String predicates;
    private String filters;
    private String endpoint;

    public UUID getPkid_mst_route_manager() {
        return pkid_mst_route_manager;
    }

    public void setPkid_mst_route_manager(UUID pkid_mst_route_manager) {
        this.pkid_mst_route_manager = pkid_mst_route_manager;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
