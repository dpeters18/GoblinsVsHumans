package section6;
import java.util.*;
public class HvGMain {
    public static void main(String[] args){
                    System.out.println("In this simulation game, 5 goblins and 5 humans will fight to the death. \n" +
                            "The humans start out with either nothing, a sword, an axe, or a shield. Are you ready?\n" +
                            "(Please type 'yes' to start)");
                    Scanner scan=new Scanner(System.in);
                    String input=scan.nextLine();
                    while(!input.equals("yes")){
                        System.out.println("Please type 'yes' to start the simulation.");
                        input=scan.nextLine();
                    }
                    HvGSim sim=new HvGSim();
                    sim.iterate();
                    System.out.println("Would you like to start another fight?\n"+
                            "(Please type 'yes' to restart, 'no' to cancel)");
                       input=scan.nextLine();
                   while(!input.equals("no")){
                   if(!input.equals("yes")){
                       System.out.println("(Please type 'yes' to restart, 'no' to cancel)");
                   }
                   else{
                       sim=new HvGSim();
                       sim.iterate();
                       System.out.println("Would you like to start another fight?\n"+
                               "(Please type 'yes' to restart, 'no' to cancel)");
                   }
                       input=scan.nextLine();
                   }
                }
            }

