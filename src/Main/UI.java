package Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.text.DecimalFormat;
import Object.*;


public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, arial_80B;

    //Gammal
    BufferedImage heartImage, bombImage, matchImage, axeImage;
    int timer = 0;

    //Senare
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        //Äldre:
        OBJ_Bomb bomb = new OBJ_Bomb(gamePanel);
        OBJ_Match match = new OBJ_Match(gamePanel);
        OBJ_Heart heart = new OBJ_Heart(gamePanel);
        OBJ_Axe axe = new OBJ_Axe(gamePanel);

        bombImage = bomb.image;
        matchImage = match.image;
        heartImage = heart.image;
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

        //Första versionen minus text:
        //Hearts
        g2.drawImage(heartImage, gamePanel.tileSize/2, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 3, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 4, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 5, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 6, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 7, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 8, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(heartImage, gamePanel.tileSize/2 * 9, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);

        //Inventory
        g2.drawImage(bombImage, gamePanel.tileSize * 9, gamePanel.tileSize/6, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawString(": " + gamePanel.player.hasBomb, gamePanel.tileSize * 10, 50);
        g2.drawImage(matchImage, gamePanel.tileSize * 11, gamePanel.tileSize/6, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawString(": " + gamePanel.player.hasMatch, gamePanel.tileSize * 12, 50);
        g2.drawImage(axeImage, gamePanel.tileSize * 13, gamePanel.tileSize/6, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawString(": " + gamePanel.player.hasAxe, gamePanel.tileSize * 14, 50);

        //Timer for message:
        if(messageOn == true) {
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
            //TODO
        }
        if (gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen();
        }
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
