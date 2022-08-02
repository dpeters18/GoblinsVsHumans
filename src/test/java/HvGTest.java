import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class HvGTest {
    Grid grid=new Grid();
    HvGSim sim=new HvGSim();
    @Test
    void display(){
     grid.displayGrid();
    }
    @Test
    void step(){
        for (int i=0;i<25;i++)
            sim.step();
    }
   @Test
    void loser(){
        ArrayList<Integer> ints = new ArrayList<>(List.of(1,2));
        for (var i:ints){
            ints.remove(i);
        }
   }

}
