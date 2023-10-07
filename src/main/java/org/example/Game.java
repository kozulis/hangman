package org.example;

public class Game {
    private final ConsoleLogic consoleLogic;
    private final Menu menu;

    public Game(ConsoleLogic consoleLogic) {
        this.consoleLogic = consoleLogic;
        this.menu = new Menu();
    }

    public void start() {
        while (true) {
            menu.print();
            String inputted = Keyboard.input();

            if (inputted.equals("1")) {
                System.out.println("Да начнутся голодные игры!");
                consoleLogic.start();
            } else if (inputted.equals("2")) {
                System.out.println("Выход из программы с целой шеей");
                break;
            }
        }
    }

}
