import javax.swing.*;
import java.awt.event.ActionEvent;

public class Board {
     private Cell[][] board;
     private GameLogic gameLogic;


     public Board(GameLogic gameLogic) {
         board = new Cell[10][10];
         this.gameLogic = gameLogic;
     }

     public void CreateBoard(JPanel BoardPanel){
         for(int row = 0; row < 10; row++){
             for(int col = 0; col < 10; col++){
                board[row][col] = new Cell(row, col);
                board[row][col].addActionListener((ActionEvent ae) -> {
                    Cell clickedButton = (Cell) ae.getSource();
                    gameLogic.makeMove(clickedButton);
                });
                BoardPanel.add(board[row][col]);
             }
         }
     }
     public void ResetBoard(){
         for(int row = 0; row < 10; row++){
             for(int col = 0; col < 10; col++){
                 board[row][col].setTaken(false);
                 board[row][col].setBlankImg();
                 board[row][col].setIsHit(false);
                 board[row][col].setIsMiss(false);
             }
         }
     }
     public void markOccupied(int row, int col){
         board[row][col].setTaken(true);
     }

}
