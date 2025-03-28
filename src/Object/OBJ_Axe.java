package Object;

import javax.imageio.ImageIO;

public class OBJ_Axe extends SuperObject{

    public OBJ_Axe(){
        name = "Axe";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/axe.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
