import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
public class Chest{
    ItemDrop loot;
    Random rando;
    Location loc;
    int x;
    int y;
    static BufferedImage chestFrame1,chestFrame2,chestFrame3,chestFrame4,chestFrame5,chestFrame6;
    int frameNum=0;
    public Chest(Location loc){
        rando=new Random();
        int z=rando.nextInt(4);
        switch (z) {
            case 0 -> this.loot = new Axe();
            case 1 -> this.loot = new Sword();
            case 2 -> this.loot = new Shield();
            case 3 -> this.loot = new Potion();
        }
        this.loc=loc;
        this.x=HvGPanel.tileSize*loc.getCol();
        this.y=HvGPanel.tileSize*loc.getRow();
    }
    public static void getImages() {
        try {
            chestFrame1 = ImageIO.read(new File("src/main/resources/chest frame 1.png"));
            chestFrame2 = ImageIO.read(new File("src/main/resources/chest frame 2.png"));
            chestFrame3 = ImageIO.read(new File("src/main/resources/chest frame 3.png"));
            chestFrame4 = ImageIO.read(new File("src/main/resources/chest frame 4.png"));
            chestFrame5 = ImageIO.read(new File("src/main/resources/chest frame 5.png"));
            chestFrame6 = ImageIO.read(new File("src/main/resources/chest frame 6.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D gr){
        BufferedImage image=poofFrame();
        gr.drawImage(image,x,y,HvGPanel.tileSize,HvGPanel.tileSize,null);
    }
    public BufferedImage poofFrame(){
        frameNum%=8;
        switch(frameNum){
            case 0->{
                frameNum++;
                return chestFrame1;}
            case 1->{
                frameNum++;
                return chestFrame2;}
            case 2->{
                frameNum++;
                return chestFrame3;}
            case 3->{
                frameNum++;
                return chestFrame4;}
            case 4->{
                 frameNum++;
                return chestFrame5;}
            default->{
                frameNum++;
                return chestFrame6;}
        }
    }
    public Location getLoc(){
        return loc;
    }
    public ItemDrop getLoot(){
        return loot;
    }
    @Override
    public String toString() {
        return "c";
    }
}
