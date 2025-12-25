package com.client.soapclient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User u) {
        return repo.save(u);
    }

    public List<User> all() {
        return repo.findAll();
    }

    public User update(Long id, User updated, String role) {
        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access denied");
        }
        User u = repo.findById(id).orElseThrow();
        u.setName(updated.getName());
        u.setEmail(updated.getEmail());
        return repo.save(u);
    }
}

