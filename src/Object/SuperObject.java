package Object;

import Entity.*;
import Main.GamePanel;

import java.awt.*;

public class SuperObject extends Entity {

    public SuperObject(GamePanel gamePanel) {
        super(gamePanel);
        bodySolidity = new Rectangle(0, 0, 32, 32);
        bodySolidityDefaultX = bodySolidity.x;
        bodySolidityDefaultY = bodySolidity.y;
    }
}
