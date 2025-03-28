package Object;

import javax.imageio.ImageIO;

public class OBJ_Match extends SuperObject{
    public OBJ_Match(){
        name = "Match";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Stuff/match.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
