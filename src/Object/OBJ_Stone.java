package Object;

import javax.imageio.ImageIO;

public class OBJ_Stone extends SuperObject{
    public OBJ_Stone(){
        name = "Stone";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/stone.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
