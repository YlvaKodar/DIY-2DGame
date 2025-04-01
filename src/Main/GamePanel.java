package Main;

import Entity.*;
import Tile.TileManager;
import Object.SuperObject;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; //Standard
    final int scale = 3; //För att nya datorer är bättre och 16 bitar blir pyttelitet. Standard i retrospel x 3.

    public final int tileSize = originalTileSize * scale;
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = maxScreenCol * tileSize;
    public int screenHeight = maxScreenRow * tileSize;

    //WORLD SETTINGS
    public final int maxWorldCol = 65;
    public final int maxWorldRow = 49;
    public final int worldWidth = maxWorldCol * tileSize;
    public final int worldHeight = maxWorldRow * tileSize;

    //FPS = frames per second
    final int fps = 60;

    //SYSTEM
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //ENTITY AND OBJECT
    public Player player = new Player(this, keyHandler);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[5];

    //GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.PINK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true); //Fönstret kan fokusera på att få keyinput
    }

    public void setUpGame(){
        assetSetter.setObject();
        assetSetter.setNPC();
        gameState = playState;
    }

    @Override
    public void run() {

            double drawInter = 1000000000 / fps;
            double nextDrawTime = System.nanoTime() + drawInter;

         while (gameThread != null){
             //Update position etc
             update();
             //Draw updated screen
             repaint(); //This is how you call paintComponent-metod

             try {
                 double remainingTime = nextDrawTime - System.nanoTime();
                 remainingTime /= 1000000;

                 if(remainingTime < 0){
                     remainingTime = 0;
                 }

                 Thread.sleep((long) remainingTime);

                 nextDrawTime += drawInter;

             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        if (gameState == playState){
            player.update();

            for (Entity entity:npc){
                if (entity != null){
                    entity.update();
                }
            }

        }
        if (gameState == pauseState){
            //TODO
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //Convert Graphics to Graphics2D

        //TILE
        tileManager.draw(g2);   //Före player -- rita tile first, annars syns inte player för tile ritas på.

        //OBJECT
        IntStream.range(0, obj.length).filter(i -> obj[i] != null).forEach(i -> obj[i].draw(g2, this));

        //NPC
        IntStream.range(0, npc.length).filter(i -> npc[i] != null).forEach(i -> npc[i].draw(g2));

        //PLAYER
        player.draw(g2);

        //UI
        ui.draw(g2);

        g2.dispose(); //Dispose of graphic context = spar memory
    }
}
