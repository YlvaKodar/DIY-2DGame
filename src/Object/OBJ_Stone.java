package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Stone extends SuperObject{
    public OBJ_Stone(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        name = "Stone";
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/stone.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
            image2 = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/gravel.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
