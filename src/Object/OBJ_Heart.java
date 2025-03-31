package Object;

import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject{
    public OBJ_Heart(){
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/heartFull.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/Stuff/heartEmpty.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
