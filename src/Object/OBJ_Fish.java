package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Fish extends SuperObject{
    public OBJ_Fish(GamePanel gamePanel){
        super(gamePanel);
        name = "Fish";
        down1 = setUp("/Stuff/fish.png");
    }
}
