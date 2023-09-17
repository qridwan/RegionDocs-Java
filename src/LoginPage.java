import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
        textField.setBounds(142, 81, 220, 44);
        frame.getContentPane().add(textField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(UIManager.getColor("Button.highlight"));
        lblPassword.setBounds(50, 153, 80, 14);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(142, 137, 220, 46);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBackground(Color.WHITE);
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
        
        JLabel lblNewLabel_1 = new JLabel("username: user password: pass");
        lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_1.setBounds(142, 242, 215, 16);
        frame.getContentPane().add(lblNewLabel_1);
    }

    private boolean isValidLogin(String username, String password) {
        // Replace this with your actual login validation logic
    	DB_UTIL db = new DB_UTIL();
    	
    	int dbResult = db.checkUser(username, password);
    	
    	
    	if(dbResult == 1) {
    		return true;
    	}else return false;
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
