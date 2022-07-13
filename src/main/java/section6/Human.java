package section6;
import java.util.*;

public class Human extends Fighter{
    boolean fightmode;
     int health = 10;
    ArrayList<ItemDrop> inventory;
    Location loca;
    public Human(Location loc)
    {    this.fightmode=false;
         this.inventory= new ArrayList<>();
         this.loca=loc;
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
    public boolean inFightmode(){
        return fightmode;
    }
    public void setFightmode(boolean bool){
        fightmode=bool;
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
