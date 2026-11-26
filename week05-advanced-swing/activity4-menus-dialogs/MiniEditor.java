import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;

public class MiniEditor {
    private JFrame frame;
    private JTextArea textArea;
    private File currentFile;
    private JLabel statusBar;
    private JLabel wordCountLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniEditor().createAndShow());
    }

    private void createAndShow() {
        frame = new JFrame("Mini Editor — Untitled");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open...");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As...");
        JMenuItem exitItem = new JMenuItem("Exit");
        file.add(newItem); file.add(openItem); file.add(saveItem);
        file.add(saveAsItem); file.addSeparator(); file.add(exitItem);

        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        edit.add(cut); edit.add(copy); edit.add(paste);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        bar.add(file); bar.add(edit); bar.add(help);
        frame.setJMenuBar(bar);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        wordCountLabel = new JLabel("0");
        toolbar.add(newButton); toolbar.add(openButton); toolbar.add(saveButton);
        toolbar.addSeparator(); toolbar.add(new JLabel("  Word count: "));
        toolbar.add(wordCountLabel);
        frame.add(toolbar, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        statusBar = new JLabel("Ready");
        statusBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        frame.add(statusBar, BorderLayout.SOUTH);

        Runnable newAction = () -> {
            textArea.setText("");
            currentFile = null;
            frame.setTitle("Mini Editor — Untitled");
            statusBar.setText("New file created");
        };
        Runnable saveAsAction = () -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                if (!currentFile.getName().toLowerCase().endsWith(".txt"))
                    currentFile = new File(currentFile.getParentFile(), currentFile.getName() + ".txt");
                writeCurrentFile();
            }
        };
        Runnable saveAction = () -> {
            if (currentFile == null) saveAsAction.run();
            else writeCurrentFile();
        };
        Runnable openAction = () -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                try {
                    textArea.setText(Files.readString(currentFile.toPath()));
                    frame.setTitle("Mini Editor — " + currentFile.getName());
                    statusBar.setText("Opened: " + currentFile.getName());
                } catch (IOException ex) { showError("Error opening file: " + ex.getMessage()); }
            }
        };

        newItem.addActionListener(e -> newAction.run());
        newButton.addActionListener(e -> newAction.run());
        openItem.addActionListener(e -> openAction.run());
        openButton.addActionListener(e -> openAction.run());
        saveItem.addActionListener(e -> saveAction.run());
        saveButton.addActionListener(e -> saveAction.run());
        saveAsItem.addActionListener(e -> saveAsAction.run());
        exitItem.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(frame,
                    "Exit without saving? Unsaved changes will be lost.",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        about.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Mini Editor v1.0\nBuilt with Java Swing\nWeek 5 Activity 4",
                "About", JOptionPane.INFORMATION_MESSAGE));
        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateWordCount(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateWordCount(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateWordCount(); }
            private void updateWordCount() {
                String value = textArea.getText().trim();
                wordCountLabel.setText(value.isEmpty() ? "0" : String.valueOf(value.split("\\s+").length));
            }
        });
        frame.setVisible(true);
    }

    private void writeCurrentFile() {
        try {
            Files.writeString(currentFile.toPath(), textArea.getText());
            frame.setTitle("Mini Editor — " + currentFile.getName());
            statusBar.setText("Saved: " + currentFile.getName());
        } catch (IOException ex) { showError("Error saving: " + ex.getMessage()); }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
