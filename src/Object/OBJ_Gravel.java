package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Gravel extends SuperObject{
    public OBJ_Gravel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Gravel";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/gravel.png")));
            utTool.scaledImage(image, gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
