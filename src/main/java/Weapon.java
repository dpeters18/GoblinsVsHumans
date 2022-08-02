public class Weapon implements ItemDrop{
    int damageFactor=0;
    public void effect(Object obj, Object objj) {
        Human homie = (Human) obj;
        Goblin goblin = (Goblin) objj;
        int damage = (damageFactor * homie.getHealth()) / 10;
        if (damage > 0)
            goblin.setHealth(goblin.getHealth() - damage);
        else {
            goblin.setHealth(goblin.getHealth() - 1);
        }
    }
}
