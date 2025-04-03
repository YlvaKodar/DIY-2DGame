package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Fish extends SuperObject{
    public OBJ_Fish(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Fish";
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/fish.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
