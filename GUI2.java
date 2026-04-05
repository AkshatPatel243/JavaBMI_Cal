import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2 extends JFrame {

    public GUI2(Person person, GUI1 gui1) {
        setTitle("BMI Results");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        double bmi = BMICalculator.calculateBMI(person.getHeight(), person.getWeight());
        String category = BMICalculator.getCategory(bmi);
        String tip = HealthTip.getTip(category);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Your BMI Results", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel resultsPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        resultsPanel.add(new JLabel("Name:"));
        resultsPanel.add(new JLabel(person.getName()));

        resultsPanel.add(new JLabel("Age:"));
        resultsPanel.add(new JLabel(String.valueOf(person.getAge())));

        resultsPanel.add(new JLabel("BMI:"));
        resultsPanel.add(new JLabel(String.format("%.2f", bmi)));

        resultsPanel.add(new JLabel("Category:"));
        resultsPanel.add(new JLabel(category));

        resultsPanel.add(new JLabel("Health Tip:"));
        JLabel tipLabel = new JLabel("<html><body style='width:200px'>" + tip + "</body></html>");
        resultsPanel.add(tipLabel);

        mainPanel.add(resultsPanel, BorderLayout.CENTER);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Arial", Font.BOLD, 14));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                gui1.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(goBackButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
