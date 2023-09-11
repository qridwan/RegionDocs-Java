import java.awt.Color;
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

public class UpazillaFormPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private JComboBox<String> divisionComboBox;
    private JComboBox<String> districtComboBox;
    private JTextField thanaTextField;
    private JButton saveButton;
    private JButton clearButton;

    public UpazillaFormPanel(DefaultTableModel model,  AfterLoginPage parent) {
    	
    	

         setLayout(new GridLayout(0, 2, 0, 0));
         
    	setBackground(new Color(255, 255, 255));

        // Create components
        JLabel divisionLabel = new JLabel("Division:");
        divisionLabel.setForeground(new Color(0, 0, 0));
        divisionComboBox = new JComboBox<>(new String[]{"Dhaka", "Chattogram", "Barishal"});
        divisionComboBox.setBackground(Color.LIGHT_GRAY);
        JLabel districtLabel = new JLabel("District:");
        districtLabel.setForeground(new Color(0, 0, 0));
        districtComboBox = new JComboBox<>(new String[]{"Feni", "Chattogram", "Barishal"});
        districtComboBox.setBackground(Color.LIGHT_GRAY);
        districtComboBox.setMaximumRowCount(4);
        JLabel thanaLabel = new JLabel("Thana:");
        thanaLabel.setForeground(new Color(0, 0, 0));
        thanaTextField = new JTextField(20);
        thanaTextField.setBackground(Color.WHITE);
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.GREEN);
        saveButton.setForeground(new Color(0, 0, 0));
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(234, 160, 136));
        clearButton.setForeground(new Color(255, 38, 0));

        // Add components to the panel
        add(divisionLabel);
        add(divisionComboBox);
        add(districtLabel);
        add(districtComboBox);
        add(thanaLabel);
        add(thanaTextField);
        add(saveButton);
        add(clearButton);

        // Add ActionListener to the Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle save button click here
                String selectedDivision = (String) divisionComboBox.getSelectedItem();
                String selectedDistrict = (String) districtComboBox.getSelectedItem();
                String thana = thanaTextField.getText();

                Random random = new Random();
                int randomNumber = random.nextInt(1000);
                
                
                model.addRow(new Object[] {randomNumber, selectedDivision, selectedDistrict, thana});

                parent.showUpazillaPanel();
                System.out.println("Selected Division: " + selectedDivision);
                System.out.println("Selected District: " + selectedDistrict);
                System.out.println("Thana: " + thana);

            }
        });

        // Add ActionListener to the Clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle clear button click here
                divisionComboBox.setSelectedIndex(0);
                districtComboBox.setSelectedIndex(0);
                thanaTextField.setText("");
            }
        });
    }

   
}
