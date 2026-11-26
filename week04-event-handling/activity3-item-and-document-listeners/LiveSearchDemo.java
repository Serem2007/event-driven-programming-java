import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class LiveSearchDemo {
    private static final String[] FRUITS = {
        "Apple", "Apricot", "Banana", "Blueberry", "Cherry",
        "Grape", "Grapefruit", "Lemon", "Mango", "Orange",
        "Peach", "Pear", "Pineapple", "Strawberry", "Watermelon"
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Live Search Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            JTextField searchField = new JTextField();
            searchField.setFont(new Font("Arial", Font.PLAIN, 16));
            frame.add(searchField, BorderLayout.NORTH);

            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String fruit : FRUITS) listModel.addElement(fruit);
            JList<String> resultList = new JList<>(listModel);
            frame.add(new JScrollPane(resultList), BorderLayout.CENTER);

            searchField.getDocument().addDocumentListener(new DocumentListener() {
                private void filter() {
                    String query = searchField.getText().toLowerCase();
                    listModel.clear();
                    for (String fruit : FRUITS)
                        if (fruit.toLowerCase().contains(query)) listModel.addElement(fruit);
                }
                public void insertUpdate(DocumentEvent e) { filter(); }
                public void removeUpdate(DocumentEvent e) { filter(); }
                public void changedUpdate(DocumentEvent e) { }
            });
            frame.setVisible(true);
        });
    }
}
