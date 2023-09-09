import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AfterLoginPage {

    private JFrame frame;
    private JTable table;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel showDistrictPanel; // Panel for the "Show District" table
    private JPanel addDistrictPanel;
    
    DefaultTableModel model = new DefaultTableModel() {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
        }
    };
    
    public AfterLoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("After Login Page");
        contentPanel = new JPanel(new CardLayout());
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        
        
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Create a menu panel with buttons for different actions
        menuPanel = new JPanel(new FlowLayout());

        JButton addDistrictButton = new JButton("Add District");
        addDistrictButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	showAddDistrictPanel();
 }
        });
        menuPanel.add(addDistrictButton);

        JButton showDistrictButton = new JButton("Show District");
        showDistrictButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Pressed Add District");
                showDistrictPanel();
   
            }
        });
        menuPanel.add(showDistrictButton);


        JButton addUpazillaButton = new JButton("Add Upazilla");
        addUpazillaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement the logic to add an upazilla here
            }
        });
        menuPanel.add(addUpazillaButton);

        JButton showUpazillaButton = new JButton("Show Upazilla");
        showUpazillaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement the logic to show upazillas here
            }
        });
        menuPanel.add(showUpazillaButton);

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement the logic to add an employee here
            }
        });
        menuPanel.add(addEmployeeButton);

        frame.getContentPane().add(menuPanel, BorderLayout.NORTH);

       

        // Create a logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose the current frame and show the login form
                frame.dispose();
                showLoginForm();
            }
        });

        frame.getContentPane().add(logoutButton, BorderLayout.SOUTH);
        
        addDistrictPanel = createAddDistrictPanel();
        contentPanel.add(addDistrictPanel, "addDistrict");
        
        
     // Create the "Show District" panel
        showDistrictPanel = createShowDistrictPanel();
        contentPanel.add(showDistrictPanel, "showDistrict");




        frame.setVisible(true);
    }

    private void showLoginForm() {
        // Create a new instance of the LoginApp
        LoginPage loginApp = new LoginPage();
        // Make the login frame visible
        loginApp.showPage();
    }
    
    public void showPage() {
        frame.setVisible(true);
    }
    
    private  void hideTable() {
    	if (contentPanel != null) {
            contentPanel.setVisible(false);
        }
	}
    
    
    private void showAddDistrictPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addDistrict");
    }
    
    private void showDistrictPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "showDistrict");
    }
    
    
    
    
    private JPanel createAddDistrictPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); // Adjust layout as needed

        JLabel lblDivision = new JLabel("Division:");
        panel.add(lblDivision);

        JComboBox<String> divisionDropdown = new JComboBox<>(new String[]{"Dhaka", "Chattogram", "Barishal"});
        panel.add(divisionDropdown);

        JLabel lblDistrict = new JLabel("District:");
        panel.add(lblDistrict);

        JTextField districtField = new JTextField();
        panel.add(districtField);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDivision = (String) divisionDropdown.getSelectedItem();
                String districtName = districtField.getText();
                
                Random random = new Random();
                int randomNumber = random.nextInt(1000);
                
                
        	    model.addRow(new Object[]{randomNumber,selectedDivision, districtName});
                
                
                System.out.println("Selected Division: " + selectedDivision);
                System.out.println("District Name: " + districtName);
                
                showDistrictPanel();
            }
        });
        panel.add(btnSave);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement clear logic here
                divisionDropdown.setSelectedIndex(0);
                districtField.setText("");
            }
        });
        panel.add(btnClear);

        return panel;
    }
    
    
    
    private JPanel createShowDistrictPanel() {
    	    JPanel panel = new JPanel(new BorderLayout());

    	    // Create a non-editable dummy table model with data (replace with your data)
    	    
    	    model.addColumn("ID");
    	    model.addColumn("Division");
    	    model.addColumn("District");

    	    // Add some dummy data
    	    model.addRow(new Object[]{1,"Chattogram", "Chattogram"});
    	    model.addRow(new Object[]{2,"Chattogram", "Cox's Bazar"});
    	    model.addRow(new Object[]{3,"Chattogram", "Mirsaray"});
    	    model.addRow(new Object[]{4,"Chattogram", "Feni"});
    	    model.addRow(new Object[]{5,"Chattogram", "Cumilla"});

    	    table = new JTable(model);
    	    table.setDefaultEditor(Object.class, null); // Make the table non-editable
    	    JScrollPane scrollPane = new JScrollPane(table);
    	    panel.add(scrollPane, BorderLayout.CENTER);

    	    return panel;
    	

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AfterLoginPage window = new AfterLoginPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
