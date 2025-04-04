package Object;

import Main.GamePanel;
import Entity.*;

public class OBJ_Match extends SuperObject{
    public OBJ_Match(GamePanel gamePanel){
        super(gamePanel);
        name = "Match";
        down1 = setUp("/Stuff/match.png");
        image = down1; //Temporär lösning
    }
}
