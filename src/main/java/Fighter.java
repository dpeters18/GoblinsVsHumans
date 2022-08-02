import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

/*
This is the base class for the Human and Goblin classes.
 */
public class Fighter {
    boolean fightmode;
    static HashMap<Integer,BufferedImage> fightingFrames;
    boolean initiated;
    Location loca;
    int x,y;
    int direction;
    int frameNum=-1;
     static BufferedImage humanUp,humanDown,humanLeft,humanRight,gobUp,gobDown,gobLeft,gobRight;
    static BufferedImage humanNWalk1,humanNWalk2,humanSWalk1,humanSWalk2,goblinNWalk1,goblinNWalk2,
    goblinSWalk1,goblinSWalk2;
    static BufferedImage humanEWalk1,humanEWalk2,humanWWalk1,humanWWalk2,goblinEWalk1,goblinEWalk2,
            goblinWWalk1,goblinWWalk2;
    static BufferedImage standingFight;

    static BufferedImage axe2,axe3,axe4,gobAttack13,gobAttack2,gobAttack4,potion2,potion3,potion4,
    punch2,punch3,punch4,shield13,shield24,sword1,sword2,sword3;
    int attackID=0;
     public Fighter(){
     this.direction=0;
     this.initiated=false;
     }
    public Location getLoc(){
        return loca;
    }
    public void setLoc(Location loc){
        this.loca=loc;
    }
    public void update() {

        switch (direction) {
            case 0 ->//moving north
                    y -= 6;
            case 1 ->//moving south
                    y += 6;
            case 2 ->//moving west
                    x -= 6;
            case 3 ->//moving east
                    x += 6;
        }
        frameNum++;
    }

    public void setDirection(int x){
         direction=x;
    }

    public void draw(Graphics2D gr) {
        BufferedImage image;
         if(fightmode&&!initiated){
             image=fightFrame();
         }
         else if(fightmode){
             image=preFightFrame();
         }
         else{
             image=movementFrame();
         }
        gr.drawImage(image,x,y,HvGPanel.tileSize,HvGPanel.tileSize,null);
    }
    public BufferedImage preFightFrame(){
         return humanUp;
    }
    //makes all images to be used for goblins and humans.
    public static void getFighterImage(){
        try{
            gobDown= ImageIO.read(new File("src/main/resources/goblin_down.png"));
            gobUp= ImageIO.read(new File("src/main/resources/goblin_up.png"));
            gobLeft= ImageIO.read(new File("src/main/resources/goblin_left.png"));
            gobRight= ImageIO.read(new File("src/main/resources/Goblin_right.png"));

            humanDown= ImageIO.read(new File("src/main/resources/Human and Goblin sprites-1.png (1).png"));
            humanUp= ImageIO.read(new File("src/main/resources/Human and Goblin sprites-3.png.png"));
            humanLeft= ImageIO.read(new File("src/main/resources/Human and Goblin sprites-2.png.png"));
            humanRight = ImageIO.read(new File("src/main/resources/Human and Goblin sprites-4.png.png"));

            humanNWalk1=ImageIO.read(new File("src/main/resources/human_walking up.png.png"));
            humanNWalk2=ImageIO.read(new File("src/main/resources/human walking up 2.png.png"));
            humanSWalk1=ImageIO.read(new File("src/main/resources/human walking down.png.png"));
            humanSWalk2=ImageIO.read(new File("src/main/resources/human-walking down-2.png.png"));

            goblinNWalk1=ImageIO.read(new File("src/main/resources/goblin walking up.png.png"));
            goblinNWalk2=ImageIO.read(new File("src/main/resources/goblin walking up-2.png.png"));
            goblinSWalk1=ImageIO.read(new File("src/main/resources/goblin walking down.png.png"));
            goblinSWalk2=ImageIO.read(new File("src/main/resources/goblin walking down-2.png.png"));

            humanEWalk1=ImageIO.read(new File("src/main/resources/human walking right.png.png"));
            humanEWalk2=ImageIO.read(new File("src/main/resources/human walking right2.png.png"));
            humanWWalk1=ImageIO.read(new File("src/main/resources/human walking left.png.png"));
            humanWWalk2=ImageIO.read(new File("src/main/resources/human walking left2.png.png"));

            goblinEWalk1=ImageIO.read(new File("src/main/resources/goblin walking right.png.png"));
            goblinEWalk2=ImageIO.read(new File("src/main/resources/goblin walking right2.png.png"));
            goblinWWalk1=ImageIO.read(new File("src/main/resources/goblin walking left.png.png"));
            goblinWWalk2=ImageIO.read(new File("src/main/resources/goblin walking left2.png.png"));

            standingFight=ImageIO.read(new File("src/main/resources/standing fight.png.png"));

            axe2=ImageIO.read(new File("src/main/resources/axe2.png"));
            axe3=ImageIO.read(new File("src/main/resources/axe3.png"));
            axe4=ImageIO.read(new File("src/main/resources/axe4.png"));

            sword1=ImageIO.read(new File("src/main/resources/sword2.png"));
            sword2=ImageIO.read(new File("src/main/resources/sword3.png"));
            sword3=ImageIO.read(new File("src/main/resources/sword4.png"));

            potion2=ImageIO.read(new File("src/main/resources/potion2.png"));
            potion3=ImageIO.read(new File("src/main/resources/potion3.png"));
            potion4=ImageIO.read(new File("src/main/resources/potion4.png"));

            punch2=ImageIO.read(new File("src/main/resources/punch2.png"));
            punch3=ImageIO.read(new File("src/main/resources/punch3.png"));
            punch4=ImageIO.read(new File("src/main/resources/punch4.png"));

            shield13=ImageIO.read(new File("src/main/resources/shield13.png"));
            shield24=ImageIO.read(new File("src/main/resources/shield24.png"));

            gobAttack13=ImageIO.read(new File("src/main/resources/gobattack13.png"));
            gobAttack2=ImageIO.read(new File("src/main/resources/gobattack2.png"));
            gobAttack4=ImageIO.read(new File("src/main/resources/gobattack4.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
       Produces the hashmap that generates the images for fight animations.
       The first two digits in each int correspond to the type of combat from both fighters, while the last digit
       corresponds to the frame of the animation.
     */
    public static void makeFrameMap(){
         fightingFrames=new HashMap<>();

         fightingFrames.put(110,standingFight);
        fightingFrames.put(111,punch2);
        fightingFrames.put(112,punch3);
        fightingFrames.put(113,punch4);
        fightingFrames.put(114,shield13);
        fightingFrames.put(115,shield24);
        fightingFrames.put(116,shield13);
        fightingFrames.put(117,shield24);

        fightingFrames.put(120,standingFight);
        fightingFrames.put(121,potion2);
        fightingFrames.put(122,potion3);
        fightingFrames.put(123,potion4);
        fightingFrames.put(124,shield13);
        fightingFrames.put(125,shield24);
        fightingFrames.put(126,shield13);
        fightingFrames.put(127,shield24);

        fightingFrames.put(130,standingFight);
        fightingFrames.put(131,axe2);
        fightingFrames.put(132,axe3);
        fightingFrames.put(133,axe4);
        fightingFrames.put(134,shield13);
        fightingFrames.put(135,shield24);
        fightingFrames.put(136,shield13);
        fightingFrames.put(137,shield24);

        fightingFrames.put(140,standingFight);
        fightingFrames.put(141,sword1);
        fightingFrames.put(142,sword2);
        fightingFrames.put(143,sword3);
        fightingFrames.put(144,shield13);
        fightingFrames.put(145,shield24);
        fightingFrames.put(146,shield13);
        fightingFrames.put(147,shield24);

        fightingFrames.put(150,standingFight);
        fightingFrames.put(151,standingFight);
        fightingFrames.put(152,standingFight);
        fightingFrames.put(153,standingFight);
        fightingFrames.put(154,gobAttack13);
        fightingFrames.put(155,gobAttack2);
        fightingFrames.put(156,gobAttack13);
        fightingFrames.put(157,gobAttack4);

        fightingFrames.put(210,standingFight);
        fightingFrames.put(211,punch2);
        fightingFrames.put(212,punch3);
        fightingFrames.put(213,punch4);
        fightingFrames.put(214,gobAttack13);
        fightingFrames.put(215,gobAttack2);
        fightingFrames.put(216,gobAttack13);
        fightingFrames.put(217,gobAttack4);

        fightingFrames.put(220,standingFight);
        fightingFrames.put(221,potion2);
        fightingFrames.put(222,potion3);
        fightingFrames.put(223,potion4);
        fightingFrames.put(224,gobAttack13);
        fightingFrames.put(225,gobAttack2);
        fightingFrames.put(226,gobAttack13);
        fightingFrames.put(227,gobAttack4);

        fightingFrames.put(230,standingFight);
        fightingFrames.put(231,axe2);
        fightingFrames.put(232,axe3);
        fightingFrames.put(233,axe4);
        fightingFrames.put(234,gobAttack13);
        fightingFrames.put(235,gobAttack2);
        fightingFrames.put(236,gobAttack13);
        fightingFrames.put(237,gobAttack4);

        fightingFrames.put(240,standingFight);
        fightingFrames.put(241,sword1);
        fightingFrames.put(242,sword2);
        fightingFrames.put(243,sword3);
        fightingFrames.put(244,gobAttack13);
        fightingFrames.put(245,gobAttack2);
        fightingFrames.put(246,gobAttack13);
        fightingFrames.put(247,gobAttack4);

        fightingFrames.put(250,standingFight);
        fightingFrames.put(251,standingFight);
        fightingFrames.put(252,standingFight);
        fightingFrames.put(253,standingFight);
        fightingFrames.put(254,shield13);
        fightingFrames.put(255,shield24);
        fightingFrames.put(256,shield13);
        fightingFrames.put(257,shield24);

        fightingFrames.put(310,standingFight);
        fightingFrames.put(311,punch2);
        fightingFrames.put(312,punch3);
        fightingFrames.put(313,punch4);
        fightingFrames.put(314,standingFight);
        fightingFrames.put(315,standingFight);
        fightingFrames.put(316,standingFight);
        fightingFrames.put(317,standingFight);

        fightingFrames.put(320,standingFight);
        fightingFrames.put(321,potion2);
        fightingFrames.put(322,potion3);
        fightingFrames.put(323,potion4);
        fightingFrames.put(324,standingFight);
        fightingFrames.put(325,standingFight);
        fightingFrames.put(326,standingFight);
        fightingFrames.put(327,standingFight);

        fightingFrames.put(330,standingFight);
        fightingFrames.put(331,axe2);
        fightingFrames.put(332,axe3);
        fightingFrames.put(333,axe4);
        fightingFrames.put(334,standingFight);
        fightingFrames.put(335,standingFight);
        fightingFrames.put(336,standingFight);
        fightingFrames.put(337,standingFight);

        fightingFrames.put(340,standingFight);
        fightingFrames.put(341,sword1);
        fightingFrames.put(342,sword2);
        fightingFrames.put(343,sword3);
        fightingFrames.put(344,standingFight);
        fightingFrames.put(345,standingFight);
        fightingFrames.put(346,standingFight);
        fightingFrames.put(347,standingFight);

        fightingFrames.put(350,standingFight);
        fightingFrames.put(351,standingFight);
        fightingFrames.put(352,standingFight);
        fightingFrames.put(353,standingFight);
        fightingFrames.put(354,standingFight);
        fightingFrames.put(355,standingFight);
        fightingFrames.put(356,standingFight);
        fightingFrames.put(357,standingFight);
    }
    public BufferedImage movementFrame(){
         frameNum=frameNum%4;
        switch (frameNum) {
            case 0, 2 -> {
                frameNum++;
                return humanUp;
            }
            case 1 -> {
                frameNum++;
                return humanNWalk1;
            }
            case 3 -> {
                frameNum++;
                return humanNWalk2;
            }
            default -> throw new IllegalStateException("Unexpected value: " + frameNum);
        }
    }
    public void setAttackID(int x) {
         if(x==0)
             this.attackID=0;
        this.attackID+=x;
    }
    public BufferedImage fightFrame(){
         direction=4;
         frameNum%=8;
        return fightingFrames.get(attackID+frameNum);
    }
    public boolean inFightmode(){
        return fightmode;
    }
    public void setFightMode(boolean bool){
        fightmode=bool;
    }

    public void fightInitiated(boolean bool) {
         initiated=bool;
    }

    public boolean isInitiated() {
        return initiated;
    }
}
