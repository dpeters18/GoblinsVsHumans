import java.util.*;
public class Grid {
    ArrayList<Goblin> mob;
    ArrayList<Human> humans;
    Random rando=new Random();
    Chest chest;
    public Grid() {
        humans = new ArrayList<>();
        for(int i=0;i<5;i++)
            humans.add(new Human(new Location(10, 2*i+1)));
        for (Human human : humans) {
            int x = rando.nextInt(4);
            switch (x) {
                case 0:
                    human.addItem(new Sword());
                    break;
                case 1:
                    human.addItem(new Axe());
                    break;
                case 2:
                    human.addItem(new Shield());
                    break;
                case 3:
                    break;
            }
            mob = new ArrayList<>();
            for(int i=0;i<5;i++)
                mob.add(new Goblin(7, 20, new Location(0, 2*i+1)));
        }
    }

    public void displayGrid() {

        Random rando = new Random();
        int x = rando.nextInt(11);
        int y = rando.nextInt(11);
        chest = new Chest(new Location(x, y));
        boolean chestnotplaced = true;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                boolean occupied = false;

                for (Human homme : this.humans) {
                    if (homme.inFightmode() && chestnotplaced) {
                        if (chest.getLoc().getRow() == i && chest.getLoc().getCol() == j) {
                            for (Fighter fighter : fightersAt(new Location(i, j))) {
                                if (fighter instanceof Human && fighter.getLoc().equals(new Location(i, j))) {
                                    ((Human) fighter).addItem(chest.getLoot());

                                    chestnotplaced = false;
                                    break;
                                }
                            }
                            if (chestnotplaced) {
                                System.out.print(chest);
                                occupied = true;
                                chestnotplaced = false;
                            }
                        }

                    }
                    if (homme.getLoc().getRow() == i && homme.getLoc().getCol() == j && !homme.inFightmode()) {
                        System.out.print(homme);
                        occupied = true;
                    } else if (homme.getLoc().getRow() == i && homme.getLoc().getCol() == j && homme.inFightmode()) {
                        System.out.print("f");
                        occupied = true;
                    }
                }
                for (Goblin goblin : this.mob) {
                    if (goblin.getLoc().getRow() == i && goblin.getLoc().getCol() == j && !goblin.inFightmode()) {
                        System.out.print(goblin);
                        occupied = true;
                    }

                }
                if (!occupied)
                    System.out.print("~");
            }
            System.out.println();

        }
        System.out.println();
    }

    public Chest getChest() {
        return chest;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    public ArrayList<Goblin> getMob() {
        return mob;
    }

    public ArrayList<Fighter> fightersAt(Location loc) {
        ArrayList<Fighter> foo = new ArrayList<>();
        for (Human hum : this.humans) {
            if (hum.getLoc().getRow() == loc.getRow() && hum.getLoc().getCol() == loc.getCol())
                foo.add(hum);
        }
        for (Goblin goblin : this.mob) {
            if (goblin.getLoc().getRow() == loc.getRow() && goblin.getLoc().getCol() == loc.getCol())
                foo.add(goblin);
        }
        return foo;
    }//try hashmap?

    void remover(Goblin goblin) {
        for (int i = 0; i < mob.size(); i++) {
            if (goblin.getLoc().equals(mob.get(i).getLoc())) {
                mob.remove(i);
                break;
            }
        }
    }

    void remove(Human human) {
        for (int i = 0; i < humans.size(); i++) {
            if (human.getLoc().equals(humans.get(i).getLoc())) {
                humans.remove(i);
                break;
            }
        }
    }
}
