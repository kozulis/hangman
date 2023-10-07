package org.example;

import java.util.Scanner;

public class Keyboard {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }
}
