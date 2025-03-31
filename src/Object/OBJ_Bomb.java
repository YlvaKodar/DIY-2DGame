package Object;

import javax.imageio.ImageIO;

public class OBJ_Bomb extends SuperObject{

    public OBJ_Bomb(){
        name = "Bomb";
        try {
                image = ImageIO.read(getClass().getResourceAsStream("/Stuff/bomb1.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
