package com.example.wordchain.infrastructure;

import com.example.wordchain.application.UserRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, String> users = new ConcurrentHashMap<String, String>();

    @Override
    public String create(String name) {
        String normalizedName = normalize(name);
        String userId = users.get(normalizedName);

        if (userId == null) {
            userId = UUID.randomUUID().toString();
            users.put(name, userId);
        }

        return userId;
    }

    @Override
    public void delete(String userId) {
        String normalizedId = normalize(userId);
        users.remove(normalizedId);
    }

    private String normalize(String str) {
        return str == null ? "" : str.trim();
    }
}
