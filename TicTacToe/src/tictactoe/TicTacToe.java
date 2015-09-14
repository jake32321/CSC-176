/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Jacob Reed
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        TicTacBoard board = new TicTacBoard();
        
        System.out.println("The number of rows is: ");
        System.out.println();
        System.out.println(board);
        
        board.placeMarker(1, 2, 2);
        board.placeMarker(2, 1, 1);
        board.placeMarker(2, 1, 2);
        
        System.out.println(board);
        
        
    }
}
