import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEmployee extends JPanel {
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;

	public AddEmployee(AfterLoginPage parent) {
		setLayout(new GridLayout(4, 4, 10, 10));

		JLabel lbl1Name = new JLabel("First Name");
		firstNameField = new JTextField();
		add(lbl1Name);
		add(firstNameField);
		JLabel lbl2Name = new JLabel("Middle Name");
		middleNameField = new JTextField();
		add(lbl2Name);
		add(middleNameField);
		JLabel lbl3Name = new JLabel("Last Name");
		lastNameField = new JTextField();
		add(lbl3Name);
		add(lastNameField);
		
		
		

	}

}
