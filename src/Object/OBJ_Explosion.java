package Object;

import javax.imageio.ImageIO;

public class OBJ_Explosion extends SuperObject{
    public OBJ_Explosion(){
        name = "Explosion";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/explosion.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
