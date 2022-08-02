import java.awt.image.BufferedImage;
import java.util.*;

public class Human extends Fighter{
    boolean fightmode;
     int health = 10;
    ArrayList<ItemDrop> inventory;
    Location loca;
    public Human(Location loc)
    {  super();
        this.fightmode=false;
         this.inventory= new ArrayList<>();
         this.loca=loc;
        this.x = HvGPanel.tileSize * loca.getCol();
        this.y = HvGPanel.tileSize * loca.getRow()+6;
    }
    public BufferedImage preFightFrame() {
        if (frameNum != 8)
            return movementFrame();
        else {
            direction = 4;
            frameNum=0;
            this.x = HvGPanel.tileSize * loca.getCol();
            this.y = HvGPanel.tileSize * loca.getRow();
            return standingFight;
        }
    }

    public BufferedImage movementFrame(){
            frameNum %= 8;
        switch(direction) {
            case 0-> {
                switch (frameNum) {
                    case 0, 2 ,4,6-> {
                        return humanUp;
                    }
                    case 1,5 -> {
                        return humanNWalk1;
                    }
                    case 3,7 -> {
                        return humanNWalk2;
                    }
                }
            }
            case 1-> {
                switch (frameNum) {
                    case 0, 2,4,6 -> {
                        return humanDown;
                    }
                    case 1,5 -> {
                        return humanSWalk1;
                    }
                    case 3 ,7-> {
                        return humanSWalk2;
                    }
                }
            }
            case 2-> {
                switch (frameNum) {
                    case 0,2,4,6 -> {
                        return humanLeft;
                    }
                    case 1,5 -> {
                        return humanWWalk1;
                    }
                    case 3,7 -> {
                        return humanWWalk2;
                    }
                }
            }
            case 3-> {
                switch (frameNum) {
                    case 0, 2,4,6 -> {
                        return humanRight;
                    }
                    case 1,5-> {
                        return humanEWalk1;
                    }
                    case 3,7 -> {
                        return humanEWalk2;
                    }
                }
            }
        }
        //this shouldn't be reached. ever.
        return humanDown;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public Location getLoc(){
        return loca;
    }
    public void setLoc(Location loc){
        this.loca=loc;
    }
    public void punch(Goblin goblin){
        goblin.setHealth(goblin.getHealth()-2);
    }

    public ArrayList<ItemDrop> getInventory() {
        return inventory;
    }
    public void addItem(ItemDrop item){
        inventory.add(item);
    }
    public void removeItem(int index){
        inventory.remove(index);
    }
    @Override
    public String toString() {
        return "h";
    }

}
