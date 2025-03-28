package Object;

import javax.imageio.ImageIO;

public class OBJ_Bomb2 extends SuperObject{
    public OBJ_Bomb2(){
        name = "Bomb2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/bomb2.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
