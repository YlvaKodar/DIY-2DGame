package Object;

import javax.imageio.ImageIO;

public class OBJ_Cream extends SuperObject{
    public OBJ_Cream(){
        name = "Cream";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/cream.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
