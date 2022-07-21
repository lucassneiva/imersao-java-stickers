import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class createSticker {
    public void create(InputStream inputStream, String fileName) throws Exception {
        BufferedImage originalImg = ImageIO.read(inputStream);
        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + (height * 20/100);
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        
        Font fontStyle = new Font(Font.SANS_SERIF, Font.BOLD,(width * 10/100));
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fontStyle);

        graphics.drawImage(originalImg, 0, 0, null);
        graphics.drawString("MY PRECIOUS", 100, newHeight - 300);
        

        File path = new File("assets/edit");
        if (!path.exists()) path.mkdir();
        ImageIO.write(newImg, "png", new File("assets/edit/" + fileName));
    }
}
