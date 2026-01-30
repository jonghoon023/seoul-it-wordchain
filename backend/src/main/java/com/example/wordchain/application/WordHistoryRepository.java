package com.example.wordchain.application;

public interface WordHistoryRepository {
    // Create: 사용자가 입력한 단어를 저장한다.
    void save(String userId, String word);

    // Get: 모든 사용자가 입력한 모든 단어 목록을 가져온다.
    String[] findAllWords();

    // Get: 특정 사용자가 입력한 모든 단어 목록을 가져온다.
    String[] findAllWordsByUserId(String userId);

    // Delete: 모든 사용자가 입력한 모든 단어 목록을 삭제한다.
    void deleteAll();

    // Delete: 특정 사용자가 입력한 모든 단어 목록을 삭제한다.
    void deleteAllByUserId(String userId);
}
