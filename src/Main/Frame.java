package Main;

import javax.swing.*;

public class Frame {

    JFrame frame;

    Frame(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Game");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        gamePanel.startGameThread();
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
