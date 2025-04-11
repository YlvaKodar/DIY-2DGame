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
        down1 = setUp("/Monster/RatFrontLeft.png");
        down2 = setUp("/Monster/RatFrontRight.png");
        up1 = setUp("/Monster/RatBackLeft.png");
        up2 = setUp("/Monster/RatBackRight.png");
        left1 = setUp("/Monster/RatLeftUp.png");
        left2 = setUp("/Monster/RatLeftDown.png");
        right1 = setUp("/Monster/RatRightUp.png");
        right2 = setUp("/Monster/RatRightDown.png");
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
