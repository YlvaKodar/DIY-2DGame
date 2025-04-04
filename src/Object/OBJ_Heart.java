package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Heart extends SuperObject{
    public OBJ_Heart(GamePanel gamePanel){
        super(gamePanel);

        name = "Heart";
        image = setUp("/Stuff/heartFull.png");
        image2 = setUp("/Stuff/heartEmpty.png");
    }
}
