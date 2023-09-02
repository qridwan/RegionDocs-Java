
import java.awt.EventQueue;

        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.border.EmptyBorder;
        import javax.swing.JLabel;
        import javax.swing.JTextField;
        import javax.swing.JPasswordField;
        import javax.swing.JButton;
        import java.awt.event.ActionListener;
        import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel lblMessage;

    // Sample username/password for validation
    private String sampleUsername = "user";
    private String samplePassword = "pass";


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 80, 20);
        panel.add(lblUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(140, 50, 150, 20);
        panel.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 80, 20);
        panel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 100, 150, 20);
        panel.add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(sampleUsername) && password.equals(samplePassword)) {
                    frame.dispose();
                    // Create an instance of the Home class and set it visible
                    new Home();
                    lblMessage.setText("Welcome, " + username + "!");
                    textFieldUsername.setVisible(false);
                    passwordField.setVisible(false);
                    btnLogin.setVisible(false);
                } else {
                    lblMessage.setText("Login failed. Please try again.");
                }
            }
        });
        btnLogin.setBounds(140, 150, 80, 25);
        panel.add(btnLogin);

        lblMessage = new JLabel("");
        lblMessage.setBounds(50, 200, 300, 20);
        panel.add(lblMessage);
    }

    public Main () {
        initialize();
    }


}
