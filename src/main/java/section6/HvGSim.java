package section6;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class HvGSim {
    Grid grid;
    Random rando=new Random();
    public HvGSim(){
        grid=new Grid();
    }
    public void iterate(){
        System.out.println("Phase 1:");
        grid.displayGrid();
        int phase=2;
        while(!grid.getHumans().isEmpty()&&!grid.getMob().isEmpty())
        {   System.out.println("Phase "+phase+":");
            step();
            phase++;
        }
    }
    public void step(){
          //human movement (randomized)
        for(Human human: grid.getHumans())
        {
            if (grid.fightersAt(human.getLoc()).stream()
                    .anyMatch(c->c.getClass().equals(Goblin.class)&&!c.inFightmode()))
                for(Fighter fighter:grid.fightersAt(human.getLoc()))
                {
                    fighter.setFightmode(true);
                }
            if (!human.inFightmode()) {
                int x=rando.nextInt(4);
                switch(x) {
                    case 0:
                        human.setLoc(north(human.getLoc(), human));
                        break;
                    case 1:
                        human.setLoc(south(human.getLoc(), human));
                        break;
                    case 2:
                        human.setLoc(west(human.getLoc(), human));
                        break;
                    case 3:
                        human.setLoc(east(human.getLoc(), human));
                        break;
                }
                if (grid.fightersAt(human.getLoc()).stream()
                        .anyMatch(c -> c.getClass().equals(Goblin.class)&&!c.inFightmode())) {
                    for (Fighter fighter : grid.fightersAt(human.getLoc())) {
                        fighter.setFightmode(true);
                    }
                }
            }

        }

                    for (Goblin goblin : grid.getMob()) {
                        for(Human human:grid.getHumans()) {
                            if(goblin.getLoc().getRow()<human.getLoc().getRow()&&!human.inFightmode()){
                                if (grid.fightersAt(goblin.getLoc()).stream()
                                        .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode()))
                                    for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                        fighter.setFightmode(true);
                                    }
                                if (!goblin.inFightmode()) {
                                    goblin.setLoc(south(goblin.getLoc(), goblin));
                                    if (grid.fightersAt(goblin.getLoc()).stream()
                                            .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode())) {
                                        for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                            fighter.setFightmode(true);
                                        }
                                    }
                                }
                                break;
                            }
                            else if(goblin.getLoc().getRow()>human.getLoc().getRow()&&!human.inFightmode()){
                                if (grid.fightersAt(goblin.getLoc()).stream()
                                        .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode()))
                                    for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                        fighter.setFightmode(true);
                                    }
                                if (!goblin.inFightmode()) {
                                    goblin.setLoc(north(goblin.getLoc(), goblin));
                                    if (grid.fightersAt(goblin.getLoc()).stream()
                                            .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode())) {
                                        for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                            fighter.setFightmode(true);
                                        }
                                    }
                                }
                                break;
                            }
                            else if(goblin.getLoc().getCol()>human.getLoc().getCol()&&!human.inFightmode()){
                                if (grid.fightersAt(goblin.getLoc()).stream()
                                        .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode()))
                                    for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                        fighter.setFightmode(true);
                                    }
                                if (!goblin.inFightmode()) {
                                    goblin.setLoc(west(goblin.getLoc(), goblin));
                                    if (grid.fightersAt(goblin.getLoc()).stream()
                                            .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode())) {
                                        for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                            fighter.setFightmode(true);
                                        }
                                    }
                                }
                                break;
                            }
                            else if(goblin.getLoc().getCol()<human.getLoc().getCol()&&!human.inFightmode()){
                                if (grid.fightersAt(goblin.getLoc()).stream()
                                        .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode()))
                                    for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                        fighter.setFightmode(true);
                                    }
                                if (!goblin.inFightmode()) {
                                    goblin.setLoc(east(goblin.getLoc(), goblin));
                                    if (grid.fightersAt(goblin.getLoc()).stream()
                                            .anyMatch(c -> c.getClass().equals(Human.class) && !c.inFightmode())) {
                                        for (Fighter fighter : grid.fightersAt(goblin.getLoc())) {
                                            fighter.setFightmode(true);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
        //for every human's turn:
        for(Human human:grid.getHumans()){
            if(human.inFightmode()){
                int x;
                Goblin opponent = (Goblin) ((grid.fightersAt(human.getLoc()).stream()
                        .filter(c -> c.getClass().equals(Goblin.class))
                        .collect(Collectors.toList()).get(0)));
                //System.out.println(opponent);
                if (human.getInventory().isEmpty()){
                    x = rando.nextInt(100);
                    if (x < 95) {
                        System.out.println(human.getHealth());
                        human.punch(opponent);
                        System.out.println("Human at " + human.getLoc() + " punched the goblin at the same " +
                                "location. Goblin took 2 damage.");
                        System.out.println("g: " + opponent.getHealth() + "\n");
                    }
                }
                else {
                    x = rando.nextInt(human.getInventory().size());
                    for (int i = 0; i < human.getInventory().size(); i++) {
                        if (i == x) {

                            System.out.println(human.getHealth());
                            if (human.getInventory().get(i) instanceof Potion
                                    && human.getHealth() <= 5) {
                                System.out.println(human.getHealth());
                                human.getInventory().get(i).effect(human, 0);
                                System.out.println("Human at coordinates " + human.getLoc() + " used a potion.");
                                human.removeItem(i);
                            } else if (human.getInventory().get(i) instanceof Axe ||
                                    human.getInventory().get(i) instanceof Sword) {
                                human.getInventory().get(i).effect(human, opponent);
                                if (human.getInventory().get(i) instanceof Axe) {
                                    System.out.println("Human at " + human.getLoc() + " used an axe. " +
                                            "Goblin at the same place took " +
                                            ((7 * human.getHealth()) / 10) + " damage.");
                                } else {

                                    System.out.println("Human at " + human.getLoc() + " used a sword. " +
                                            "Goblin at the same place took " +
                                            ((6 * human.getHealth()) / 10) + " damage.");
                                }
                            } else {
                                int y = rando.nextInt(100);
                                if (y < 95) {
                                    human.punch(opponent);
                                    System.out.println("Human at " + human.getLoc() + " punched the goblin at the same " +
                                            "location. Goblin took 2 damage.");
                                }
                            }
                            System.out.println("g: " + opponent.getHealth() + "\n");
                            break;
                        }
                    }
                }
                    //now to remove the goblin from the field if it's dead and collect any dropped items:
                        int y=opponent.getHealth();
                    System.out.println("Health: "+y);
                    if (y<=0){
                        System.out.println("Goblin at "+opponent.getLoc()+ " was killed by a " +
                                "human at the same location.");
                        grid.remover(opponent);
                        human.setFightmode(false);
                        x=rando.nextInt(4);
                        switch(x){
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
                                human.addItem(new Potion());
                                break;
                        }
                    }

            }
        }

        //now for every goblin's turn:
        for (Goblin goblin: grid.getMob()){
            if(goblin.inFightmode()) {
                int x = rando.nextInt(100);
                Human opponent = (Human) ((grid.fightersAt(goblin.getLoc()).stream()
                        .filter(c -> c.getClass().equals(Human.class))
                        .collect(Collectors.toList()).get(0)));
                if (x < 90) {
                    if (opponent.getInventory().stream()
                            .anyMatch(c -> c.getClass().equals(Shield.class))) {
                        int index = 0;
                        for (int i = 0; i < opponent.getInventory().size(); i++) {
                            if (opponent.getInventory().get(i) instanceof Shield) {
                                index = i;
                                break;
                            }
                        }
                        Shield shield = (Shield) opponent.getInventory().get(index);
                        shield.effect(opponent, 0);
                        System.out.println("Goblin at " + goblin.getLoc() + " tried to attack, but " +
                                "the human at the same location used a shield to protect itself.");
                        if (shield.getNumHits() <= 0) {
                            opponent.getInventory().remove(index);
                        }
                    }
                    else {
                         System.out.println("Goblin at "+goblin.getLoc()+" dealt "+
                                 (int)(((double) (goblin.getStrength()*goblin.getHealth()))/20.0)+ " damage" +
                                 " to the human at the same location.");
                        goblin.attack(opponent);
                        //remove the human in combat from the field if it dies
                        if (opponent.getHealth() <= 0) {
                            System.out.println("Human at "+opponent.getLoc()+ " was killed by a " +
                                    "goblin at the same location.");
                            grid.remove(opponent);
                            goblin.setFightmode(false);
                        }
                    }
                }
            }
        }
        //grid.getMob().removeIf(goblin -> goblin.getHealth() <= 0);
        //then update the grid
        grid.displayGrid();
    }
    public Location west(Location loc, Fighter fighter){
        if(loc.getCol()>0) {
            if (grid.fightersAt(new Location(loc.getRow(),
                    loc.getCol()-1)).stream().noneMatch(fighter.getClass()::isInstance))
                loc.setCol(loc.getCol() - 1);
        }
        return loc;
    }
    public Location east(Location loc, Fighter fighter){
        if(loc.getCol()<10) {
            if (grid.fightersAt(new Location(loc.getRow(),
                    loc.getCol()+1)).stream().noneMatch(fighter.getClass()::isInstance))
                loc.setCol(loc.getCol() + 1);
        }
        return loc;
    }
    public Location north(Location loc,Fighter fighter){
        if(loc.getRow()>0) {
            if (grid.fightersAt(new Location(loc.getRow()-1,
                    loc.getCol())).stream().noneMatch(fighter.getClass()::isInstance))
                loc.setRow(loc.getRow() - 1);
        }
        return loc;
    }
    public Location south(Location loc,Fighter fighter){
        if(loc.getRow()<10) {
            if (grid.fightersAt(new Location(loc.getRow()+1,
                    loc.getCol())).stream().noneMatch(fighter.getClass()::isInstance))
                loc.setRow(loc.getRow() + 1);
        }
        return loc;
    }

}