import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DistrictAddPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTextField districtField;
    private JComboBox<String> divisionDropdown;
    private JButton btnSave;
    private JButton btnClear;

    public DistrictAddPanel(DefaultTableModel model, AfterLoginPage parent) {
        setLayout(new GridLayout(4, 2, 10, 10)); // Adjust layout as needed

        JLabel lblDivision = new JLabel("Division:");
        divisionDropdown = new JComboBox<>(new String[]{"Dhaka", "Chattogram", "Barishal"});

        JLabel lblDistrict = new JLabel("District:");
        districtField = new JTextField();

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

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                divisionDropdown.setSelectedIndex(0);
                districtField.setText("");
            }
        });

        // Add components to the panel
        add(lblDivision);
        add(divisionDropdown);
        add(lblDistrict);
        add(districtField);
        add(btnSave);
        add(btnClear);
    }
}
