package org.example;

import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private final List<String> words = Arrays.asList("Попугай", "Селедка", "Огурчик", "Наслаждение", "Динозавр",
            "Афроамериканец", "Крудошлеп");

    public List<String> getWords() {
        return words;
    }

}
