package Main;
import Entity.*;
import Monster.*;
import Object.*;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.obj[0] = new OBJ_Axe(gamePanel);
        gamePanel.obj[0].worldX = 8 * gamePanel.tileSize;
        gamePanel.obj[0].worldY = 8 * gamePanel.tileSize;

        gamePanel.obj[1] = new OBJ_Stone(gamePanel);
        gamePanel.obj[1].worldX = gamePanel.tileSize;
        gamePanel.obj[1].worldY = 24 * gamePanel.tileSize;

        gamePanel.obj[2] = new OBJ_Stone(gamePanel);
        gamePanel.obj[2].worldX = 31 * gamePanel.tileSize;
        gamePanel.obj[2].worldY = 23 * gamePanel.tileSize;

        gamePanel.obj[3] = new OBJ_Cream(gamePanel);
        gamePanel.obj[3].worldX = 1 * gamePanel.tileSize;
        gamePanel.obj[3].worldY = 27 * gamePanel.tileSize;

        gamePanel.obj[4] = new OBJ_Fish(gamePanel);
        gamePanel.obj[4].worldX = 10 * gamePanel.tileSize;
        gamePanel.obj[4].worldY = 25 * gamePanel.tileSize;

        gamePanel.obj[5] = new OBJ_Bomb(gamePanel);
        gamePanel.obj[5].worldX = 6 * gamePanel.tileSize;
        gamePanel.obj[5].worldY = 16 * gamePanel.tileSize;

        gamePanel.obj[6] = new OBJ_Match(gamePanel);
        gamePanel.obj[6].worldX = 24 * gamePanel.tileSize;
        gamePanel.obj[6].worldY = 18 * gamePanel.tileSize;
    }

    public void setNPC(){
    }
    public void setMonster(){
        gamePanel.mon[0] = new MON_Rat(gamePanel);
        gamePanel.mon[0].worldX = gamePanel.tileSize * 15;
        gamePanel.mon[0].worldY = gamePanel.tileSize * 10;
        gamePanel.mon[1] = new MON_Rat(gamePanel);
        gamePanel.mon[1].worldX = gamePanel.tileSize * 5;
        gamePanel.mon[1].worldY = gamePanel.tileSize * 5;
        gamePanel.mon[2] = new MON_Rat(gamePanel);
        gamePanel.mon[2].worldX = gamePanel.tileSize * 10;
        gamePanel.mon[2].worldY = gamePanel.tileSize * 15;
        gamePanel.mon[3] = new MON_Rat(gamePanel);
        gamePanel.mon[3].worldX = gamePanel.tileSize * 30;
        gamePanel.mon[3].worldY = gamePanel.tileSize * 23;
        gamePanel.mon[4] = new MON_Rat(gamePanel);
        gamePanel.mon[4].worldX = gamePanel.tileSize * 24;
        gamePanel.mon[4].worldY = gamePanel.tileSize * 18;
        gamePanel.mon[5] = new MON_Rat(gamePanel);
        gamePanel.mon[5].worldX = gamePanel.tileSize * 30;
        gamePanel.mon[5].worldY = gamePanel.tileSize * 8;
        gamePanel.mon[6] = new MON_Rat(gamePanel);
        gamePanel.mon[6].worldX = gamePanel.tileSize * 10;
        gamePanel.mon[6].worldY = gamePanel.tileSize * 25;
        gamePanel.mon[7] = new MON_Rat(gamePanel);
        gamePanel.mon[7].worldX = gamePanel.tileSize * 30;
        gamePanel.mon[7].worldY = gamePanel.tileSize * 22;

    }
}
