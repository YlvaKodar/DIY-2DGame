package Monster;

import Entity.Entity;
import Main.GamePanel;

import java.awt.*;

public class MON_Rat extends Entity {
    public MON_Rat(GamePanel gamePanel) {
        super(gamePanel);

        name = "Rat";
        type = 2;
        speed = 4;
        bodySolidity = new Rectangle(8, 16, 32, 32);
        bodySolidityDefaultX = bodySolidity.x;
        bodySolidityDefaultY = bodySolidity.y;

        getRatImage();
    }

    public void getRatImage() {
        down1 = setUp("/NPC/RatFrontLeft.png");
        down2 = setUp("/NPC/RatFrontRight.png");
        up1 = setUp("/NPC/RatBackLeft.png");
        up2 = setUp("/NPC/RatBackRight.png");
        left1 = setUp("/NPC/RatLeftUp.png");
        left2 = setUp("/NPC/RatLeftDown.png");
        right1 = setUp("/NPC/RatRightUp.png");
        right2 = setUp("/NPC/RatRightDown.png");
    }

    @Override
    public void setAction(){

        if (collisionOn){
            switch (direction) {
                case "up": direction = "left"; break;
                case "down": direction = "right"; break;
                case "left": direction = "down"; break;
                case "right": direction = "up";
            }
        }
    }
}
