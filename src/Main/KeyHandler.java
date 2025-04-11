package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gamePanel;
    public boolean up, down, left, right;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //PLAY STATE
        if (gamePanel.gameState == gamePanel.playState) playState(keyCode);
        //PAUSE STATE
        else if (gamePanel.gameState == gamePanel.pauseState) pauseState(keyCode);
        //INVENTORY STATE (temp)
        else if (gamePanel.gameState == gamePanel.inventoryState) inventoryState(keyCode);


//        if (keyCode == KeyEvent.VK_P) {
//            if(gamePanel.gameState == gamePanel.playState){
//                gamePanel.gameState = gamePanel.pauseState;
//            }else if(gamePanel.gameState == gamePanel.pauseState){
//                gamePanel.gameState = gamePanel.playState;
//            }
//        }
//        //TEMP INVENTORY
//        if (keyCode == KeyEvent.VK_I) {
//            if (gamePanel.gameState == gamePanel.playState){
//                gamePanel.gameState = gamePanel.inventoryState;
//                inventoryState(keyCode);
//            }else if(gamePanel.gameState == gamePanel.inventoryState){
//                gamePanel.gameState = gamePanel.playState;
//            }
//        }


    }

    public void inventoryState(int keyCode){
        if (keyCode == KeyEvent.VK_A && gamePanel.ui.slotCol != 0) gamePanel.ui.slotCol--;
        if (keyCode == KeyEvent.VK_D && gamePanel.ui.slotCol != 5) gamePanel.ui.slotCol++;
        if (keyCode == KeyEvent.VK_I) gamePanel.gameState = gamePanel.playState;
    }

    public void playState(int keyCode){
        if (keyCode == KeyEvent.VK_W) up = true;
        if (keyCode == KeyEvent.VK_A) left = true;
        if (keyCode == KeyEvent.VK_S) down = true;
        if (keyCode == KeyEvent.VK_D) right = true;
        if (keyCode == KeyEvent.VK_P) gamePanel.gameState = gamePanel.pauseState;
        if (keyCode == KeyEvent.VK_I) gamePanel.gameState = gamePanel.inventoryState;

        //DEBUG
        //UPDATE MAP: ändra i map, rebuild med ctr + f9
        if (keyCode == KeyEvent.VK_M){
            gamePanel.tileManager.loadMap("/Maps/Map01.txt");
            System.out.println("Mmmm");
        }
    }

    public void pauseState(int keyCode){
        if (keyCode == KeyEvent.VK_P) gamePanel.gameState = gamePanel.playState;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) up = false;

        if (keyCode == KeyEvent.VK_A) left = false;

        if (keyCode == KeyEvent.VK_S) down = false;

        if (keyCode == KeyEvent.VK_D) right = false;
    }
}
