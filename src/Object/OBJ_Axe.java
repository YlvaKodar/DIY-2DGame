package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Axe extends SuperObject{

    public OBJ_Axe(GamePanel gamePanel){
        name = "Axe";
        this.gamePanel = gamePanel;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/axe.png")));
            utTool.scaledImage(image, gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
