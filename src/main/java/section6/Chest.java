package section6;
import java.util.Random;
public class Chest{
    ItemDrop loot;
    Random rando;
    Location loc;
    public Chest(Location loc){
        rando=new Random();
        int x=rando.nextInt(4);
        switch(x){
            case 0:
            this.loot=new Axe();
            break;
            case 1:
                this.loot=new Sword();
                break;
            case 2:
                this.loot=new Shield();
                break;
            case 3:
                this.loot=new Potion();
                break;
        }
        this.loc=loc;
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
