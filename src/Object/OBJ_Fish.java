package Object;

import javax.imageio.ImageIO;

public class OBJ_Fish extends SuperObject{
    public OBJ_Fish(){
        name = "Fish";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/fish.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
