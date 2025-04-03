package Object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Match extends SuperObject{
    public OBJ_Match(GamePanel gamePanel){
        name = "Match";
        this.gamePanel = gamePanel;
        try {
            image = utTool.scaledImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Stuff/match.png"))),
            gamePanel.tileSize, gamePanel.tileSize);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
