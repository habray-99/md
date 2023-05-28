package summer.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by erspaudel on 5:38 PM, May 15, 2022
 */
public class MyFirstGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        JLabel label = new JLabel("Name");
        JTextField jTextField = new JTextField(20);
        JButton jButton = new JButton("Click me");
        JLabel displayLabel = new JLabel();

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText("My name is: " + jTextField.getText());
            }
        });

        frame.add(label);
        frame.add(jTextField);
        frame.add(jButton);
        frame.add(displayLabel);

        frame.setVisible(true);

    }
}
