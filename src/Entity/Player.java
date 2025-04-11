package Entity;

import Main.*;
import Object.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity{

    KeyHandler keyHandler;

    public final int screenX, screenY;

    //Hur vill jag göra med det här?
    public int hasBomb = 0;
    public int hasMatch = 0;
    public int hasAxe = 0;

    public ArrayList<SuperObject> inventory = new ArrayList<SuperObject>();
    public final int maxInventorySize = 5;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(gamePanel);
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize/2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize/2); //Det är kameran.

        bodySolidity = new Rectangle(8, 22, 32, 24); //x och y: koordinater för startpixel av players solidity.
        bodySolidityDefaultX = bodySolidity.x;
        bodySolidityDefaultY = bodySolidity.y;
        setDefaultValues();
        getPlayerImage();
        setItems();
    }

    public void getPlayerImage(){
        down1 = setUp("/Player/HeroCatFrontLeft.png");
        down2 = setUp("/Player/HeroCatFrontRight.png");
        up1 = setUp("/Player/HeroCatBackLeft.png");
        up2 = setUp("/Player/HeroCatBackRight.png");
        left1 = setUp("/Player/HeroCatLeftUp.png");
        left2 = setUp("/Player/HeroCatLeftDown.png");
        right1 = setUp("/Player/HeroCatRightUp.png");
        right2 = setUp("/Player/HeroCatRightDown.png");
    }

    public void setDefaultValues() {
       worldX = gamePanel.tileSize * 11; //Här börjar spelaren
       worldY = gamePanel.tileSize * 4 ;
       speed = 4;
       direction = "down";
       maxLife = 9;
       life = maxLife;
    }

    public void setItems(){
        //OM JAG VIL HA FRÅN BÖRJAN?
    }

    @Override
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

            //CHECK OBJECT COLLISION ...
            int objIndex = gamePanel.collisionChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //CHECK NPC COLLISION ...
            int entityIndex = gamePanel.collisionChecker.checkEntity(this, gamePanel.npc);
            interactEntity(entityIndex);

            //CHECK MONSTER COLLISION ...
            int monIndex = gamePanel.collisionChecker.checkEntity(this, gamePanel.mon);
            monsterContact(monIndex);

            //CHECK EVENT
            gamePanel.eventHandler.checkEvent();

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
        if (invincible){
            incincibleCounter++;
            if (incincibleCounter > 60) {
                incincibleCounter = 0;
                invincible = false;
            }
        }
    }

    public void pickUpObject(int index) {

        if (index != 999){
            String objectName = gamePanel.obj[index].name;

            switch (objectName) {
                case "Bomb":
                    if (inventory.size() < maxInventorySize) {
                        inventory.add(new OBJ_Bomb(gamePanel));
                        hasBomb++;
                        gamePanel.obj[index] = null;
                    } else
                        gamePanel.ui.showMessage("Inventory full.");
                    break;
                case "Stone":
                    if(hasBomb > 0 && hasMatch > 0) {//Ska först brinna och sprängas obvi.
                        hasMatch--;
                        hasBomb--;
                        gamePanel.obj[index] = null;
                    }
                    System.out.println("Bombs: " + hasBomb + " Matches: " + hasMatch);
                    break;
                case "Cream":
                    speed -= 1;
                    gamePanel.obj[index] = null;
                    break;
                case "Fish":
                    speed += 1;
                    gamePanel.obj[index] = null;
                    break;
                case "Match":
                    if (inventory.size() < maxInventorySize) {
                        inventory.add(new OBJ_Match(gamePanel));
                        hasMatch++;
                        gamePanel.obj[index] = null;
                    } else
                        gamePanel.ui.showMessage("Inventory full.");
                    break;
                case "Axe":
                    if (inventory.size() < maxInventorySize) {
                        inventory.add(new OBJ_Axe(gamePanel));
                        hasAxe++;
                        gamePanel.obj[index] = null;
                    } else
                        gamePanel.ui.showMessage("Inventory full.");
                    break;
            }
        }
    }

    public void interactEntity(int entityIndex) {
        if (entityIndex != 999) {
            System.out.println("You dead.");
        }
    }

    public void monsterContact(int monIndex) {
        if (monIndex != 999){
            if (!invincible){
                life -= 1;
                invincible = true;
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

        int x = screenX;
        int y = screenY;

        if(screenX > worldX){
            x = worldX;
        }
        if(screenY > worldY){
            y = worldY;
        }

        int rightOffset = gamePanel.screenWidth - screenX;
        if (rightOffset > gamePanel.worldWidth - worldX){
            x = gamePanel.screenWidth - (gamePanel.worldWidth - worldX);
        }
        int bottomOffset = gamePanel.screenHeight - screenY;
        if (bottomOffset > gamePanel.worldHeight - worldY){
            y = gamePanel.screenHeight - (gamePanel.worldHeight - worldY);
        }

        if (invincible){
            if (incincibleCounter % 6 == 0){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
            }
        }

        g2.drawImage(image, x, y, null);
        //RESET ALPHA
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        //DEBUG
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        g2.setColor(Color.WHITE);
//        g2.drawString("Invinciblecounter: " + incincibleCounter, 10, 400);
    }
}
