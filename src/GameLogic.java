import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GameLogic {

    //Fields
    private Board board;
    private Fleet fleet;
    private JPanel boardPanel;
    private int hitCounter;
    private int missCounter;
    private int strikeCounter;
    private int totalMissCounter;
    private BattleshipFrame Frame;

    //Constructor
    public GameLogic(BattleshipFrame Frame) {
        this.board = new Board(this);
        this.boardPanel = new JPanel();
        this.fleet = new Fleet(board);
        this.hitCounter = 0;
        this.missCounter = 0;
        this.strikeCounter = 0;
        this.totalMissCounter = 0;
        this.Frame = Frame;
    }
    public void createBoard(JPanel boardPanel) {
        board.CreateBoard(boardPanel);
        fleet.deployFleet();
    }
    public void resetGame(){
        board.ResetBoard();
        setMissCounter(0);
        setStrikeCounter(0);
        setHitCounter(0);
        setTotalMissCounter(0);
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;

    }
    public void setMissCounter(int missCounter) {
        this.missCounter = missCounter;
    }
    public void setStrikeCounter(int strikeCounter) {
        this.strikeCounter = strikeCounter;
    }
    public void setTotalMissCounter(int totalMissCounter) {
        this.totalMissCounter = totalMissCounter;
    }

    public int getHitCounter() {
        return hitCounter;
    }
    public int getMissCounter() {
        return missCounter;
    }
    public int getStrikeCounter() {
        return strikeCounter;
    }
    public int getTotalMissCounter() {
        return totalMissCounter;
    }



    public void makeMove(Cell clickButton) {
        Point shot = new Point(clickButton.getRow(), clickButton.getCol());
        HashSet<Point> shipLocations = fleet.getOccupiedPoints();
        if (hitCounter >= shipLocations.size()) {
            int reset = JOptionPane.showConfirmDialog(null,"You Won! Would you like to play again?");
            if(reset == JOptionPane.YES_OPTION) {
                resetGame();
            }
            else if(reset == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
            }
        if(strikeCounter >= 3){
            int reset = JOptionPane.showConfirmDialog(null,"You have lost! Would you like to play again?");
            if(reset == JOptionPane.YES_OPTION) {
                resetGame();
            }
            else if(reset == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
            if (!clickButton.isMiss() && !clickButton.isHit()) {

                if (shipLocations.contains(shot)) {
                    clickButton.setHitImg();
                    fleet.hitRegister(shot);
                    hitCounter++;
                    setMissCounter(0);
                } else {
                    clickButton.setMissImg();
                    missCounter++;
                    totalMissCounter++;
                    if (missCounter == 5) {
                        strikeCounter++;
                        missCounter = 0;
                    }
                }
                Frame.updateTrackerPanel();
            }

        }

}
