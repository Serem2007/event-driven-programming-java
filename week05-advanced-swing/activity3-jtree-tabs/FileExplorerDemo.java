import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class FileExplorerDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("File Explorer Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("My Computer");
            DefaultMutableTreeNode documents = new DefaultMutableTreeNode("Documents");
            documents.add(new DefaultMutableTreeNode("Resume.docx"));
            documents.add(new DefaultMutableTreeNode("CV.pdf"));
            documents.add(new DefaultMutableTreeNode("Notes.txt"));
            DefaultMutableTreeNode pictures = new DefaultMutableTreeNode("Pictures");
            pictures.add(new DefaultMutableTreeNode("Vacation.jpg"));
            pictures.add(new DefaultMutableTreeNode("Family.jpg"));
            DefaultMutableTreeNode projects = new DefaultMutableTreeNode("Projects");
            DefaultMutableTreeNode javaProject = new DefaultMutableTreeNode("JavaApp");
            javaProject.add(new DefaultMutableTreeNode("Main.java"));
            javaProject.add(new DefaultMutableTreeNode("Utils.java"));
            projects.add(javaProject);
            root.add(documents); root.add(pictures); root.add(projects);

            JTree tree = new JTree(new DefaultTreeModel(root));
            tree.setFont(new Font("Arial", Font.PLAIN, 14));
            tree.setRowHeight(25);

            JTextArea info = new JTextArea(5, 30);
            info.setEditable(false);
            info.setFont(new Font("Arial", Font.PLAIN, 14));
            tree.addTreeSelectionListener(e -> {
                DefaultMutableTreeNode selected =
                    (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selected != null)
                    info.setText("You selected: " + selected.getUserObject()
                            + "\nLevel: " + selected.getLevel());
            });

            JTabbedPane tabs = new JTabbedPane();
            JPanel general = new JPanel();
            general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));
            general.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            general.add(new JLabel("General Settings"));
            general.add(Box.createVerticalStrut(15));
            general.add(new JCheckBox("Show hidden files"));
            general.add(new JCheckBox("Auto-save every 5 minutes"));
            general.add(new JCheckBox("Enable notifications"));

            JPanel appearance = new JPanel();
            appearance.setLayout(new BoxLayout(appearance, BoxLayout.Y_AXIS));
            appearance.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            appearance.add(new JLabel("Theme:"));
            appearance.add(Box.createVerticalStrut(10));
            JRadioButton light = new JRadioButton("Light theme", true);
            JRadioButton dark = new JRadioButton("Dark theme");
            JRadioButton system = new JRadioButton("System default");
            ButtonGroup themes = new ButtonGroup();
            themes.add(light); themes.add(dark); themes.add(system);
            appearance.add(light); appearance.add(dark); appearance.add(system);

            JPanel about = new JPanel(new BorderLayout());
            about.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            JTextArea aboutText = new JTextArea(
                "File Explorer Demo v1.0\n\nBuilt with Java Swing as part of\n"
                + "Week 5 practical activities.\n\nComponents used: JTree, JTabbedPane");
            aboutText.setEditable(false);
            aboutText.setLineWrap(true);
            aboutText.setWrapStyleWord(true);
            about.add(new JScrollPane(aboutText), BorderLayout.CENTER);

            tabs.addTab("General", general);
            tabs.addTab("Appearance", appearance);
            tabs.addTab("About", about);

            JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                    new JScrollPane(tree), tabs);
            split.setDividerLocation(250);
            frame.add(split, BorderLayout.CENTER);
            frame.add(new JScrollPane(info), BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
