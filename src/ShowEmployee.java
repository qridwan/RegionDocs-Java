import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ShowEmployee extends JPanel {

	private static final long serialVersionUID = 1L;

	public ShowEmployee(DefaultTableModel model) {
		setLayout(new BorderLayout());

		// Add columns if they don't exist in the table model
		if (model.getColumnCount() == 0) {
			model.addColumn("ID");
			model.addColumn("Name");
			model.addColumn("NID");
			model.addColumn("Division");
			model.addColumn("District");
			model.addColumn("Upazilla");
			model.addColumn("Email");
			model.addColumn("Photo");
		}

		// Add some dummy data
		model.addRow(new Object[] { 1, "John Doe", "123-45-6789", "Dhaka", "Chattogram", "Cox's Bazar",
				"john.doe@email.com", "photo1.jpg" });
		model.addRow(new Object[] { 2, "Jane Smith", "987-65-4321", "Chattogram", "Barishal", "Bhola",
				"jane.smith@email.com", "photo2.jpg" });
		model.addRow(new Object[] { 3, "Michael Johnson", "555-12-3456", "Dhaka", "Dhaka", "Gazipur",
				"michael.johnson@email.com", "photo3.jpg" });
		model.addRow(new Object[] { 4, "Emily Davis", "222-33-4444", "Barishal", "Barishal", "Barishal",
				"emily.davis@email.com", "photo4.jpg" });
		model.addRow(new Object[] { 5, "Robert Wilson", "444-55-6666", "Chattogram", "Chattogram", "Cumilla",
				"robert.wilson@email.com", "photo5.jpg" });
		model.addRow(new Object[] { 6, "Sarah Brown", "777-88-9999", "Dhaka", "Barishal", "Barishal",
				"sarah.brown@email.com", "photo6.jpg" });
		model.addRow(new Object[] { 7, "William Lee", "666-77-8888", "Chattogram", "Chattogram", "Feni",
				"william.lee@email.com", "photo7.jpg" });
		model.addRow(new Object[] { 8, "Olivia Taylor", "888-99-0000", "Dhaka", "Chattogram", "Chattogram",
				"olivia.taylor@email.com", "photo8.jpg" });
		model.addRow(new Object[] { 9, "James White", "999-11-2222", "Barishal", "Barishal", "Bhola",
				"james.white@email.com", "photo9.jpg" });
		model.addRow(new Object[] { 10, "Sophia Martin", "111-22-3333", "Dhaka", "Chattogram", "Cox's Bazar",
				"sophia.martin@email.com", "photo10.jpg" });

		JTable table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.LIGHT_GRAY);
		table.setDefaultEditor(Object.class, null); // Make the table non-editable

		// Create a JScrollPane and set its horizontal scroll policy
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// Create a search field and button
		JTextField searchField = new JTextField(20);
		JButton searchButton = new JButton("Search");

		// Add the search field and button to a panel
		JPanel searchPanel = new JPanel();
		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		// Add the search panel above the table
		add(searchPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		// Create a TableRowSorter to enable row filtering
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		// Add an action listener to the search button
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchQuery = searchField.getText();
				if (searchQuery != null && !searchQuery.isEmpty()) {
					RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchQuery);
					sorter.setRowFilter(rowFilter);
				} else {
					sorter.setRowFilter(null); // Remove any existing filters
				}
			}
		});

	}
}
