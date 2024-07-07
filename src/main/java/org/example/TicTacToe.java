package org.example;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(Player player1, Player player2, Player curentPlayer, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        this.board = board;
    }

    public void start(){}

    private void switchCurrentPlayer(){}

    private boolean hasWinner(){
        return false;
    }

}
