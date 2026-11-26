import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StudentTableDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Database — JTable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);

            String[] columns = {"ID", "Name", "Age", "Grade", "GPA"};
            Object[][] data = {
                {101, "Alice Johnson", 20, "A", 3.85},
                {102, "Bob Smith", 22, "B", 3.20},
                {103, "Charlie Brown", 19, "A-", 3.70},
                {104, "Diana Prince", 21, "B+", 3.40},
                {105, "Edward Norton", 23, "C", 2.50},
                {106, "Fiona Green", 20, "A", 3.95}
            };

            DefaultTableModel model = new DefaultTableModel(data, columns) {
                public boolean isCellEditable(int row, int column) {
                    return column == 1 || column == 3;
                }
            };
            JTable table = new JTable(model);
            table.setRowHeight(25);
            table.setFont(new Font("Arial", Font.PLAIN, 14));
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable t, Object value,
                        boolean selected, boolean focus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(
                            t, value, selected, focus, row, column);
                    if (!selected && value instanceof Number) {
                        c.setForeground(((Number) value).doubleValue() < 3.0
                                ? Color.RED : Color.BLACK);
                    }
                    return c;
                }
            });

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
            JButton add = new JButton("Add Student");
            JButton delete = new JButton("Delete Selected");
            JButton clear = new JButton("Clear All");

            add.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(frame, "Enter student name:");
                if (name == null || name.trim().isEmpty()) return;
                String ageText = JOptionPane.showInputDialog(frame, "Enter age:");
                if (ageText == null) return;
                String grade = JOptionPane.showInputDialog(frame, "Enter grade (e.g., A, B+):");
                if (grade == null) return;
                String gpaText = JOptionPane.showInputDialog(frame, "Enter GPA:");
                if (gpaText == null) return;
                try {
                    int age = Integer.parseInt(ageText);
                    double gpa = Double.parseDouble(gpaText);
                    int id = 101;
                    for (int i = 0; i < model.getRowCount(); i++)
                        id = Math.max(id, Integer.parseInt(model.getValueAt(i, 0).toString()) + 1);
                    model.addRow(new Object[]{id, name.trim(), age, grade, gpa});
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Age and GPA must be numbers",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            delete.addActionListener(e -> {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete",
                            "No Selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (JOptionPane.showConfirmDialog(frame, "Delete selected student?",
                        "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    model.removeRow(table.convertRowIndexToModel(row));
            });

            clear.addActionListener(e -> {
                if (JOptionPane.showConfirmDialog(frame, "Clear ALL students?",
                        "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    model.setRowCount(0);
            });

            buttons.add(add); buttons.add(delete); buttons.add(clear);
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.add(buttons, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
