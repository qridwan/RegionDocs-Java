import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class AfterLoginPage {

	private JFrame frame;
	private JPanel menuPanel;
	private JPanel contentPanel;
	private DefaultTableModel districtTableModel;
	private DefaultTableModel upazillaTableModel;
	public DefaultTableModel employeeTableModel;
//    private JPanel addDistrictPanel;

	public AfterLoginPage() {
		initialize();

	}

	private void initialize() {
		frame = new JFrame("Home Page");
		contentPanel = new JPanel(new CardLayout());
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		districtTableModel = new DefaultTableModel(new String[] { "ID", "Division", "District" }, 0);
		upazillaTableModel = new DefaultTableModel(new String[] { "ID", "Division", "District", "Upazilla" }, 0);
		employeeTableModel = new DefaultTableModel(
				new String[] { "ID", "Name", "NID", "Division", "District", "Upazilla", "Email", "Photo" }, 0);

		// Create a menu panel with buttons for different actions
		menuPanel = new JPanel(new FlowLayout());
		menuPanel.setForeground(Color.WHITE);
		menuPanel.setBackground(Color.DARK_GRAY);

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

				System.out.println("Pressed show District");
				showDistrictPanel();

			}
		});
		menuPanel.add(showDistrictButton);

		JButton addUpazillaButton = new JButton("Add Upazilla");
		addUpazillaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddUpazilla();
				// Implement the logic to add an upazilla here

			}
		});
		menuPanel.add(addUpazillaButton);

		JButton showUpazillaButton = new JButton("Show Upazilla");
		showUpazillaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUpazillaPanel();
				// Implement the logic to show upazillas here
			}
		});
		menuPanel.add(showUpazillaButton);

		JButton addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddEmployee();
				// Implement the logic to add an employee here
			}
		});

		menuPanel.add(addEmployeeButton);

		JButton showEmployeeButton = new JButton("Show Employee");
		showEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("pressed");
				showEmployee();

				// Implement the logic to add an employee here
			}
		});
		menuPanel.add(showEmployeeButton);

		frame.getContentPane().add(menuPanel, BorderLayout.NORTH);

		// Create a logout button
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Monaco", Font.PLAIN, 14));
		logoutButton.setForeground(Color.RED);
		logoutButton.setBackground(Color.PINK);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dispose the current frame and show the login form
				frame.dispose();
				showLoginForm();
			}
		});

		frame.getContentPane().add(logoutButton, BorderLayout.SOUTH);

		DistrictAddPanel addDistrictPanel = new DistrictAddPanel(districtTableModel, this);
		addDistrictPanel.setForeground(UIManager.getColor("Button.highlight"));
		addDistrictPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(addDistrictPanel, "addDistrict");

//		// Create the "Show District" panel
		ShowDistricts districtPanel = new ShowDistricts(districtTableModel);
		districtPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(districtPanel, "showDistrict");

		// create the "Upazilla add form"
		UpazillaFormPanel addUpazillaPanel = new UpazillaFormPanel(upazillaTableModel, this);
		addUpazillaPanel.setForeground(UIManager.getColor("Button.highlight"));
		addUpazillaPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(addUpazillaPanel, "addUpazilla");

		// create the "Upazilla show table"
		ShowUpazilla showUpazillaTable = new ShowUpazilla(upazillaTableModel);
		showUpazillaTable.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(showUpazillaTable, "showUpazilla");

		// show employee list
		ShowEmployee employees = new ShowEmployee(employeeTableModel);
		employees.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(employees, "showEmployee");

		
		// create the "Add Employee"
		AddEmployee addEmployee = new AddEmployee(this);
		addEmployee.setForeground(Color.BLACK);
		addEmployee.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(addEmployee, "addEmployee");

		
		
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

	private void showAddDistrictPanel() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "addDistrict");
	}

	public void showDistrictPanel() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "showDistrict");

	}

	public void showUpazillaPanel() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "showUpazilla");

	}

	private void showAddUpazilla() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "addUpazilla");
	};

	public void showEmployee() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "showEmployee");
	}
	
	private void showAddEmployee() {
		CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
		cardLayout.show(contentPanel, "addEmployee");
	};

}
