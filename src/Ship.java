import java.awt.*;
import java.awt.List;
import java.util.*;


public class Ship {
    //Fields
    private Board board;
    private int size;
    private ArrayList<Point> Points;
    private Boolean isHorizontal;
    private Random rand = new Random();
    private int hitsRecieved;
    //Constructor
    public Ship(Board board,int size) {
        this.board = board;
        this.size = size;
        this.Points = new ArrayList<>();
        this.isHorizontal = false;
        this.rand = new Random();
        this.hitsRecieved = 0;
    }
    //Setters and Getters

    public Boolean getHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(Boolean horizontal) {
        isHorizontal = horizontal;
    }
    public void addCoordinates(int x, int y) {
        Points.add(new Point(x, y));
    }

    public ArrayList<Point> getCoordinates() {
        return Points;
    }

    //Methods

    public void registerHit(){
        hitsRecieved++;
    }

    public boolean isSunk(){
        if(hitsRecieved == size){
            return true;
        }
        return false;
    }

    public void buildShip(Set<Point> occupiedPositions){
        boolean valid = false;

        while(!valid){
            Points.clear();
            Point randPoint = new Point(rand.nextInt(10),rand.nextInt(10));
            setHorizontal(rand.nextBoolean());

            int x  = randPoint.x;
            int y  = randPoint.y;

            for(int i = 0; i < size; i++){
               int newx = isHorizontal ? x + i : x;
               int newy = isHorizontal ? y : y + i;
               Point newPoint = new Point(newx,newy);

               if(newx >= 10 || newy >= 10 ||newx < 0 || newy < 0 ||occupiedPositions.contains(newPoint)){
                   break;
               }
               else{
                   Points.add(newPoint);
               }

            }
            if(Points.size() == size){
                occupiedPositions.addAll(Points);
                valid = true;
            }
        }
    }
}
