package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Bomb extends SuperObject{

    public OBJ_Bomb(GamePanel gamePanel){
        super(gamePanel);

        name = "Bomb";
        down1 = setUp("/Stuff/bomb1.png");
        image = down1; //temporär lösning
        image2 = setUp("/Stuff/bomb2.png");
        image3 = setUp("/Stuff/explosion.png");
    }
}
