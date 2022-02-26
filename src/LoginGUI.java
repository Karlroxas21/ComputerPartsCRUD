import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JFrame implements ActionListener {

    public static String account_access = "";
    public static boolean isAuthorized = false;
    private JButton loginButton = new JButton("LOG IN");
    private JPanel panel = new JPanel();
    private static JTextField username = new JTextField();
    static JPasswordField password = new JPasswordField();
    private JLabel userLabel = new JLabel("Username");
    private JLabel pwLabel = new JLabel("Password");
    private static JLabel message = new JLabel("TEST MESSAGE");

    private final String name = "Anne";



    static char[]  Password(){
        return password.getPassword();
    }
    static void  fillUser(String fill){
        username.setText(fill);
    }
    static String getInputUsername(){
        return username.getText();
    }

     static void setMessage(String s){
        message.setText(s);
    }

    static void  fillPassword(String fill){
        password.setText(fill);
    }
    static String getInputPassword(){
        return new String(Password());
    }



    LoginGUI() {

        panel.setLayout(new GridLayout(3, 1));

        password.setEchoChar('*');
        panel.add(userLabel);
        panel.add(username);
        panel.add(pwLabel);
        panel.add(password);
        panel.add(message);
        panel.add(loginButton);

        loginButton.addActionListener(this);
        username.addActionListener(this);
        password.addActionListener(this);

        this.add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Log in");
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



    static String getClerkName(String name){
        return name;
    }

    public static void main(String[] args) {
        new LoginGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            connectUserSQL.correctUserSQL();
            if(isAuthorized){
                MainGUI.mainGUI = new MainGUI();
                this.dispose();
            }

        }
    }

}
