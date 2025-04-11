package Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import Object.*;
import Entity.*;


public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, arial_80B;

    BufferedImage heartFull, heartEmpty, bombImage, bombLitImage, explosionImage, matchImage, axeImage;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public int slotCol = 0;
    public int slotRow = 0;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        Entity heart = new OBJ_Heart(gamePanel);
        heartFull = heart.image;
        heartEmpty = heart.image2;

        Entity bomb = new OBJ_Bomb(gamePanel);
        bombImage = bomb.image;
        bombLitImage = bomb.image2;
        explosionImage = bomb.image3;


        //Äldre:
        Entity match = new OBJ_Match(gamePanel);
        Entity axe = new OBJ_Axe(gamePanel);

        matchImage = match.image;
        axeImage = axe.image;

    }

    public void showMessage(String message) {
        this.message = message;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        //Inventory:
        drawInventory();

        //Timer for message:
        if(messageOn) {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gamePanel.tileSize/2, gamePanel.tileSize * 5);

            messageCounter++;
            if(messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }

       //Under: Senare versionen
        if(gamePanel.gameState == gamePanel.playState){
            drawPlayerLife();
        }
        if (gamePanel.gameState == gamePanel.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
    }

    public void drawInventory(){
        //FRAME
        int frameX = gamePanel.tileSize * 9;
        int frameY = gamePanel.tileSize - 44;
        int frameWidth = gamePanel.tileSize * 7 - 32;
        int frameHeight = gamePanel.tileSize + 16;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOT
        final int slotXstart = frameX + 8;
        final int slotYstart = frameY + 8;
        int slotX = slotXstart;
        int slotY = slotYstart;

        //DRAW ITEMS
        for (Entity item : gamePanel.player.inventory){
            if (item != null){
                g2.drawImage(item.image, slotX, slotY, null);
                slotX += gamePanel.tileSize;
            }
        }

        //CURSOR
        int cursorX = slotXstart + (gamePanel.tileSize * slotCol);
        int cursorY = slotYstart + (gamePanel.tileSize * slotRow);
        int cursorWidth = gamePanel.tileSize;
        int cursorHeight = gamePanel.tileSize;

        //DRAW CURSOR
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 25, 25);

    }

    public int getItemIndexFromInventory(){
        int itemIndex = slotCol + (slotRow * 5); //In case jag vill göra störe inventory sen.
        return itemIndex;
    }
    public void drawPlayerLife(){
        int x = gamePanel.tileSize/3;
        int y = gamePanel.tileSize/3;
        for (int i = 0; i < gamePanel.player.maxLife; i++){
            if (i < gamePanel.player.life){
                g2.drawImage(heartFull, x, y,null);
            }
            else
                g2.drawImage(heartEmpty, x, y,null);
            x += gamePanel.tileSize - gamePanel.tileSize/3;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 150);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x+4, y+4, width-8, height-8, 25, 25);
    }

    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gamePanel.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getXForCenteredText(String text){
        return gamePanel.screenWidth / 2 -
                ((int)g2.getFontMetrics().getStringBounds(text, g2).getWidth()/2);
    }
}
