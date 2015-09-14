/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Jacob Reed
 */
public class RectangularBoard {
    
    private String player1, player2;
    private String [] [] board;
    /**
     * Makes the RectangularBoard Object.
     * @param m1 represents player-one's marker.
     * @param m2 represents player-two's marker.
     * @param rows represents the number of rows.
     * @param cols represents the number of columns.
     */
    public RectangularBoard(String m1, String m2, int rows, int cols)
    {
        player1 = m1;
        player2 = m2;
        
        board = new String[rows][cols];
    }
    /**
     * Returns player-one's marker.
     * @return the placement of player-one's marker.
     */
    public String getMarkerOne()
    {
        return player1;
    }
    /**
     * Returns player-two's marker.
     * @return the placement of player-two's marker.
     */
    public String getMarkerTwo()
    {
        return player2;
    }
    /**
     * Returns the marker placed at a certain point.
     * @param rowNum the row number.
     * @param colNum the column number.
     * @return the placement of the marker.
     */
    public String markerAt(int rowNum, int colNum)
    {
        return board[rowNum--][colNum--];
    }
    /**
     * The number of rows on the board.
     * @return the number of rows on the given row.
     */
    public int rowCount()
    {
        return board.length;
    }
    /**
     * The number of columns on the board.
     * @return the number of columns on the given board.
     */
    public int colCount()
    {
        return board[0].length;
    }
    /**
     * Custom toString() method used for the RectangularBoard class.
     * @return the information on a created RectangularBoard object which is a subclass
     * of the TicTacToe main class.
     */
    @Override
    public String toString()
    {
        String output = "";
        for(int rowNum = 0; rowNum < rowCount(); rowNum++)
        {
            for (int colNum = 0; colNum < colCount(); colNum++)
                output = output + board[rowNum][colNum]+"   ";
            output = output+"\n";
        }
        return output;
    }
    /**
     * Places a marker for either player one or two depending on whose turn.
     * @param playerNum the player whose turn it is.
     * @param rowNum row number for placement.
     * @param colNum column number for placement.
     */
    public void placeMarker(int playerNum, int rowNum, int colNum)
    {
        if(playerNum == 1)
            board[rowNum--][colNum--] = player1;
        else
            board[rowNum--][colNum--] = player2;
    }
    
}
