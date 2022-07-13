package section6;
/*

 */

public class Goblin extends Fighter{
    int strength;

    Location loc;
    int health;
    boolean fightmode;
    public Goblin(int strength,int health,Location loc){
        this.strength = strength;
        this.health=health;
        this.loc=loc;
        this.fightmode=false;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }
    public void setHealth(int health) {this.health=health;}
    // ↓↓↓↓ your code goes here ↓↓↓↓
    public void attack(Human homme)
    {
       homme.setHealth(homme.getHealth()-(int)(((double) strength*health)/20.0));
    }
    public Location getLoc(){
        return loc;
    }
    public void setLoc(Location loc){
        this.loc=loc;
    }
    public boolean inFightmode(){
        return fightmode;
    }
    public void setFightmode(boolean bool){
        fightmode=bool;
    }
    @Override
    public String toString() {
        return "g";
    }
}
