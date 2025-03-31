package Main;
import java.awt.*;
import java.text.DecimalFormat;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, arial_80B;

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
    }

    public void showMessage(String message) {
        this.message = message;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

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
