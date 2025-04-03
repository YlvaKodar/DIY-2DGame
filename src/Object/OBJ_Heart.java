package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Heart extends SuperObject{
    public OBJ_Heart(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Heart";
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/heartFull.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
            image2 = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/heartEmpty.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
