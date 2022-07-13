package section6;
/*
Just a gag class to make it easier to find the humans/goblins at an arbitrary location with the fightersAt method in
the Grid class.
 */
public class Fighter {
    boolean fightmode;
    public boolean inFightmode(){
        return fightmode;
    }
    public void setFightmode(boolean bool){
        fightmode=bool;
    }
}
