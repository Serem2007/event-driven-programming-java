import javax.swing.*;
import java.awt.*;

public class CombinedLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Combined Layout - App Shell");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(5, 5));

            JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            toolbar.add(new JButton("New"));
            toolbar.add(new JButton("Open"));
            toolbar.add(new JButton("Save"));
            toolbar.add(new JButton("Exit"));
            frame.add(toolbar, BorderLayout.NORTH);

            JPanel sidebar = new JPanel(new GridLayout(5, 1, 5, 5));
            for (String item : new String[]{"Home","Profile","Messages","Settings","Logout"})
                sidebar.add(new JButton(item));
            frame.add(sidebar, BorderLayout.WEST);

            JPanel content = new JPanel(new GridLayout(3, 3, 10, 10));
            for (int i = 1; i <= 9; i++) content.add(new JButton("Card " + i));
            frame.add(content, BorderLayout.CENTER);

            JLabel status = new JLabel("Ready");
            status.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            frame.add(status, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
