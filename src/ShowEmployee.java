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
		

        DB_UTIL db = new DB_UTIL();
    	 model = db.getEmployees();
    	 

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
