package org.example;

import java.util.Scanner;
public class TicTacToe {
    private Player player1;
    private Player player2;
    public Player currentPlayer;
    public Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            promptMove(scanner);
            if (checkGameOver()) {
                break;
            }
            switchCurrentPlayer();
        }
        scanner.close();
    }

    void promptMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("row (0-2): ");
            row = scanner.nextInt();
            System.out.print("column (0-2): ");
            col = scanner.nextInt();
            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                break;
            } else {
                System.out.println("Cell is not empty, try again.");
            }
        }
    }

    public boolean checkGameOver() {
        if (hasWinner()) {
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
            return true;
        }
        if (board.isFull()) {
            board.print();
            System.out.println("The game is a draw.");
            return true;
        }
        return false;
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == currentPlayer.getMarker() &&
                    cells[i][1] == currentPlayer.getMarker() &&
                    cells[i][2] == currentPlayer.getMarker()) {
                return true;
            }
            if (cells[0][i] == currentPlayer.getMarker() &&
                    cells[1][i] == currentPlayer.getMarker() &&
                    cells[2][i] == currentPlayer.getMarker()) {
                return true;
            }
        }
        if (cells[0][0] == currentPlayer.getMarker() &&
                cells[1][1] == currentPlayer.getMarker() &&
                cells[2][2] == currentPlayer.getMarker()) {
            return true;
        }
        if (cells[0][2] == currentPlayer.getMarker() &&
                cells[1][1] == currentPlayer.getMarker() &&
                cells[2][0] == currentPlayer.getMarker()) {
            return true;
        }
        return false;
    }
}