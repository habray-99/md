package week20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GridLayoutGuessGame implements ActionListener {

    private JFrame frame;
    private int randomNumber = 0;
    private int incorrectAttempts = 0;

    public void go() {
        Random random = new Random();
        randomNumber = random.nextInt(10);
        frame = new JFrame();
        frame.setLayout(new GridLayout(3, 3));
        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            frame.add(button);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (incorrectAttempts > 2) {
            JOptionPane.showMessageDialog(frame, "Incorrect Guess, Game Over");
            return;
        }
        String button = e.getActionCommand();
        int buttonValue = Integer.parseInt(button);
        if (randomNumber != buttonValue) {
            incorrectAttempts++;
        } else {
            JOptionPane.showMessageDialog(frame, "Correct Guess");
        }
    }

    public static void main(String[] args) {
        new GridLayoutGuessGame().go();
    }
}
