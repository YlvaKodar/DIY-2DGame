package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Heart extends SuperObject{
    public OBJ_Heart(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Heart";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/heartFull.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/heartEmpty.png")));
            utTool.scaledImage(image, gamePanel.tileSize, gamePanel.tileSize);
            utTool.scaledImage(image2, gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
