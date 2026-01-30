package com.example.wordchain.application;

public interface UserRepository {
    // Create: 사용자의 고유한 ID 를 생성한다.
    String create(String name);

    // Delete: 사용자의 고유한 ID 를 삭제한다.
    void delete(String userId);
}
