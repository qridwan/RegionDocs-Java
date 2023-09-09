import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JFrame frame;
    private JPasswordField passwordField;
    private JTextField textField;

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login Page");
        frame.getContentPane().setForeground(UIManager.getColor("Button.highlight"));
        frame.getContentPane().setBackground(UIManager.getColor("Button.foreground"));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(UIManager.getColor("Button.highlight"));
        lblUsername.setBounds(50, 96, 80, 14);
        frame.getContentPane().add(lblUsername);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(142, 81, 215, 44);
        frame.getContentPane().add(textField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(UIManager.getColor("Button.highlight"));
        lblPassword.setBounds(50, 153, 80, 14);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(142, 137, 220, 46);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(UIManager.getColor("Button.highlight"));
        btnLogin.setBackground(UIManager.getColor("Button.shadow"));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                if (isValidLogin(username, password)) {
                    openAfterLoginPage();
                } else {
                    // Display an error message when login fails
                    JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(195, 207, 89, 23);
        frame.getContentPane().add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("Wellcome Back!");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBackground(UIManager.getColor("Button.select"));
        lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
        lblNewLabel.setBounds(140, 24, 231, 31);
        frame.getContentPane().add(lblNewLabel);
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
                    AfterLoginPage authPage = new AfterLoginPage();
                    
                    authPage.showPage();
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
