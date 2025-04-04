package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Axe extends SuperObject{

    public OBJ_Axe(GamePanel gamePanel){
        super(gamePanel);
        name = "Axe";
        down1 = setUp("/Stuff/axe.png");
        image = down1; //temporär lösning
    }
}
