import javax.swing.*;

public class BattleshipFrame extends JFrame {
    public BattleshipFrame() {
        setTitle("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameLogic Game = new GameLogic();
    }
}
