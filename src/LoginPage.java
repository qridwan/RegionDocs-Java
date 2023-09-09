import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login Page");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 80, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 80, 80, 14);
        frame.getContentPane().add(lblPassword);

        usernameField = new JTextField();
        usernameField.setBounds(140, 50, 200, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 200, 20);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (isValidLogin(username, password)) {
                    openAfterLoginPage();
                } else {
                    // Display an error message when login fails
                    JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(140, 110, 89, 23);
        frame.getContentPane().add(btnLogin);
    }

    private boolean isValidLogin(String username, String password) {
        // Replace this with your actual login validation logic
        return username.equals("user") && password.equals("pass");
    }

    private void openAfterLoginPage() {
        // Close the current login page
        frame.dispose();

        // Open the after-login page
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AfterLoginPage afterLoginPage = new AfterLoginPage();
                    
                    afterLoginPage.showPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void showPage() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage loginPage = new LoginPage();
                    loginPage.showPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
