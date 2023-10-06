package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words = Arrays.asList("Попугай", "Селедка", "Огурчик", "Наслаждение", "Динозавр",
            "Афроамериканец", "Крудошлеп");

    public List<String> getWords() {
        return words;
    }

    public String getRandomWord() {
        Random random = new Random();
        int wordIndex = random.nextInt(getWords().size());
        return getWords().get(wordIndex).toLowerCase();
    }

    public StringBuilder getHiddenWord(String word) {
        StringBuilder hiddenWord = new StringBuilder();
        hiddenWord.append("*".repeat(word.length()));
        return hiddenWord;
    }
}
