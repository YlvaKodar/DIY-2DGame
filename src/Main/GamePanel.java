package Main;

import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //Standard
    final int scale = 3; //För att nya datorer är bättre och 16 bitar blir pyttelitet. Standard i retrospel x 3.

    public final int tileSize = originalTileSize * scale;
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = maxScreenCol * tileSize;
    public int screenHeight = maxScreenRow * tileSize;

    //World settings
    public final int maxWorldCol = 65;
    public final int maxWorldRow = 49;
    public final int worldWidth = maxWorldCol * tileSize;
    public final int worldHeight = maxWorldRow * tileSize;

    //FPS = frames per second
    final int fps = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.PINK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true); //Fönstret kan fokusera på att få keyinput
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
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //Convert Graphics to Graphics2D
        tileManager.draw(g2);   //Före player -- rita tile first, annars syns inte player för tile ritas på.
        player.draw(g2);
        g2.dispose(); //Dispose of graphic context = spar memory
    }
}
