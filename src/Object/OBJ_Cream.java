package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Cream extends SuperObject{
    public OBJ_Cream(GamePanel gamePanel){
        super(gamePanel);
        name = "Cream";
        down1 = setUp("/Stuff/cream.png");
    }
}
