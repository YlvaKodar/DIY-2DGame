package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Cream extends SuperObject{
    public OBJ_Cream(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Cream";
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/cream.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
