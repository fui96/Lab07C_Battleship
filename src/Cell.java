import javax.swing.*;

public class Cell extends JButton {
    //Fields
    private int row;
    private int col;
    private boolean taken;
    private boolean isHit;
    private boolean isMiss;

    //Images
    private ImageIcon Hit = new ImageIcon("src/Asset 1@0.3x.png");
    private ImageIcon Miss = new ImageIcon("src/Asset 3@0.3x.png");
    private ImageIcon Blank = new ImageIcon("src/Asset 4@0.3x.png");

    //Constructor
    public Cell(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.taken = false;
        this.isHit = false;
        this.isMiss = false;
        setIcon(Blank);
    }



    //Setters and Getters

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *
     * @return
     */
    public int getCol() {
        return col;
    }

    /**
     *
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     *
     * @return
     */
    public boolean isTaken() {
        return taken;
    }

    /**
     *
     * @param taken
     */
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    /**
     *
     * @param isHit
     */
    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public boolean isHit() {
        return isHit;
    }
    public void setIsMiss(boolean isMiss) {
        this.isMiss = isMiss;
    }
    public boolean isMiss() {
        return isMiss;
    }

    //Methods

    public void setHitImg(){
        this.setIcon(Hit);
    }
    public void setMissImg(){
        this.setIcon(Miss);
    }
    public void setBlankImg(){
        this.setIcon(Blank);
    }




}