import javax.swing.*;
import java.awt.*;

public class StudentPortalForm extends JFrame {
    public StudentPortalForm() {
        super("University Student Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(25, 55, 115));
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        JLabel title = new JLabel("University Student Portal");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        header.add(title, BorderLayout.WEST);
        JButton logout = new JButton("Logout");
        logout.setBackground(new Color(200, 60, 60));
        logout.setForeground(Color.WHITE);
        header.add(logout, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        JPanel sidebar = new JPanel(new GridLayout(6, 1, 5, 5));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(new Color(240, 240, 245));
        sidebar.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        for (String item : new String[]{"Dashboard","Courses","Grades","Fees","Timetable","Messages"}) {
            JButton button = new JButton(item);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            sidebar.add(button);
        }
        add(sidebar, BorderLayout.WEST);

        JPanel content = new JPanel(new BorderLayout(10, 15));
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel welcome = new JLabel("Welcome, John Doe!");
        welcome.setFont(new Font("Arial", Font.BOLD, 22));
        content.add(welcome, BorderLayout.NORTH);

        JPanel cards = new JPanel(new GridLayout(1, 3, 15, 15));
        cards.add(createCard("GPA", "3.75", new Color(100, 180, 100)));
        cards.add(createCard("Units", "48 / 56", new Color(80, 140, 220)));
        cards.add(createCard("Fees", "Paid", new Color(230, 150, 60)));
        content.add(cards, BorderLayout.CENTER);

        JPanel notifications = new JPanel(new GridLayout(5, 1));
        notifications.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JLabel heading = new JLabel("Notifications");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        notifications.add(heading);
        notifications.add(new JLabel("• Exam results for Semester 2 have been released"));
        notifications.add(new JLabel("• Fee payment deadline: 30th October 2026"));
        notifications.add(new JLabel("• Your timetable has been updated"));
        notifications.add(new JLabel("• Library book due for return on 12th October"));
        content.add(notifications, BorderLayout.SOUTH);
        add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(230, 230, 235));
        footer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        footer.add(new JLabel("Status: Logged in as student"), BorderLayout.WEST);
        footer.add(new JLabel("Last login: 05 Oct 2026"), BorderLayout.EAST);
        add(footer, BorderLayout.SOUTH);
    }

    private JPanel createCard(String heading, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBackground(color);
        card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel label = new JLabel(heading);
        label.setForeground(Color.WHITE);
        JLabel number = new JLabel(value, SwingConstants.CENTER);
        number.setFont(new Font("Arial", Font.BOLD, 22));
        number.setForeground(Color.WHITE);
        card.add(label, BorderLayout.NORTH);
        card.add(number, BorderLayout.CENTER);
        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentPortalForm().setVisible(true));
    }
}
