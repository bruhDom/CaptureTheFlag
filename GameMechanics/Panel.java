package GameMechanics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements KeyListener  {
    
    Player player = new Player();


    public enum Direction {
        UP(0, -50),
        DOWN(0, 50),
        RIGHT(50, 0),
        LEFT(-50, 0);

        public final int dx;
        public final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    public Panel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);


        
        
    }

    public void keyPressed(KeyEvent e)
    {
        System.out.println("Key Pressed: " + e.getKeyCode());
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W: 
                movePlayer(Direction.UP);
                break;
            case KeyEvent.VK_S:
                movePlayer(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                movePlayer(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                movePlayer(Direction.RIGHT);



        }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }
    
    public void movePlayer(Direction direction) {
        
        //Current player state stored as final variables
        //to avoid repeat invocations of the same method

        final int CURR_X = player.getX();
        final int CURR_Y = player.getY();
        final int CURR_WIDTH = player.getWidth();
        final int CURR_HEIGHT = player.getHeight();
        final int OFFSET = 1;

        repaint(CURR_X, CURR_Y, CURR_WIDTH + OFFSET, CURR_HEIGHT + OFFSET);

        player.setX(player.getX() + direction.dx);
        player.setY(player.getY() + direction.dy);

        repaint(player.getX(), player.getY(), CURR_WIDTH + OFFSET, CURR_HEIGHT + OFFSET);



    }

    public Dimension getPreferredSize() {
        return new Dimension(900, 900);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw Lines

        player.paintPlayer(g);
        gridCreation(g);

    }

    



    public void gridCreation(Graphics g)
    {
       
        for(int x = 0; x <= Display.PANEL_WIDTH; x+= Display.TILE_SIZE)
        {
            g.drawLine(x, 0, x, Display.PANEL_HEIGHT);
        }
        
        
        for(int y = 0; y <= Display.PANEL_HEIGHT; y+= Display.TILE_SIZE)
        {
            g.drawLine(0, y, Display.PANEL_WIDTH, y);
        }

    }


}   
