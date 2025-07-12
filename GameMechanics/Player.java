package GameMechanics;

import java.awt.*;

public class Player {

    private int playerXPos = 20;
    private int playerYPos = 20;
    private int playerWidth = 50;
    private int playerHeight = 50;

    public void setX(int xPos) {
        this.playerXPos = xPos;
    }

    public int getX() {
        return playerXPos;
    }

    public void setY(int YPos) {
        this.playerYPos = YPos;
    }

    public int getY() {
        return playerYPos;
    }

    public int getWidth() {
        return playerWidth;
    }

    public int getHeight() {
        return playerHeight;
    }

    public void paintPlayer(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(playerXPos, playerYPos, playerWidth, playerHeight);
        g.setColor(Color.BLACK);
        g.drawRect(playerXPos, playerYPos, playerWidth, playerHeight);
    }



    

}
