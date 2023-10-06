package org.example;

import java.util.Scanner;

public class GameStarter {
    GameLogic gameLogic = new GameLogic();

    protected void getStart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.printMenu();
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                System.out.println("Да начнутся голодные игры!");
                gameLogic.guessWord();
            } else if (userInput.equals("2")) {
                System.out.println("Выход из программы с целой шеей");
                break;
            }
        }
    }

}



