import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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

    static public String getAccFName() {
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=Credentials";
        String user = "papers";
        String password = "papersarewhite";
        String name = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT Fname FROM pos_account WHERE account_username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, getInputUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                name = resultSet.getString("Fname");
            }

            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return name;
    }



    public static void main(String[] args) {
        new LoginGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            ConnectUserSQL.correctUserSQL();
            if(isAuthorized){
                MainGUI.mainGUI = new MainGUI();
                this.dispose();
            }

        }
    }


}
