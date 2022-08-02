import javax.swing.JPanel;
import java.awt.*;

public class HvGPanel extends JPanel{
    //change these names/dimensions after you get running code
    static int firstTileSize=24;
    static int scale=2;
    static int tileSize=firstTileSize*scale;
    static int maxScreenCol=11;
    static int maxScreenRow=11;
    static int screenWidth=tileSize*maxScreenCol;
    static int screenHeight=tileSize*maxScreenRow;
    int teamNum=0;
    int k;
    HvGSim sim;
    int frameCount =0;
    public HvGPanel(){
        this.sim=new HvGSim();
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        Fighter.getFighterImage();
        Fighter.makeFrameMap();
        Chest.getImages();
    }
    public void startGameThread(){
        this.k=0;
        run();
    }
    public void windowPosition(){
       for(Human human: sim.getGrid().getHumans())
        human.update();
       for(Goblin goblin:sim.getGrid().getMob())
           goblin.update();
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g= (Graphics2D) graphics;

        //use iterators to avoid exceptions here?
        for(Human human:sim.getGrid().getHumans()) {
            if (human.getHealth() > 0)
                human.draw(g);
        }
        for(Goblin goblin:sim.getGrid().getMob()){
            if(goblin.getHealth()>0)
                goblin.draw(g);
        }

        for(Human human:sim.getGrid().getHumans()){
            if(human.inFightmode()) {
                sim.getGrid().getChest().draw(g);
                break;
            }
        }
    }

    public void run(){
       while(k==0){
           windowPosition();
           repaint();
           if(frameCount %8==0) {
               sim.step();
           }
           try {
               Thread.sleep(83);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

           frameCount++;

           if(sim.getGrid().getHumans().isEmpty()||sim.getGrid().getMob().isEmpty()){
               if(sim.getGrid().getMob().isEmpty()){
                   teamNum=0;
               }
               else
                   teamNum=1;
               k=1;
           }
       }
    }
    public int getTeamNum() {
        return teamNum;
    }
}
