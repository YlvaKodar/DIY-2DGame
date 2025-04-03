package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Bomb extends SuperObject{

    public OBJ_Bomb(GamePanel gamePanel){
        name = "Bomb";
        this.gamePanel = gamePanel;
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/bomb1.png")))
                    , gamePanel.tileSize, gamePanel.tileSize);
            image2 = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/bomb2.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
            image3 = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/explosion.png"))),
                    gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
