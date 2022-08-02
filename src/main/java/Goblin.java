
/*

 */

import java.awt.image.BufferedImage;

public class Goblin extends Fighter{
    int strength;
    Location loc;
    int health;
    boolean locModified=false;
    boolean fightmode;
    public Goblin(int strength,int health,Location loc){
        direction=1;
        this.strength = strength;
        this.health=health;
        this.loc=loc;
        this.fightmode =false;
        this.x = HvGPanel.tileSize * loc.getCol();
        this.y = HvGPanel.tileSize * loc.getRow()-6;
    }
    public BufferedImage movementFrame() {
            frameNum %= 8;
        switch (direction) {
            case 0:
                switch (frameNum) {
                    case 0, 2, 4, 6 -> {
                        return gobUp;
                    }
                    case 1, 5 -> {
                        return goblinNWalk1;
                    }
                    case 3, 7 -> {
                        return goblinNWalk2;
                    }
                }
                break;
            case 1:
                switch (frameNum) {
                    case 0, 2, 4, 6 -> {
                        return gobDown;
                    }
                    case 1, 5 -> {
                        return goblinSWalk1;
                    }
                    case 3, 7 -> {
                        return goblinSWalk2;
                    }
                    default-> frameNum++;
                }
                break;
            case 2:
                switch (frameNum) {
                    case 0, 2, 4, 6 -> {
                        return gobLeft;
                    }
                    case 1, 5 -> {
                        return goblinWWalk1;
                    }
                    case 3, 7 -> {
                        return goblinWWalk2;
                    }
                }
                break;
            case 3:
                switch (frameNum) {
                    case 0, 2, 4, 6 -> {
                        return gobRight;
                    }
                    case 1, 5 -> {
                        return goblinEWalk1;
                    }
                    case 3, 7 -> {
                        return goblinEWalk2;
                    }
                }
                break;
        }
        return gobDown;
    }
    public BufferedImage preFightFrame() {
        if(frameNum==8) {
            direction=4;
            frameNum=0;
            this.x = HvGPanel.tileSize * loc.getCol();
            this.y = HvGPanel.tileSize * loc.getRow();
            return standingFight;
        }
        return movementFrame();
    }

    public Location getLoc(){
        return loc;
    }
    public void setLoc(Location loc){
        this.loc=loc;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }
    public void setHealth(int health) {this.health=health;}
    public void attack(Human homme)
    {
       if((((double) strength*health)/20.0)<=0)
           homme.setHealth(homme.getHealth()-1);
       else {
           homme.setHealth(homme.getHealth() - (int) (((double) strength * health) / 20.0));
       }
    }
    public void setLocModified(boolean bool){
        this.locModified=bool;
    }

    public boolean isLocModified() {
        return locModified;
    }

    @Override
    public String toString() {
        return "g";
    }
}
