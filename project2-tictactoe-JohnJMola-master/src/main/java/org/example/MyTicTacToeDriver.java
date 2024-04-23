package org.example;

import java.util.Scanner;
import java.util.Random;

public class MyTicTacToeDriver {
    public static void main(String[] args) {
        Random randomObj = new Random(13);
        Scanner scannerObj = new Scanner(System.in);
        char[] boardArray = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println("Programming Fundamentals");
        System.out.println("NAME: John Mola");
        System.out.println("PROGRAMMING ASSIGNMENT 2");
        System.out.println("Welcome to Tic Tac Toe game!");

        displayBoard(boardArray);

        while (true) {
            userInputAndPlacement(boardArray, scannerObj);
            displayBoard(boardArray);
            if (winCheck(boardArray, 'X')) {
                System.out.println("you win!");
                break;
            }
            if (gameDraw(boardArray)) {
                System.out.println("you tied!");
                break;
            }
            computerRNGPlacement(boardArray, randomObj);
            displayBoard(boardArray);
            if (winCheck(boardArray, 'O')) {
                System.out.println("you lose!");
                break;
            }
            if (gameDraw(boardArray)) {
                System.out.println("you tied!");
                break;
            }
        }
    }

    public static void displayBoard(char[] boardArray) {
        System.out.println("Board:");
        for (int i = 0; i < boardArray.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(boardArray[i] + " ");
        }
        System.out.println("\n");
    }

    public static boolean winCheck(char[] boardArray, char player) {
        return (boardArray[0] == player && boardArray[1] == player && boardArray[2] == player) ||
                (boardArray[3] == player && boardArray[4] == player && boardArray[5] == player) ||
                (boardArray[6] == player && boardArray[7] == player && boardArray[8] == player) ||
                (boardArray[0] == player && boardArray[3] == player && boardArray[6] == player) ||
                (boardArray[1] == player && boardArray[4] == player && boardArray[7] == player) ||
                (boardArray[2] == player && boardArray[5] == player && boardArray[8] == player) ||
                (boardArray[0] == player && boardArray[4] == player && boardArray[8] == player) ||
                (boardArray[2] == player && boardArray[4] == player && boardArray[6] == player);
    }

    public static boolean gameDraw(char[] boardArray) {
        for (char c : boardArray) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    public static void userInputAndPlacement(char[] boardArray, Scanner scanner) {
        System.out.println("Enter your placement (1-9): ");
        int placement = scanner.nextInt();
        if (placement < 1 || placement > 9 || boardArray[placement - 1] == 'X' || boardArray[placement - 1] == 'O') {
            System.out.println("Invalid placement, try again.");
            userInputAndPlacement(boardArray, scanner);
        } else {
            boardArray[placement - 1] = 'X';
        }
    }

    public static void computerRNGPlacement(char[] boardArray, Random random) {
        int placement;
        do {
            placement = random.nextInt(9);
        } while (boardArray[placement] == 'X' || boardArray[placement] == 'O');
        boardArray[placement] = 'O';
    }
}
