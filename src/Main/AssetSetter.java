package Main;
import Entity.NPC_Rat;
import Object.OBJ_Axe;
import Object.OBJ_Cream;
import Object.OBJ_Fish;
import Object.OBJ_Bomb;
import Object.OBJ_Match;
import Object.OBJ_Stone;

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

        gamePanel.obj[2] = new OBJ_Cream(gamePanel);
        gamePanel.obj[2].worldX = 30 * gamePanel.tileSize;
        gamePanel.obj[2].worldY = 8 * gamePanel.tileSize;

        gamePanel.obj[3] = new OBJ_Fish(gamePanel);
        gamePanel.obj[3].worldX = 10 * gamePanel.tileSize;
        gamePanel.obj[3].worldY = 40 * gamePanel.tileSize;

        gamePanel.obj[4] = new OBJ_Bomb(gamePanel);
        gamePanel.obj[4].worldX = 6 * gamePanel.tileSize;
        gamePanel.obj[4].worldY = 23 * gamePanel.tileSize;

        gamePanel.obj[5] = new OBJ_Match(gamePanel);
        gamePanel.obj[5].worldX = 30 * gamePanel.tileSize;
        gamePanel.obj[5].worldY = 14 * gamePanel.tileSize;
    }

    public void setNPC(){
        gamePanel.npc[0] = new NPC_Rat(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.tileSize * 5;
        gamePanel.npc[0].worldY = gamePanel.tileSize * 5;
    }
}
