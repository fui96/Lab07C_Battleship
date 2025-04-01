import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.awt.Point;
import javax.swing.*;

public class Fleet {
    //Fields
    private Board board;
    private Set<Ship> ships;
    private HashSet<Point> occupiedPoints;
    //Constructor
    public Fleet(Board board) {
        this.board = board;
        this.ships = new HashSet<>();
        this.occupiedPoints = new HashSet<>();
    }
    //Setters and Getters
    public HashSet<Point> getOccupiedPoints() {
        return occupiedPoints;
    }
    //Shipbuilders
    public void BuildCarrier(){
        Ship Carrier = new Ship(board,5);
        Carrier.buildShip(this.occupiedPoints);
        this.ships.add(Carrier);
    }
    public void BuildBattleship(){
        Ship Battleship = new Ship (board,4);
        Battleship.buildShip(this.occupiedPoints);
        this.ships.add(Battleship);
    }
    public void BuildCruiser(){
      Ship Cruiser = new Ship(board,3);
      Cruiser.buildShip(this.occupiedPoints);
      this.ships.add(Cruiser);
    }
    public void BuildSubmarine(){
        Ship Submarine = new Ship(board,3);
        Submarine.buildShip(this.occupiedPoints);
        this.ships.add(Submarine);
    }
    public void BuildDestroyer(){
        Ship Destroyer = new Ship(board,2);
        Destroyer.buildShip(this.occupiedPoints);
        this.ships.add(Destroyer);
    }
    //Deployment
    public void deployFleet(){
        BuildCarrier();
        BuildBattleship();
        BuildCruiser();
        BuildSubmarine();
        BuildDestroyer();
        UpdateBoard();
    }
    //Methods
    public void UpdateBoard(){
        for(Point p : this.occupiedPoints){
            board.markOccupied(p.x, p.y);
        }
    }

    public void clearFleet(){
        this.occupiedPoints.clear();
        this.ships.clear();
    }

    public void hitRegister(Point p){
        for(Ship s : ships){
            if(s.getCoordinates().contains(p)){
                s.registerHit();
                if(s.isSunk()){
                    JOptionPane.showMessageDialog(null,"This Ship is Sunk");
                }
            }
        }
    }
}
