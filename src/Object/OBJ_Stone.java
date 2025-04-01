package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Stone extends SuperObject{
    public OBJ_Stone(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        name = "Stone";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/stone.png")));
            utTool.scaledImage(image, gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
