package week20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentEntryGUI {

    private JFrame frame;
    private JPanel panel;
    private ArrayList<String> names;
    private JTextField nameTextField;
    private JButton addButton;
    private JButton removeButton;
    private JButton displayButton;
    private JButton clearButton;
    private JLabel displayLabel;

    public void createGUI() {
        names = new ArrayList<>();
        frame = new JFrame("Student Entry");
        nameTextField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        displayButton = new JButton("Display");
        clearButton = new JButton("Clear");
        displayLabel = new JLabel();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth++;

        panel.add(nameTextField, gridBagConstraints);

        gridBagConstraints.gridwidth--;
        gridBagConstraints.gridy++;
        panel.add(addButton, gridBagConstraints);

        gridBagConstraints.gridx++;
        panel.add(removeButton, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx--;
        panel.add(displayButton, gridBagConstraints);

        gridBagConstraints.gridx++;
        panel.add(clearButton, gridBagConstraints);

        gridBagConstraints.gridwidth++;
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx--;
        panel.add(displayLabel, gridBagConstraints);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                names.add(nameTextField.getText());
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                names.remove(nameTextField.getText());
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(names.toString());
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                displayLabel.setText("");
                names.clear();
            }
        });

        frame.add(panel);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StudentEntryGUI studentEntryGUI = new StudentEntryGUI();
        studentEntryGUI.createGUI();
    }
}
