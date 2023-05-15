import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame {
    private JButton guessButton;
    private JTextField mynumber;
    private JTextField message;
    private JTextField computerno;
    private JPanel mypanel;

    public NumberGuessingGame() {
        guessButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
               int myno = Integer.parseInt(mynumber.getText());
               int no = (int)(Math.random()*10+1);

               if(myno==no){
                   message.setText("You Win. Your Guess is Correct !!!");
               }
               else if(myno<=0 || myno>10) {
                   message.setText("Invalid Guess!!!");
               }
               else if(myno>no){
                   message.setText("Your guess is High !!!");
               }
               else if(myno<no){
                   message.setText("Your guess is Low !!!");
               }
               else{
                   message.setText("Sorry, You guessed the wrong number !!!");
               }
               computerno.setText(Integer.toString(no));
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("GuessingGame");
        frame.setContentPane(new NumberGuessingGame().mypanel);
        frame.setSize(450,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
