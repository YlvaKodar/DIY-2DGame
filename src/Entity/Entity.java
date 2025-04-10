package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Entity {
    GamePanel gamePanel;
    public int worldX, worldY, speed;

    public BufferedImage  down1, down2, up1, up2, left1, left2, right1, right2;
    public String direction = "down";

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int actionLockCounter = 0;

    public String name;
    public int type;

    //SOLIDITY
    public boolean collisionOn = false;
    public Rectangle bodySolidity;
    public int bodySolidityDefaultX, bodySolidityDefaultY;

    //LIFE
    public int life;
    public int maxLife;
    public boolean invincible = false;
    int incincibleCounter;

    //OBJECTS
    public BufferedImage image, image2, image3;
    public boolean collision = false;

    public Entity(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public BufferedImage setUp(String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage scaledImage = null;

        try{
            scaledImage = uTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(imagePath);
        }
        return scaledImage;
    }

    public void setAction(){
        actionLockCounter++;
        if (actionLockCounter == 80) {
            Random rand = new Random();
            int i = rand.nextInt(100) + 1;
            System.out.println(i);
            if (i <= 25) {
                direction = "right";
            } else if (i <= 50) {
                direction = "left";
            } else if (i <= 75) {
                direction = "up";
            } else {
                direction = "down";
            }
            actionLockCounter = 0;
        }
    }

    public void update(){
        setAction();

        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkObject(this, false);
        gamePanel.collisionChecker.checkEntity(this, gamePanel.npc);
        gamePanel.collisionChecker.checkEntity(this, gamePanel.mon);
        boolean contactPLayer = gamePanel.collisionChecker.checkPlayer(this);

        if (this.type == 2 && contactPLayer) {
            if (!gamePanel.player.invincible){
                gamePanel.player.life--;
                gamePanel.player.invincible = true;

            }
        }

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

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        // STOP MOVING CAMERA
        if(gamePanel.player.worldX < gamePanel.player.screenX) {
            screenX = worldX;
        }
        if(gamePanel.player.worldY < gamePanel.player.screenY) {
            screenY = worldY;
        }
        int rightOffset = gamePanel.screenWidth - gamePanel.player.screenX;
        if(rightOffset > gamePanel.worldWidth - gamePanel.player.worldX) {
            screenX = gamePanel.screenWidth - (gamePanel.worldWidth - worldX);
        }
        int bottomOffset = gamePanel.screenHeight - gamePanel.player.screenY;
        if(bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY) {
            screenY = gamePanel.screenHeight - (gamePanel.worldHeight - worldY);
        }
        ///////////////////

        switch(direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
        // If player is around the edge, draw everything
        else if(gamePanel.player.worldX < gamePanel.player.screenX ||
                gamePanel.player.worldY < gamePanel.player.screenY ||
                rightOffset > gamePanel.worldWidth - gamePanel.player.worldX ||
                bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY) {
            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
