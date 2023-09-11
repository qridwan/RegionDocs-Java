import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ShowDistricts extends JPanel {

    private static final long serialVersionUID = 1L;

    public ShowDistricts(DefaultTableModel model) {
        setLayout(new BorderLayout());

        // Add columns if they don't exist in the table model
        if (model.getColumnCount() == 0) {
            model.addColumn("ID");
            model.addColumn("Division");
            model.addColumn("District");
        }

        // Add some dummy data
        model.addRow(new Object[]{1, "Chattogram", "Chattogram"});
        model.addRow(new Object[]{2, "Chattogram", "Cox's Bazar"});
        model.addRow(new Object[]{3, "Chattogram", "Mirsaray"});
        model.addRow(new Object[]{4, "Chattogram", "Feni"});
        model.addRow(new Object[]{5, "Chattogram", "Cumilla"});

        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null); // Make the table non-editable
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Style the table header
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(tableHeader.getFont().deriveFont(Font.BOLD));
        tableHeader.setBackground(Color.LIGHT_GRAY);

        // Custom cell renderer for adding padding
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding here
                return label;
            }
        };

        // Apply the custom cell renderer to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
}
