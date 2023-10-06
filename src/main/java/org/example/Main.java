package org.example;

public class Main {

    public static void main(String[] args) {
        final ConsoleLogic consoleLogic = new ConsoleLogic();
        Game game = new Game(consoleLogic);
        game.start();
    }
}
