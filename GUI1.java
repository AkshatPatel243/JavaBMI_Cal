import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI1 extends JFrame {

    private JTextField nameField;
    private JTextField ageField;
    private JTextField heightField;
    private JTextField weightField;

    public GUI1() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("BMI Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Height (cm):"));
        heightField = new JTextField();
        formPanel.add(heightField);

        formPanel.add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        formPanel.add(weightField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCalculate();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void onCalculate() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String heightText = heightField.getText().trim();
        String weightText = weightField.getText().trim();

        // Empty field check
        if (name.isEmpty() || ageText.isEmpty() || heightText.isEmpty() || weightText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        double height;
        double weight;

        // Numeric format check
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            height = Double.parseDouble(heightText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Height must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            weight = Double.parseDouble(weightText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Business rule validation
        try {
            if (age <= 0) {
                throw new InvalidInputException("Age must be a positive number.");
            }
            if (height <= 0) {
                throw new InvalidInputException("Height must be a positive number.");
            }
            if (weight <= 0) {
                throw new InvalidInputException("Weight must be a positive number.");
            }
        } catch (InvalidInputException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Person person = new Person(name, age, height, weight);
        setVisible(false);
        new GUI2(person, this);
    }
}
