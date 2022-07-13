package section6;

public class Axe implements ItemDrop{

    final int damageFactor= 7;
    public void effect(Object obj,Object objj) {
        Human homme = (Human) obj;
        Goblin goblin = (Goblin) objj;
        int damage=(int)(((double)(damageFactor* homme.getHealth()))/10.0);
        goblin.setHealth(goblin.getHealth()-damage);
    }
}
