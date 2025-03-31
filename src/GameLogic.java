import javax.swing.*;
import java.awt.Point;
import java.util.HashSet;

public class GameLogic {

    //Fields
    private Board board;
    private Fleet fleet;
    private JPanel boardPanel;
    private int hitCounter;
    private int missCounter;

    //Constructor
    public GameLogic() {
        this.board = new Board();
        this.boardPanel = new JPanel();
        this.board.CreateBoard(boardPanel);
        this.fleet = new Fleet(board);
        this.hitCounter = 0;
        this.missCounter = 0;

    }

    public void makeMove(Cell clickButton){
        Point shot = new Point(clickButton.getRow(), clickButton.getCol());
        HashSet<Point> shipLocations = fleet.getOccupiedPoints();
        if(shipLocations.contains(shot)){
            clickButton.
        }
    }





}
