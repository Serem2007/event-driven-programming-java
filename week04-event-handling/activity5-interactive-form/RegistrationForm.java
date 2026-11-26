import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {
    private final JTextField nameField = new JTextField(25);
    private final JTextField emailField = new JTextField(25);
    private final JPasswordField passwordField = new JPasswordField(25);
    private final JRadioButton maleRadio = new JRadioButton("Male");
    private final JRadioButton femaleRadio = new JRadioButton("Female");
    private final JRadioButton otherRadio = new JRadioButton("Other");
    private final ButtonGroup genderGroup = new ButtonGroup();
    private final JCheckBox sportsCheck = new JCheckBox("Sports");
    private final JCheckBox musicCheck = new JCheckBox("Music");
    private final JCheckBox readingCheck = new JCheckBox("Reading");
    private final JComboBox<String> countryBox =
            new JComboBox<>(new String[]{"Kenya", "Tanzania", "Uganda", "Rwanda"});
    private final JTextArea commentsArea = new JTextArea(3, 25);
    private final JLabel statusLabel = new JLabel("Status: Ready");

    public RegistrationForm() {
        super("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 620);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Registration Form", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        form.add(title, c);
        c.gridwidth = 1;

        addRow(form, c, 1, "Full Name:", nameField);
        addRow(form, c, 2, "Email:", emailField);
        addRow(form, c, 3, "Password:", passwordField);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderGroup.add(maleRadio); genderGroup.add(femaleRadio); genderGroup.add(otherRadio);
        genderPanel.add(maleRadio); genderPanel.add(femaleRadio); genderPanel.add(otherRadio);
        addRow(form, c, 4, "Gender:", genderPanel);

        JPanel interests = new JPanel(new FlowLayout(FlowLayout.LEFT));
        interests.add(sportsCheck); interests.add(musicCheck); interests.add(readingCheck);
        addRow(form, c, 5, "Interests:", interests);
        addRow(form, c, 6, "Country:", countryBox);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        addRow(form, c, 7, "Comments:", new JScrollPane(commentsArea));

        JPanel buttons = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN);
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        buttons.add(submitButton); buttons.add(clearButton); buttons.add(exitButton);
        c.gridx = 0; c.gridy = 8; c.gridwidth = 2;
        form.add(buttons, c);

        add(form, BorderLayout.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(statusLabel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> submitForm());
        clearButton.addActionListener(e -> clearForm());
        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) System.exit(0);
        });
    }

    private void addRow(JPanel panel, GridBagConstraints c, int row, String label, Component field) {
        c.gridy = row; c.gridx = 0; c.weightx = 0;
        panel.add(new JLabel(label), c);
        c.gridx = 1; c.weightx = 1;
        panel.add(field, c);
    }

    private void submitForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty()) { showError("Error: Please enter your name"); return; }
        if (email.isEmpty() || !email.contains("@")) { showError("Error: Please enter a valid email"); return; }
        if (password.length() < 6) { showError("Error: Password must be at least 6 characters"); return; }

        String gender = "Not specified";
        if (maleRadio.isSelected()) gender = "Male";
        else if (femaleRadio.isSelected()) gender = "Female";
        else if (otherRadio.isSelected()) gender = "Other";

        StringBuilder interests = new StringBuilder();
        if (sportsCheck.isSelected()) interests.append("Sports ");
        if (musicCheck.isSelected()) interests.append("Music ");
        if (readingCheck.isSelected()) interests.append("Reading ");
        String comments = commentsArea.getText().trim();

        String message = "Registration Successful!\n\n" +
                "Name: " + name + "\nEmail: " + email + "\nGender: " + gender +
                "\nInterests: " + (interests.length() > 0 ? interests.toString() : "None") +
                "\nCountry: " + countryBox.getSelectedItem() +
                "\nComments: " + (comments.isEmpty() ? "None" : comments);
        JOptionPane.showMessageDialog(this, message, "Registration Complete",
                JOptionPane.INFORMATION_MESSAGE);
        statusLabel.setText("Registration submitted successfully!");
        statusLabel.setForeground(new Color(0, 128, 0));
    }

    private void showError(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(Color.RED);
    }

    private void clearForm() {
        nameField.setText(""); emailField.setText(""); passwordField.setText("");
        genderGroup.clearSelection();
        sportsCheck.setSelected(false); musicCheck.setSelected(false); readingCheck.setSelected(false);
        countryBox.setSelectedIndex(0); commentsArea.setText("");
        statusLabel.setText("Status: Form cleared");
        statusLabel.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}
