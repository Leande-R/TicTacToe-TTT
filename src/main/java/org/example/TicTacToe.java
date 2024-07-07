package org.example;

import java.util.Scanner;
public class TicTacToe {

    private Player player1;
    private Player player2;
    public Player currentPlayer;
    private Board board;


    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public TicTacToe (TicTacToe toe){
        this.player1 = toe.player1;
        this.player2 = toe.player2;
        this.currentPlayer = toe.currentPlayer;
        this.board = toe.board;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            int row, col;
            while (true) {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();
                if (board.isCellEmpty(row, col)) {
                    break;
                } else {
                    System.out.println("Cell is not empty, try again.");
                }
            }

            board.place(row, col, currentPlayer.getMarker());
            switchCurrentPlayer();
        }
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner(){
        return false;
    }

}