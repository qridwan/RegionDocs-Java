import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DistrictAddPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTextField districtField;
    private JComboBox<String> divisionDropdown;
    private JButton btnSave;
    private JButton btnClear;

    public DistrictAddPanel(DefaultTableModel model,  AfterLoginPage parent) {
        setLayout(new GridLayout(4, 4, 10, 10)); // Adjust layout as needed
//    	setLayout(new BorderLayout());
        JLabel lblDivision = new JLabel("Division:");
        divisionDropdown = new JComboBox<>(new String[]{"Dhaka", "Chattogram", "Barishal"});
        add(lblDivision);
        add(divisionDropdown);

        JLabel lblDistrict = new JLabel("District:");
        districtField = new JTextField();
        add(lblDistrict);
        add(districtField);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDivision = (String) divisionDropdown.getSelectedItem();
                String districtName = districtField.getText();

                Random random = new Random();
                int randomNumber = random.nextInt(1000);

                model.addRow(new Object[]{randomNumber, selectedDivision, districtName});
                parent.showDistrictPanel();
                System.out.println("Selected Division: " + selectedDivision);
                System.out.println("District Name: " + districtName);
            }
        });
        add(btnSave);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                divisionDropdown.setSelectedIndex(0);
                districtField.setText("");
            }
        });
        add(btnClear);
    }

	
}
