import javax.swing.*;
public class Home {

    private JFrame frame;
    private JPanel panel1;

    public Home() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome HOME!!!");
        lblNewLabel.setBounds(125, 29, 187, 27);
        frame.getContentPane().add(lblNewLabel);

        // Make the frame visible
        frame.setVisible(true);
    }

}
