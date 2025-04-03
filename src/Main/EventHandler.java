package Main;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class EventHandler {
    GamePanel gamePanel;
    EventRect eventRect [][]; //Liten: eventet triggas när spelaren är en bit in i tile.);

    int previousEventX, previousEventY;
    boolean canTouch = true;

    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        eventRect = new EventRect[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        int col = 0;
        int row = 0;
        while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 3;
            eventRect[col][row].height = 3;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gamePanel.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void checkEvent(){

        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX);
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gamePanel.tileSize){
            canTouch = true;
        }

        if (canTouch){
            if (hit(8, 10, "any")) { //Lägg sen event i separata metoder
                gamePanel.player.life -= 1;
                canTouch = false;
            }
        }
    }

    public boolean hit (int col, int row, String requiredDirection){
        boolean hit = false;

        gamePanel.player.bodySolidity.x = gamePanel.player.worldX + gamePanel.player.bodySolidity.x;
        gamePanel.player.bodySolidity.y = gamePanel.player.worldY + gamePanel.player.bodySolidity.y;
        eventRect[col][row].x = col * gamePanel.tileSize +  eventRect[col][row].x;
        eventRect[col][row].y = row * gamePanel.tileSize + eventRect[col][row].y;

        if(gamePanel.player.bodySolidity.intersects(eventRect[col][row]) && !(eventRect[col][row].eventDone)){
            if(gamePanel.player.direction.contentEquals(requiredDirection) || requiredDirection.contentEquals("any") ) {
                hit = true;

                previousEventX = gamePanel.player.worldX;
                previousEventY = gamePanel.player.worldY;
            }
        }

        gamePanel.player.bodySolidity.x = gamePanel.player.bodySolidityDefaultX;
        gamePanel.player.bodySolidity.y = gamePanel.player.bodySolidityDefaultY;
        eventRect[col][row].x =  eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y =  eventRect[col][row].eventRectDefaultY;

        return hit;
    }
}
