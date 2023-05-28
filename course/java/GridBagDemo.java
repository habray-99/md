package summer.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by erspaudel on 7:21 AM, May 24, 2022
 */
public class GridBagDemo {

    private JFrame frame;
    private JTextField number1TextField;
    private JTextField number2TextField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel resultLabel;

    public GridBagDemo() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        number1TextField = new JTextField(10);
        number2TextField = new JTextField(10);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        resultLabel = new JLabel();
    }

    public void createGUI() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        frame.add(number1TextField, gbc);

        gbc.gridx++;
        frame.add(number2TextField, gbc);

        gbc.gridy++;
        gbc.gridx--;
        frame.add(addButton, gbc);

        gbc.gridx++;
        frame.add(subtractButton, gbc);

        gbc.gridy++;
        gbc.gridx--;
        frame.add(multiplyButton, gbc);

        gbc.gridx++;
        frame.add(divideButton, gbc);

        gbc.gridy++;
        gbc.gridx--;
        gbc.gridwidth++;
        frame.add(resultLabel, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = getNumber1() + getNumber2();
                resultLabel.setText("Addition Result: " + result);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = getNumber1() - getNumber2();
                resultLabel.setText("Subtraction Result: " + result);
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = getNumber1() * getNumber2();
                resultLabel.setText("Multiplication Result: " + result);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = getNumber1() / getNumber2();
                resultLabel.setText("Division Result: " + result);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GridBagDemo gridBagDemo = new GridBagDemo();
        gridBagDemo.createGUI();
    }

    public double getNumber1() {
        return Integer.parseInt(number1TextField.getText());
    }

    public double getNumber2() {
        return Integer.parseInt(number2TextField.getText());
    }
}
