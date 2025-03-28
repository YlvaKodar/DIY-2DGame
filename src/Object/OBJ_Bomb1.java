package Object;

import javax.imageio.ImageIO;

public class OBJ_Bomb1 extends SuperObject{
    public OBJ_Bomb1(){
        name = "Bomb1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/bomb1.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
