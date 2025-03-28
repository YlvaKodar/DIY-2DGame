package Object;

import javax.imageio.ImageIO;

public class OBJ_Gravel extends SuperObject{
    public OBJ_Gravel(){
        name = "Gravel";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/gravel.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
