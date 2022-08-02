import javax.swing.JFrame;
import javax.swing.*;

public class HvGWindow {


    public static void main(String[] args){

        JPanel panel1 = new JPanel();
        panel1.setVisible(true);
        int playAgain;
        String[] options1 = {"Humans", "Goblins"};
        String[] options2 = {"Yes", "No"};
        int outcome;
        do {outcome = JOptionPane.showOptionDialog(null, panel1, "5 humans and 5 goblins will fight to the death" +
                                "who do you think will win?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);
                HvGPanel panel=new HvGPanel();
                JFrame screen = new JFrame();
                screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                screen.setResizable(false);//for now
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
                screen.add(panel);
                screen.pack();
                panel.startGameThread();
                JFrame frame = new JFrame();
                if (outcome == panel.getTeamNum()) {
                    JOptionPane.showMessageDialog(frame, "You guessed right.");
                } else {
                    JOptionPane.showMessageDialog(frame, "You owe me $50. Hand it over!");
                }
                screen.dispose();
               playAgain= JOptionPane.showOptionDialog(null,"Want to play again?","",
                       JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,options2,options2[0]);
            } while(playAgain==0);
            System.exit(0);
        }
    }