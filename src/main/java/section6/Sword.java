package section6;

public class Sword implements ItemDrop{
    final int damageFactor= 6;
    public void effect(Object obj,Object objj) {
        Human homme = (Human) obj;
        Goblin goblin = (Goblin) objj;
        int damage=(damageFactor*homme.getHealth())/10;
        goblin.setHealth(goblin.getHealth()-damage);
    }
}
