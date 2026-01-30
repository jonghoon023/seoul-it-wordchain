package com.example.wordchain.infrastructure;

import com.example.wordchain.application.WordHistoryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryWordHistoryRepository implements WordHistoryRepository {
    private final List<WordRecord> records = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void save(String userId, String word) {
        String normalizedUserId = normalize(userId);
        String normalizedWord = normalize(word);

        if (normalizedUserId.isEmpty() || normalizedWord.isEmpty()) {
            return;
        }

        records.add(new WordRecord(normalizedUserId, normalizedWord));
    }

    @Override
    public String[] findAllWords() {
        List<String> result = new ArrayList<>();

        synchronized (records) {
            for (WordRecord record : records) {
                result.add(record.word());
            }
        }

        return result.toArray(new String[0]);
    }

    @Override
    public String[] findAllWordsByUserId(String userId) {
        List<String> result = new ArrayList<>();
        synchronized (records) {
            for (WordRecord record : records) {
                if (record.userId().equals(userId)) {
                    result.add(record.word());
                }
            }
        }

        return result.toArray(new String[0]);
    }

    @Override
    public void deleteAll() {
        records.clear();
    }

    @Override
    public void deleteAllByUserId(String userId) {
        synchronized (records) {
            records.removeIf(record -> record.userId().equals(userId));
        }
    }

    private String normalize(String str) {
        return str == null ? "" : str.trim();
    }
}