package GameMechanics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel {
    
    Player player = new Player();


    public Panel() {
        setBorder(BorderFactory.createLineBorder(Color.black));

        

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                movePlayer(e.getX(), e.getY());
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                movePlayer(e.getX(), e.getY());
            }
        });
    }

    public void movePlayer(int x, int y) {
        
        //Current player state stored as final variables
        //to avoid repeat invocations of the same method

        final int CURR_X = player.getX();
        final int CURR_Y = player.getY();
        final int CURR_WIDTH = player.getWidth();
        final int CURR_HEIGHT = player.getHeight();
        final int OFFSET = 1;

        if ((CURR_X != x) || (CURR_Y != y)) {
            repaint(CURR_X, CURR_Y, CURR_HEIGHT + OFFSET, CURR_WIDTH + OFFSET);
            
            player.setX(x);
            player.setY(y);

            repaint(player.getX(), player.getY(), player.getWidth() + OFFSET, player.getHeight() + OFFSET);
            
        }


    }

    public Dimension getPreferredSize() {
        return new Dimension(900, 900);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw Text
        g.drawString("This is my custom panel", 10, 20);

        player.paintPlayer(g);
        gridCreation(g);

    }

    



    public void gridCreation(Graphics g)
    {
        for (int y = 0; y < (Display.PANEL_HEIGHT/Display.TILE_SIZE); y += Display.TILE_SIZE)
        {
            g.drawLine(y, 0, y, 900);

            for (int x = 0; x < (Display.PANEL_WIDTH/Display.TILE_SIZE); x += Display.TILE_SIZE)
            {
                g.drawLine(0, x, 900, x);
            }
        }
    }


}   
