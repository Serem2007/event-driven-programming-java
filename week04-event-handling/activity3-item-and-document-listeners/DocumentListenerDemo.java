import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class DocumentListenerDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Live Character Count");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            JLabel title = new JLabel("Write a short bio (max 200 chars)", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 16));
            frame.add(title, BorderLayout.NORTH);

            JTextArea bioArea = new JTextArea(8, 40);
            bioArea.setLineWrap(true);
            bioArea.setWrapStyleWord(true);
            bioArea.setFont(new Font("Arial", Font.PLAIN, 14));
            frame.add(new JScrollPane(bioArea), BorderLayout.CENTER);

            JLabel counterLabel = new JLabel("Characters: 0 / 200", SwingConstants.CENTER);
            counterLabel.setFont(new Font("Arial", Font.BOLD, 14));
            frame.add(counterLabel, BorderLayout.SOUTH);

            bioArea.getDocument().addDocumentListener(new DocumentListener() {
                private void updateCount() {
                    int length = bioArea.getText().length();
                    counterLabel.setText("Characters: " + length + " / 200");
                    counterLabel.setForeground(length > 200 ? Color.RED : Color.BLACK);
                }
                public void insertUpdate(DocumentEvent e) { updateCount(); }
                public void removeUpdate(DocumentEvent e) { updateCount(); }
                public void changedUpdate(DocumentEvent e) { }
            });
            frame.setVisible(true);
        });
    }
}
