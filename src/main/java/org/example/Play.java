package org.example;
import java.util.Scanner;

public class Play {

        private static char[][] board = new char[3][3];
        private static final char PLAYER1 = 'X';
        private static final char PLAYER2 = 'O';
        private static final char EMPTY = '2';

        public static void main(String[] args) {
            initializeBoard();
            printBoard();
            Scanner scanner = new Scanner(System.in);
            char currentPlayer = PLAYER1;

            while (true) {
                printBoard();
                System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0-2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                    continue;
                }

                if (board[row][col]!= EMPTY) {
                    System.out.println("Cell is already occupied. Please choose another cell.");
                    continue;
                }

                board[row][col] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (checkDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER1)? PLAYER2 : PLAYER1;
            }
        }

        private static void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = EMPTY;
                }
            }
        }

        private static void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + "*");
                }
                System.out.println();
            }
        }

        private static boolean checkWin(char player) {
            // Check rows
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    return true;
                }
            }

            // Check columns
            for (int i = 0; i < 3; i++) {
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                    return true;
                }
            }

            // Check diagonals
            if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
                return true;
            }

            return false;
        }

        private static boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

