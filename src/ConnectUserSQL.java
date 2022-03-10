import javax.swing.*;
import java.sql.*;

public class ConnectUserSQL {
    private static boolean managerAccess;

    public static void setManagerAccess(boolean managerAccess) {
        ConnectUserSQL.managerAccess = managerAccess;
    }
    public static boolean isManagerAccess() {
        return managerAccess;
    }

    static DBConnect url = DBConnect.URL;
    static DBConnect user = DBConnect.USER;
    static DBConnect pw = DBConnect.PASSWORD;


    public static void correctUserSQL(){



        try
        {
            Connection connection = DriverManager.getConnection(url.getDBConnect(), user.getDBConnect(), pw.getDBConnect());
            String sql = "SELECT * FROM pos_account where account_username=? and account_password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, LoginGUI.getInputUsername());
            preparedStatement.setString(2, LoginGUI.getInputPassword());
            ResultSet resultSet = preparedStatement.executeQuery();


            if(resultSet.next()){
                LoginGUI.account_access = resultSet.getString("account_access");
                LoginGUI.isAuthorized = true;
                LoginGUI.setMessage("Logged in");
                if(LoginGUI.account_access.equals("manager")){
                    setManagerAccess(true);
                    JOptionPane.showMessageDialog(null, "You logged in as Manager");
                }else{
                    JOptionPane.showMessageDialog(null, "You logged in as Employee");
                }
            }
            else{
                LoginGUI.setMessage("Error");
                JOptionPane.showMessageDialog(null, "Username and Password not matched");
                LoginGUI.fillUser("");
                LoginGUI.fillPassword("");
            }
            resultSet.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
