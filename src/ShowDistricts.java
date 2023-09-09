import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    }
}
