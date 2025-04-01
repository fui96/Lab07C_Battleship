import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleshipFrame extends JFrame {
    //Panels
    JPanel mainPanel, trackerPanel,boardPanel,buttonPanel;
    //Static Buttons
    JButton quitButton,resetButton;
    //Labels
    JLabel hitLabel, strikeLabel,missLabel,totalMissLabel;
    GameLogic Game;

    public BattleshipFrame() {
        setTitle("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        Game = new GameLogic(this);

        createMainPanel();
        add(mainPanel, BorderLayout.CENTER);

        createBoardPanel();
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        createTrackerPanel();
        add(trackerPanel, BorderLayout.WEST);

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    //Create Panels
    public void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

    }
    public void createTrackerPanel() {
        trackerPanel = new JPanel();
        trackerPanel.setLayout(new GridLayout(4,1));

        hitLabel = new JLabel("TotalHits: " + Game.getHitCounter());
        strikeLabel = new JLabel("Strikes: " + Game.getStrikeCounter());
        missLabel = new JLabel("Misses: " + Game.getMissCounter());
        totalMissLabel = new JLabel("Total Misses: " + Game.getMissCounter());

        trackerPanel.add(hitLabel);
        trackerPanel.add(strikeLabel);
        trackerPanel.add(missLabel);
        trackerPanel.add(totalMissLabel);


    }
    public void updateTrackerPanel(){
        hitLabel.setText("Total Hits: " + Game.getHitCounter());
        strikeLabel.setText("Strikes: " + Game.getStrikeCounter());
        missLabel.setText("Misses: " + Game.getMissCounter());
        totalMissLabel.setText("Total Misses: " + Game.getTotalMissCounter());
    }
    public void createBoardPanel() {
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(10,10));
        Game.createBoard(boardPanel);
    }
    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));

        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent ae) -> {
            int quit = JOptionPane.showConfirmDialog(null,"Play again?");
            if (quit == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
            else{
                Game.resetGame();
            }

        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener((ActionEvent ae) -> {
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to reset?");
            if (confirm == JOptionPane.YES_OPTION) {
                Game.resetGame();
            }
        });
        buttonPanel.add(quitButton);
        buttonPanel.add(resetButton);
    }

    public static void main(String[] args) {
        BattleshipFrame frame = new BattleshipFrame();
    }


}
