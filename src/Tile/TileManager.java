package Tile;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int mapTileNum[][];

    public TileManager(GamePanel panel) {
        this.gamePanel = panel;
        tiles = new Tile[50];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("/Maps/Map01.txt");
    }

    public void getTileImage() {
        setUp(0, "danger", false);
        setUp(1, "danger", false);
        setUp(2, "danger", false);
        setUp(3, "danger", false);
        setUp(4, "danger", false);
        setUp(5, "danger", false);
        setUp(6, "danger", false);
        setUp(7, "danger", false);
        setUp(8, "danger", false);
        setUp(9, "danger", false);
        setUp(10, "wall1", true); //a
        setUp(11, "wall1", true);
        setUp(12, "grass2", false);
        setUp(13, "grass1", false); //b
        setUp(14, "water1", true);
        setUp(15, "water1", true);
        setUp(16, "riverbankNorth", true);
        setUp(17, "riverbankSouth", true);
        setUp(18, "riverbankEast", true);
        setUp(19, "riverbankWest", true);
        setUp(20, "riverbankNorthEast", true);
        setUp(21, "riverbankNorthWest", true);
        setUp(22, "riverbankSouthEast", true);
        setUp(23, "riverbankSouthWest", true);
        setUp(24, "sand", false); //d
        setUp(25, "sand", false);
        setUp(26, "sand", false);
        setUp(27, "sand", false);
        setUp(28, "sand", false);
        setUp(29, "sand", false);
        setUp(30, "sand", false);
        setUp(31, "sand", false);
        setUp(32, "sand", false);
        setUp(33, "sand", false);
        setUp(34, "earth", false); //c
        setUp(35, "earth", false);
        setUp(36, "earthbankNorth", false);
        setUp(37, "earthbankSouth", false);
        setUp(38, "earthbankEast", false);
        setUp(39, "earthbankWest", false);
        setUp(40, "earthbankNorthEast", false);
        setUp(41, "earthbankNorthWest", false);
        setUp(42, "earthbankSouthEast", false);
        setUp(43, "earthbankSouthWest", false);
        setUp(44, "appletree", true);
        setUp(45, "spruce", true);
        setUp(46, "cactus", true);
    }

    public void setUp(int index, String imageName, boolean collision){
        UtilityTool uTool = new UtilityTool();
        try{
            tiles[index] = new Tile();
            tiles[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/" + imageName + ".png")));
            tiles[index].image = uTool.scaledImage(tiles[index].image, gamePanel.tileSize, gamePanel.tileSize);
            tiles[index].collision = collision;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String path){
       try{
           InputStream is = getClass().getResourceAsStream(path);
           BufferedReader br = new BufferedReader(new InputStreamReader(is));

           int col = 0;
           int row = 0;
           while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
               String line = br.readLine();

               while (col < gamePanel.maxWorldCol) {
                   String[] numbers = line.split(" ");
                   int number = Integer.parseInt(numbers[col]);
                   mapTileNum[col][row] = number;
                   col++;
               }
               if (col == gamePanel.maxWorldCol) {
                   col = 0;
                   row++;
               }
           }
           br.close();

       }catch (Exception e) {
           System.out.println("Fel i loadMap");
           e.printStackTrace();
       }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            //World: position on map. Screen: Position on the screen.
            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX; //Om spelare är på x10, y10, ska tile x0, y0 ritas 10 upp/vänser om spelare.
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY; //På det plussas player.screenXY, som räddar kartans slut från att hamna mitt på screenen.

            //Camera move-stop:
            if (gamePanel.player.screenX > gamePanel.player.worldX){
                screenX = worldX;
            }
            if (gamePanel.player.screenY > gamePanel.player.worldY){
                screenY = worldY;
            }

            int rightOffset = gamePanel.screenWidth - gamePanel.player.screenX;
            if (rightOffset > gamePanel.worldWidth - gamePanel.player.worldX){
                screenX = gamePanel.screenWidth - (gamePanel.worldWidth - worldX);
            }
            int bottomOffset = gamePanel.screenHeight - gamePanel.player.screenY;
            if (bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY){
                screenY = gamePanel.screenHeight - (gamePanel.worldHeight - worldY);
            }

            // Rita bara om det behövs (plus en.)
            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
            worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                g2.drawImage(tiles[tileNum].image, screenX, screenY,null);
            }
            else if(gamePanel.player.screenX > gamePanel.player.worldX ||
                    gamePanel.player.screenY > gamePanel.player.worldY ||
                    rightOffset > gamePanel.worldWidth - gamePanel.player.worldX ||
                    bottomOffset > gamePanel.worldHeight - gamePanel.player.worldY){
                g2.drawImage(tiles[tileNum].image, screenX, screenY,null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
