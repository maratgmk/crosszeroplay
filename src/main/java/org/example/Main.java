package org.example;

import java.util.Scanner;

import static org.example.Play.*;

public class Main {
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER1;
    }
}