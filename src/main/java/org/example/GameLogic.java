package org.example;

import java.util.Scanner;

public class GameLogic {
    Dictionary dictionary = new Dictionary();
    Scanner scanner = new Scanner(System.in);
    HangPicture hang = new HangPicture();

    int triesCount = 5;
    String word = dictionary.getRandomWord();
    StringBuilder hiddenWord = dictionary.getHiddenWord(word);
    StringBuilder usedLetters = new StringBuilder();

    void guessWord() {

        System.out.println("Отгадайте слово: " + hiddenWord);
//        System.out.println(word);

        while (triesCount > 0) {
            System.out.print("Введите букву: ");
            String userInput = scanner.nextLine().toLowerCase();
            if (!word.contains(userInput)) {
                if (!usedLetters.toString().contains(userInput)) {
                    usedLetters.append(userInput).append(" ");
                } else {
                    triesCount++;
                }
                System.out.println("Использованные буквы: " + usedLetters);
                triesCount--;
                System.out.println(hiddenWord);
                hang.drawHang(triesCount);
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
        if (triesCount == 0) {
            System.out.println("У вас не осталось попыток.");
            System.out.printf("Вы проиграли. Загаданное слово - %s\n", word.substring(0, 1).toUpperCase() +
                    word.substring(1));
        } else {
            System.out.printf("Такой буквы в слове нет.\nКоличество оставшихся попыток- %d\n", triesCount);
        }
    }
}
