
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryManagementPrototype extends JFrame {

    private JLabel statusLabel;
    private JTextArea eventLog;
    private JTextField searchField;
    private DefaultListModel<String> bookModel;
    private JList<String> bookList;

    private ArrayList<String> books = new ArrayList<>();
    private ArrayList<String> borrowedBooks = new ArrayList<>();

    public LibraryManagementPrototype() {

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Sample books
        books.add("Introduction to Java");
        books.add("Database Systems");
        books.add("Computer Networks");
        books.add("Artificial Intelligence");
        books.add("Software Engineering");

        // Status label
        statusLabel = new JLabel("Library System Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.NORTH);

        // Book display
        bookModel = new DefaultListModel<>();

        for (String book : books) {
            bookModel.addElement(book + " - Available");
        }

        bookList = new JList<>(bookModel);
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        // Event log
        eventLog = new JTextArea(7, 30);
        eventLog.setEditable(false);

        // Search panel
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Book:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Control buttons
        JButton borrowButton = new JButton("Borrow Book");
        JButton returnButton = new JButton("Return Book");
        JButton refreshButton = new JButton("Refresh");

        JPanel controlPanel = new JPanel();
        controlPanel.add(borrowButton);
        controlPanel.add(returnButton);
        controlPanel.add(refreshButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(searchPanel, BorderLayout.NORTH);
        bottomPanel.add(controlPanel, BorderLayout.CENTER);
        bottomPanel.add(new JScrollPane(eventLog), BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Event Handler 1: Borrow book
        borrowButton.addActionListener(e -> {

            String selected = bookList.getSelectedValue();

            if (selected == null) {
                statusLabel.setText("Please select a book.");
                return;
            }

            String book = selected.replace(" - Available", "")
                                  .replace(" - Borrowed", "");

            if (borrowedBooks.contains(book)) {
                statusLabel.setText("Book is already borrowed.");
                return;
            }

            borrowedBooks.add(book);
            updateBookList();

            statusLabel.setText("Book borrowed successfully.");
            logEvent("Borrowed: " + book);
        });

        // Event Handler 2: Return book
        returnButton.addActionListener(e -> {

            String selected = bookList.getSelectedValue();

            if (selected == null) {
                statusLabel.setText("Please select a book.");
                return;
            }

            String book = selected.replace(" - Available", "")
                                  .replace(" - Borrowed", "");

            if (!borrowedBooks.contains(book)) {
                statusLabel.setText("This book is not borrowed.");
                return;
            }

            borrowedBooks.remove(book);
            updateBookList();

            statusLabel.setText("Book returned successfully.");
            logEvent("Returned: " + book);
        });

        // Event Handler 3: Search book
        searchButton.addActionListener(e -> {

            String query = searchField.getText().trim().toLowerCase();

            bookModel.clear();

            for (String book : books) {

                if (book.toLowerCase().contains(query)) {

                    String status = borrowedBooks.contains(book)
                            ? " - Borrowed" : " - Available";

                    bookModel.addElement(book + status);
                }
            }

            statusLabel.setText("Search completed.");
            logEvent("Searched for: " + query);
        });

        // Event Handler 4: Refresh book list
        refreshButton.addActionListener(e -> {

            searchField.setText("");
            updateBookList();

            statusLabel.setText("Book list refreshed.");
            logEvent("Book list refreshed.");
        });

        setSize(650, 450);
        setLocationRelativeTo(null);
    }

    private void updateBookList() {

        bookModel.clear();

        for (String book : books) {

            String status = borrowedBooks.contains(book)
                    ? " - Borrowed" : " - Available";

            bookModel.addElement(book + status);
        }
    }

    private void logEvent(String message) {
        eventLog.append(message + "\n");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LibraryManagementPrototype().setVisible(true);
        });
    }
}
