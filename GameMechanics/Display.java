package GameMechanics;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;


public class Display {
    
    public final static int TILE_SIZE = 50;
    public final static int GRID_WIDTH = 18;
    public final static int GRID_HEIGHT = 18;
    public final static int PANEL_WIDTH =  GRID_WIDTH * TILE_SIZE;
    public final static int PANEL_HEIGHT = GRID_WIDTH * TILE_SIZE;


    private final static String GAME_TITLE = "Capture The Flag";
    

    private JFrame gameWindow = new JFrame();
    private Panel gamePanel = new Panel();


    public Display()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); //creates a thread to run the GUI separately on from main
            }
        });
    }


    public void createAndShowGUI()
    {
        gameWindow.setSize(PANEL_WIDTH, PANEL_HEIGHT); //Set the Size 
        gameWindow.setTitle(GAME_TITLE); //Set the Title
        gameWindow.setResizable(false);
        gameWindow.add(gamePanel); //Add our panel to JFrame
        gameWindow.pack();
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setLocationRelativeTo(null);
        gamePanel.setBackground(new Color(0x228B21)); //Set the background to green (for the grass..)
        gameWindow.setContentPane(gamePanel);
    }

    


    public static void main(String[] args)
    {
        Display d = new Display();
    }


}
