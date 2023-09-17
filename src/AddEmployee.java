import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEmployee extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JComboBox<String> divisionDropdown;
    private JComboBox<String> districtDropdown;
    private JComboBox<String> upazillaDropdown;
    private JButton btnSave;
    private JButton btnClear;
    private JDateChooser birthdateChooser; // Date picker field

    public AddEmployee(AfterLoginPage parent) {
        setLayout(new GridBagLayout());

        // Create GridBagConstraints for each component
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel lblTitle = new JLabel("Add Employee");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitle, gbc);

        // Reset gridwidth for other components
        gbc.gridwidth = 1;

        
        // Birthdate
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(new JLabel("Birthdate:"), gbc);
        gbc.gridx = 1;
        birthdateChooser = new JDateChooser();
        birthdateChooser.setDateFormatString("yyyy-MM-dd"); // Set the date format
        add(birthdateChooser, gbc);
        
        
        // First Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        firstNameField = new JTextField(20);
        add(firstNameField, gbc);

        // Middle Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Middle Name:"), gbc);
        gbc.gridx = 1;
        middleNameField = new JTextField(20);
        add(middleNameField, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        lastNameField = new JTextField(20);
        add(lastNameField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        add(emailField, gbc);

        // Phone
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(20);
        add(phoneField, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        addressField = new JTextField(20);
        add(addressField, gbc);

        // Division
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Choose Division:"), gbc);
        gbc.gridx = 1;
        String[] divisions = { "Dhaka", "Chattogram", "Barishal" };
        divisionDropdown = new JComboBox<>(divisions);
        add(divisionDropdown, gbc);

        // District
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("Choose District:"), gbc);
        gbc.gridx = 1;
        String[] districts = { "Feni", "Chattogram", "Cumilla" };
        districtDropdown = new JComboBox<>(districts);
        add(districtDropdown, gbc);

        // Upazilla
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("Choose Upazilla:"), gbc);
        gbc.gridx = 1;
        String[] upazillas = { "Feni", "Chattogram", "Cumilla" };
        upazillaDropdown = new JComboBox<>(upazillas);
        add(upazillaDropdown, gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSave = new JButton("Save");
        add(btnSave, gbc);

        // Clear Button
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.CENTER;
        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.RED);
        btnClear.setBackground(Color.PINK);
        add(btnClear, gbc);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDivision = (String) divisionDropdown.getSelectedItem();
                String selectedDistrict = (String) districtDropdown.getSelectedItem();
                String selectedUpazilla = (String) upazillaDropdown.getSelectedItem();

                Random random = new Random();
                int randomNumber = random.nextInt(1000);
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                
                // Use the SimpleDateFormat to format the date as a string
                String formattedDate = sdf.format(birthdateChooser.getDate());
                
                
                parent.employeeTableModel.addRow(new Object[] { randomNumber, firstNameField.getText()+" "+middleNameField.getText()+" "+ middleNameField.getText(), formattedDate, selectedDivision, selectedDistrict, selectedUpazilla,
        				emailField.getText(), "photo1.jpg" });

                // Example: Print selected data
                System.out.println("First Name: " + firstNameField.getText());
                System.out.println("Last Name: " + lastNameField.getText());
                System.out.println("Middle Name: " + middleNameField.getText());
                System.out.println("Email: " + emailField.getText());
                System.out.println("Phone: " + phoneField.getText());
                System.out.println("Address: " + addressField.getText());
                System.out.println("Selected Division: " + selectedDivision);
                System.out.println("Selected District: " + selectedDistrict);
                System.out.println("Selected Upazilla: " + selectedUpazilla);
                System.out.println("Birthdate: " + formattedDate); 
                
                parent.showEmployee();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameField.setText("");
                lastNameField.setText("");
                middleNameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");
                divisionDropdown.setSelectedIndex(0);
                districtDropdown.setSelectedIndex(0);
                upazillaDropdown.setSelectedIndex(0);
                birthdateChooser.setDate(null);
            }
        });
    }
}
