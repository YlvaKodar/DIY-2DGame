package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Stone extends SuperObject{
    public OBJ_Stone(GamePanel gamePanel) {
        super(gamePanel);
        name = "Stone";
        collision = true;
        down1 = setUp("/Stuff/stone.png");
        down2 = setUp("/Stuff/gravel.png");
    }
}

   // public static class SuperObject {
    //
    //    public int worldX, worldY;
    //    public Rectangle bodySolidity = new Rectangle(0, 0, 48, 48); //Ändra i subklasserna vid behov
    //    public int bodySolidityDefaultX = 0;
    //    public int bodySolidityDefaultY = 0;
    //    UtilityTool utTool = new UtilityTool();
    //    GamePanel gamePanel;
    //
    //    public void draw(Graphics2D g2, GamePanel gamePanel) {
    //        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
    //        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
    //
    //        // STOP MOVING CAMERA
    //        if(gamePanel.player.worldX < gamePanel.player.screenX) {
    //            screenX = worldX;
    //        }
    //        if(gamePanel.player.worldY < gamePanel.player.screenY) {
    //            screenY = worldY;
    //        }
    //        int rightOffset = gamePanel.screenWidth - gamePanel.player.screenX;
    //        if(rightOffset > gamePanel.worldWidth - gamePanel.player.worldX) {
    //            screenX = gamePanel.screenWidth - (gamePanel.worldWidth - worldX);
    //        }
    //        int bottomOffset = gamePanel.screenHeight - gamePanel.player.screenY;
    //        if(bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY) {
    //            screenY = gamePanel.screenHeight - (gamePanel.worldHeight - worldY);
    //        }
    //
    //
    //        if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
    //                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
    //            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    //        }
    //
    //        // If player is around the edge, draw everything
    //        else if(gamePanel.player.worldX < gamePanel.player.screenX ||
    //                gamePanel.player.worldY < gamePanel.player.screenY ||
    //                rightOffset > gamePanel.worldWidth - gamePanel.player.worldX ||
    //                bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY) {
    //            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    //        }
    //    }
  //  }
//}
