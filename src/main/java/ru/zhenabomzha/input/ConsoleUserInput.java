package ru.zhenabomzha.input;

import java.util.Scanner;

public class ConsoleUserInput {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }
}
