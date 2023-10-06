package org.example;

import java.util.Scanner;

public class ConsoleLogic {
    private final Dictionary dictionary;
    private final HangPicture hang;
    private int attempts = 5;

    public ConsoleLogic() {
        this.dictionary = new Dictionary();
        this.hang = new HangPicture();
    }

    private String word = dictionary.getRandomWord();
    private StringBuilder hiddenWord = dictionary.getHiddenWord(word);
    private StringBuilder usedLetters = new StringBuilder();

    void start() {

        System.out.println("Отгадайте слово: " + hiddenWord);

        while (attempts > 0) {
            System.out.print("Введите букву: ");
            String userInput = Keyboard.input().toLowerCase();

            if (!word.contains(userInput)) {
                if (!usedLetters.toString().contains(userInput)) {
                    usedLetters.append(userInput).append(" ");
                } else {
                    attempts++;
                }
                System.out.println("Использованные буквы: " + usedLetters);
                attempts--;
                System.out.println(hiddenWord);
                hang.drawHang(attempts);
                checkTriesCount();
                continue;
            }

            addLetterToHiddenWord(userInput);

            usedLetters.append(userInput).append(" ");
            System.out.println("Использованные буквы: " + usedLetters);
            System.out.println(hiddenWord);

            if (!hiddenWord.toString().contains("*")) {
                System.out.println("Игра закончена, Вы отгадали слово! Вы мой кумир!");
                return;
            }
        }
    }

    void addLetterToHiddenWord(String userInput) {
        for (int i = 0; i <= word.length() - 1; i++) {
            if (userInput.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                hiddenWord.replace(i, i + 1, userInput);
            }
        }
    }

    void checkTriesCount() {
        if (attempts == 0) {
            System.out.println("У вас не осталось попыток.");
            System.out.printf("Вы проиграли. Загаданное слово - %s\n", word.substring(0, 1).toUpperCase() +
                word.substring(1));
        } else {
            System.out.printf("Такой буквы в слове нет.\nКоличество оставшихся попыток- %d\n", attempts);
        }
    }
}
