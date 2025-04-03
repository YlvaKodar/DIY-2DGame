package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTool {
    public BufferedImage scaledImage(BufferedImage img, int newWidth, int newHeight) {
        BufferedImage scaledImg = new BufferedImage(newWidth, newHeight, img.getType());
        Graphics2D g2 = scaledImg.createGraphics();
        g2.drawImage(img, 0, 0, newWidth, newHeight, null);
        g2.dispose();

        return scaledImg;
    }
}
