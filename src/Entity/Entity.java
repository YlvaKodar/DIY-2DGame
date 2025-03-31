package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY, speed;

    public BufferedImage  down1, down2, up1, up2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    //SOLIDITY
    public Rectangle bodySolidity;
    public int bodySolidityDefaultX, bodySolidityDefaultY;
    public boolean collisionOn = false;

    //LIFE
    public int maxLife;
    public int life;
}
