package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int mapTileNum[][];

    public TileManager(GamePanel panel) {
        this.gamePanel = panel;
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("/Maps/Map01.txt");
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass1.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall1.png"));
            tiles[1].collision = true;
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water1.png"));
            tiles[2].collision = true;
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/spruce.png"));
            tiles[5].collision = true;
            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/appletree.png"));
            tiles[6].collision = true;
            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/cactus.png"));
            tiles[7].collision = true;

        }catch (Exception e) {
            System.out.println("Fel i tileManager");
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

            // Rita bara om det behövs (plus en.)
            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
            worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                g2.drawImage(tiles[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
