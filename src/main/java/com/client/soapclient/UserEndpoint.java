package com.client.soapclient;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.CreateUserRequest;
import soap.UpdateUserRequest;
import soap.UserResponse;

import java.util.List;

@Endpoint
public class UserEndpoint {

    private static final String NS = "http://example.com/users";
    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NS, localPart = "CreateUserRequest")
    @ResponsePayload
    public UserResponse create(@RequestPayload CreateUserRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setRole(req.getRole());
        return UserResponse.from(service.create(u));
    }

    @PayloadRoot(namespace = NS, localPart = "GetUsersRequest")
    @ResponsePayload
    public List<UserResponse> all() {
        return service.all().stream()
                .map(UserResponse::from)
                .toList();
    }

    @PayloadRoot(namespace = NS, localPart = "UpdateUserRequest")
    @ResponsePayload
    public UserResponse update(@RequestPayload UpdateUserRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        return UserResponse.from(
                service.update(req.getId(), u, req.getRequesterRole())
        );
    }
}

