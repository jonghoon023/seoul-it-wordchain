package com.example.wordchain.domain;

import java.util.Arrays;

public class GameRule {
    private static final int MIN_WORD_LENGTH = 2;

    // 단어의 최소 길이가 2 이상이면 true, 미만이면 false
    public boolean isWordLengthEnough(String word) {
        String normalizedWord = normalize(word);
        return normalizedWord.length() >= MIN_WORD_LENGTH;
    }

    // 중복된 단어가 배열에서 발견되면 true, 발견되지 않으면 false
    public boolean isDuplicateWord(String[] words, String newWord) {
        String normalizedWord = normalize(newWord);

        if (normalizedWord.isEmpty() || words == null) {
            return false;
        }

        return Arrays.asList(words).contains(normalizedWord);
    }

    // 다음 단어의 시작이 올바른지 검증하여 올바르면 true, 올바르지 않으면 false
    public boolean isNextWordStartsCorrectly(String lastWord, String newWord) {
        String normalizedLastWord = normalize(lastWord);
        String normalizedNewWord = normalize(newWord);

        // 새로운 단어가 빈 문자열이면 규칙을 준수하지 않은 것으로 판단한다.
        if (normalizedNewWord.isEmpty()) { return false; }

        // 마지막으로 입력된 단어가 빈 문자열이면 처음 입력된 단어로 보고 규칙을 준수하였다고 판단한다.
        if (normalizedLastWord.isEmpty()) { return true; }

        // 마지막 단어의 마지막 글자를 가져온다.
        char lastChar = normalizedLastWord.charAt(normalizedLastWord.length() - 1);

        // 새로운 단어의 첫 글자를 가져온다.
        char firstChar = normalizedNewWord.charAt(0);

        return lastChar == firstChar;
    }

    // 문자열이 null 이면 빈 문자열을 반환하고, 그렇지 않으면 공백을 제거하여 반환한다.
    private String normalize(String str) {
        return str == null ? "" : str.trim();
    }
}
