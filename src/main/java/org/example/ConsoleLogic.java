package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConsoleLogic {
    private final Dictionary dictionary;
    private final HangPicture hangPicture;
    private final List<Character> usedChars;

    private static final int ATTEMPTS = 5;
    private int attemptsCount;
    private String randomWord;
    private String hiddenWord;

    public ConsoleLogic() {
        this.dictionary = new Dictionary();
        this.hangPicture = new HangPicture();
        this.usedChars = new ArrayList<>();
    }

    void start() {
        randomWord = this.getRandomWord(dictionary.getWords());
        hiddenWord = this.getHiddenWord(randomWord);
        usedChars.clear();
        attemptsCount = ATTEMPTS;
        System.out.println("Отгадайте слово: " + hiddenWord);
        System.out.println(randomWord);

        while (attemptsCount > 0) {
            System.out.print("Введите букву русского алфавита: ");
            String userInput = Keyboard.input().toLowerCase();

            if (!isRussianAlphabet(userInput)) {
                System.out.println("Введен некорректный символ");
                continue;
            }

            if (isLetterWasAlreadyEntered(userInput)) {
                System.out.println("Такая буква уже была введена");
                this.printUsedChars();
                this.printHiddenWord();
                continue;
            }

            usedChars.add(this.getFirstCharFromString(userInput));

            if (randomWord.contains((userInput))) {
                this.changeHiddenWord();
                this.printUsedChars();
                this.printHiddenWord();

                if (!hiddenWord.contains("*")) {
                    System.out.println("Игра закончена, Вы отгадали слово! Вы мой кумир!");
                    return;
                }
            } else {
                attemptsCount--;
                System.out.printf("Такой буквы в слове нет.\nКоличество оставшихся попыток- %d\n", attemptsCount);
                this.printUsedChars();
                this.printHiddenWord();
                hangPicture.draw(attemptsCount);

                if (isNoMoreAttempts()) {
                    System.out.println("У вас не осталось попыток.");
                    System.out.printf("Вы проиграли. Загаданное слово - %s\n\n", randomWord.substring(0, 1).toUpperCase() +
                            randomWord.substring(1));
                    return;
                }
            }
        }
    }

    private static boolean isRussianAlphabet(String userInput) {
        return userInput.matches("[а-я]");
    }

    private boolean isLetterWasAlreadyEntered(String userInput) {
        return usedChars.contains(this.getFirstCharFromString(userInput));
    }

    private boolean isNoMoreAttempts() {
        return attemptsCount == 0;
    }

    private char getFirstCharFromString(String userInput) {
        return userInput.charAt(0);
    }

    private void printHiddenWord() {
        System.out.println(hiddenWord);
    }

    private void printUsedChars() {
        System.out.println("Использованные буквы: "
                + usedChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private void changeHiddenWord() {
        this.hiddenWord = randomWord.chars()
                .mapToObj(value -> (char) value)
                .map(character -> usedChars.contains(character) ? String.valueOf(character) : "*")
                .collect(Collectors.joining());
    }

    private String getRandomWord(List<String> words) {
        Random random = new Random();
        int wordIndex = random.nextInt(words.size());
        return words.get(wordIndex).toLowerCase();
    }

    private String getHiddenWord(String word) {
        return "*".repeat(word.length());
    }
}
