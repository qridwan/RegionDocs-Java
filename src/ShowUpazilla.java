import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ShowUpazilla extends JPanel {

    private static final long serialVersionUID = 1L;

    public ShowUpazilla(DefaultTableModel model) {
        setLayout(new BorderLayout());

        // Add columns if they don't exist in the table model
        if (model.getColumnCount() == 0) {
        	model.addColumn("ID");
            model.addColumn("Division");
            model.addColumn("District");
            model.addColumn("Upazilla");
        }
        
        DB_UTIL db = new DB_UTIL();
   	 model = db.getUpazilla();

        // Add some dummy data
//        model.addRow(new Object[]{1,"Dhaka", "Chattogram", "Cox's Bazar"});
//        model.addRow(new Object[]{3,"Chattogram", "Cox's Bazar", "Chakaria"});
//        model.addRow(new Object[]{34,"Barishal", "Bhola", "Char Fasson"});
//        model.addRow(new Object[]{222,"Dhaka", "Gazipur", "Kaliganj"});

        JTable table = new JTable(model);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setBackground(Color.LIGHT_GRAY);
        table.setDefaultEditor(Object.class, null); // Make the table non-editable
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
