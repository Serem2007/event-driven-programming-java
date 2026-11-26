import javax.swing.*;
import java.awt.*;

public class FreezeForm extends JFrame {
    private final JLabel status = new JLabel("Ready");
    private final JButton badButton = new JButton("Freeze the UI (BAD)");
    private final JButton goodButton = new JButton("Responsive task (GOOD)");

    public FreezeForm() {
        super("EDT Demo - BAD and GOOD Practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 180);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 12, 20));

        add(status);
        add(badButton);
        add(goodButton);

        badButton.addActionListener(e -> {
            status.setText("Working... UI will freeze for 5 seconds");
            try {
                Thread.sleep(5000); // BAD: blocks the Event Dispatch Thread
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            status.setText("Done! (BAD task blocked the EDT)");
        });

        goodButton.addActionListener(e -> {
            status.setText("Working in background...");
            goodButton.setEnabled(false);
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                SwingUtilities.invokeLater(() -> {
                    status.setText("Done! UI stayed responsive.");
                    goodButton.setEnabled(true);
                });
            }).start();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FreezeForm().setVisible(true));
    }
}
