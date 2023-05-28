package student.entry.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by erspaudel on 7:17 AM, July 08, 2022
 */
public class StudentEntry {

    private ArrayList<Student> students;
    private JFrame frame;
    private JTextField idAddTextField;
    private JTextField idSubmitTextField;
    private JTextField nameTextField;
    private JTextField projectNameTextField;
    private JTextField supervisorNameTextField;


    public StudentEntry() {
        students = new ArrayList<>();
        frame = new JFrame("Student Entry");
        frame.setSize(800, 800);
        idAddTextField = new JTextField(15);
        idSubmitTextField = new JTextField(15);
        nameTextField = new JTextField(15);
        projectNameTextField = new JTextField(15);
        supervisorNameTextField = new JTextField(15);
    }

    public void createFinalYearGUI() {
        JPanel panel = new JPanel();
        panel.setSize(600, 500);
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        GridBagConstraints gbc = new GridBagConstraints();

        Color buttonColor = new Color(1, 149, 100);
        JButton addButton = new JButton("Add Final Year");
        JButton submitButton = new JButton("Submit Final Year");
        JButton clearButton = new JButton("Clear Final Year");
        JButton displayButton = new JButton("Display Final Year");
        addButton.setForeground(buttonColor);
        submitButton.setForeground(buttonColor);
        clearButton.setForeground(buttonColor);
        displayButton.setForeground(buttonColor);

        JLabel noResultLabel = new JLabel("No data found, add some data and try again!");
        noResultLabel.setVisible(false);
        noResultLabel.setForeground(Color.RED);

        JTable displayTable = new JTable();
        displayTable.setBackground(Color.CYAN);
        JScrollPane scrollPane = new JScrollPane(displayTable);
        scrollPane.setMinimumSize(new Dimension(400, 100));
        scrollPane.setVisible(false);

        // Id label and text field
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Id"), gbc);
        gbc.gridx++;
        panel.add(idAddTextField, gbc);

        // Student name label and text field
        gbc.gridx--;
        gbc.gridy++;
        panel.add(new JLabel("Student Name"), gbc);
        gbc.gridx++;
        panel.add(nameTextField, gbc);

        // Project Name label and text field
        gbc.gridx--;
        gbc.gridy++;
        panel.add(new JLabel("Project Name"), gbc);
        gbc.gridx++;
        panel.add(projectNameTextField, gbc);

        // Add button with some margin at the bottom
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(addButton, gbc);

        // Id label and text field
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy++;
        gbc.gridx--;
        panel.add(new JLabel("Id"), gbc);
        gbc.gridx++;
        panel.add(idSubmitTextField, gbc);

        // Supervisor name and text field
        gbc.gridx--;
        gbc.gridy++;
        panel.add(new JLabel("Supervisor Name"), gbc);
        gbc.gridx++;
        panel.add(supervisorNameTextField, gbc);

        // Submit button with some margins at the bottom
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(submitButton, gbc);

        // Display button
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(displayButton, gbc);

        // Clear button
        gbc.gridy++;
        panel.add(clearButton, gbc);

        // Adding scroll pane that has jtable in it
        gbc.gridy++;
        gbc.gridx--;
        gbc.gridwidth++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(scrollPane, gbc);

        // Adding no result label
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(noResultLabel, gbc);

        idSubmitTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    FinalYear finalYear = getFinalYearStudentByID(Integer.parseInt(idSubmitTextField.getText()));
                    if (finalYear != null) {
                        JOptionPane.showMessageDialog(frame, "Student Name: " + finalYear.getName() + "\n" + "Project Name: " + finalYear.getProjectName());
                    }
                } catch (Exception ex) {

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idAddTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || projectNameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Empty field(s)");
                } else {
                    try {
                        FinalYear finalYear = new FinalYear(Integer.parseInt(idAddTextField.getText()), nameTextField.getText(), projectNameTextField.getText());
                        students.add(finalYear);
                        JOptionPane.showMessageDialog(frame, "Student ID (" + idAddTextField.getText() + ") is added.");
                        clearAddTextFields();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid Id Entered!");
                    }
                }

            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idSubmitTextField.getText().isEmpty() || supervisorNameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Empty field(s)");
                } else {
                    try {
                        int id = Integer.parseInt(idSubmitTextField.getText());
                        FinalYear finalYear = getFinalYearStudentByID(id);
                        finalYear.submit(supervisorNameTextField.getText());
                        JOptionPane.showMessageDialog(frame, "Student ID (" + idSubmitTextField.getText() + ") is submitted.");
                        clearSubmitTextFields();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid ID");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAddTextFields();
                clearSubmitTextFields();
                scrollPane.setVisible(false);
                noResultLabel.setVisible(false);
                students.clear();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] columns = {"Id", "Name", "Project", "Supervisor"};
                Object[][] data = new Object[students.size()][4];
                scrollPane.setVisible(true);

                int row = 0;
                int column = 0;
                boolean hasFinalYearObject = false;
                DefaultTableModel tableModel = new DefaultTableModel();
                for (Student student : students) {
                    if (student instanceof FinalYear) {
                        FinalYear finalYear = (FinalYear) student;
                        data[row][column++] = finalYear.getId();
                        data[row][column++] = finalYear.getName();
                        data[row][column++] = finalYear.getProjectName();
                        data[row][column++] = finalYear.getSupervisorName();
                        column = 0;
                        row++;
                        hasFinalYearObject = true;
                    }
                }

                if (hasFinalYearObject) {
                    tableModel.setDataVector(data, columns);
                    displayTable.setModel(tableModel);
                    noResultLabel.setVisible(false);
                } else {
                    noResultLabel.setVisible(true);
                    scrollPane.setVisible(false);
                }

                frame.revalidate();
            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void clearAddTextFields() {
        idAddTextField.setText("");
        nameTextField.setText("");
        projectNameTextField.setText("");
    }

    public void clearSubmitTextFields() {
        idSubmitTextField.setText("");
        supervisorNameTextField.setText("");
    }

    public FinalYear getFinalYearStudentByID(int id) {

        for (Student student : students) {
            if (student.getId() == id && student instanceof FinalYear) {
                FinalYear finalYear = (FinalYear) student;
                return finalYear;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StudentEntry myGridBagLayout = new StudentEntry();
        myGridBagLayout.createFinalYearGUI();
        myGridBagLayout.frame.setVisible(true);
    }

}
