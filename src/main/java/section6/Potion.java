package section6;

public class Potion implements ItemDrop{
    public void effect(Object obj,Object objj){
        Human human= (Human) obj;
            human.setHealth(human.getHealth()+5);
    }
}
