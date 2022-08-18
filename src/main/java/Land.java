import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Land {
    static BufferedImage land;
    public static void getImage(){
        //initializes land. that's it.
        try {
            land= ImageIO.read(new File("src/main/resources/land.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D gr){
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                gr.drawImage(land,i*HvGPanel.tileSize,j*HvGPanel.tileSize,
                        HvGPanel.tileSize,HvGPanel.tileSize,null);
            }
        }
    }

}
