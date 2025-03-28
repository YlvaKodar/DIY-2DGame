package Main;
import Object.OBJ_Axe;
import Object.OBJ_Cream;
import Object.OBJ_Fish;
import Object.OBJ_Bomb1;
import Object.OBJ_Match;
import Object.OBJ_Stone;
import Object.OBJ_Bomb2;
import Object.OBJ_Explosion;
import Object.OBJ_Gravel;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.obj[0] = new OBJ_Axe();
        gamePanel.obj[0].worldX = 8 * gamePanel.tileSize;
        gamePanel.obj[0].worldY = 8 * gamePanel.tileSize;

        gamePanel.obj[1] = new OBJ_Stone();
        gamePanel.obj[1].worldX = 1 * gamePanel.tileSize;
        gamePanel.obj[1].worldY = 24 * gamePanel.tileSize;

        gamePanel.obj[2] = new OBJ_Cream();
        gamePanel.obj[2].worldX = 30 * gamePanel.tileSize;
        gamePanel.obj[2].worldY = 8 * gamePanel.tileSize;

        gamePanel.obj[3] = new OBJ_Fish();
        gamePanel.obj[3].worldX = 10 * gamePanel.tileSize;
        gamePanel.obj[3].worldY = 40 * gamePanel.tileSize;

        gamePanel.obj[4] = new OBJ_Bomb1();
        gamePanel.obj[4].worldX = 6 * gamePanel.tileSize;
        gamePanel.obj[4].worldY = 23 * gamePanel.tileSize;

        gamePanel.obj[5] = new OBJ_Match();
        gamePanel.obj[5].worldX = 30 * gamePanel.tileSize;
        gamePanel.obj[5].worldY = 14 * gamePanel.tileSize;
    }
}
