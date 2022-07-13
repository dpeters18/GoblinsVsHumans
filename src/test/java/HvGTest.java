import org.junit.jupiter.api.*;
import section6.Grid;
import section6.HvGSim;

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

}
