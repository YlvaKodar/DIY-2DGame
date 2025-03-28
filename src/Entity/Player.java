package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX, screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize/2); //Det här behöver vi nog ändra sedan.
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize/2); //Det är kameran.

        bodySolidity = new Rectangle(8, 22, 32, 24); //x och y: koordinater för startpixel av players solidity.

        setDefaultValues();
        getPlayerImage();
    }

    public void getPlayerImage(){
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatFrontLeft.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatFrontRight.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatBackLeft.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatBackRight.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatLeftUp.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatLeftDown.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatRightUp.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player/HeroCatRightDown.png"));

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Nåt är fel i getPlayerImage.");
        }
    }

    public void setDefaultValues() {
       worldX = gamePanel.tileSize * 11; //Här börjar spelaren
       worldY = gamePanel.tileSize * 4 ;
       speed = 4;
       direction = "down";
    }

    public void update() {

        if (keyHandler.down || keyHandler.up || keyHandler.left || keyHandler.right) {
            if (keyHandler.up) {
                direction = "up";
            }
            if (keyHandler.down) {
                direction = "down";
            }
            if (keyHandler.left) {
                direction = "left";
            }
            if (keyHandler.right) {
                direction = "right";
            }

            //CHECK TILE COLLISION ...
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            //... IF FALSE, MOVE:
            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1)
                    image = up1;
                if (spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if (spriteNum == 1)
                    image = down1;
                if (spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if (spriteNum == 1)
                    image = left1;
                if (spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                break;
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);

//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
