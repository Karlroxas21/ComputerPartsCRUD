import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreditCard extends JFrame implements ActionListener {

    static DBConnect url = DBConnect.URL;
    static DBConnect user = DBConnect.USER;
    static DBConnect pw = DBConnect.PASSWORD;

    private JLabel cc_Num = new JLabel("Enter CC number: ");
    private static JTextArea enterCcNum = new JTextArea();
    private JButton button = new JButton("ENTER");
    private JButton back = new JButton("Back");

    private JPanel panel = new JPanel();

    CreditCard(){
        panel.setLayout(new GridLayout(1, 4));

        panel.add(back);
        panel.add(cc_Num);
        panel.add(enterCcNum);
        panel.add(button);

        button.addActionListener(this);
        back.addActionListener(this);

        button.setFocusable(false);
        enterCcNum.setLineWrap(true);

        this.setResizable(false);
        this.add(panel, BorderLayout.CENTER);
        this.setTitle("Credit Card");
        this.setSize(500, 80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new CreditCard();
    }

    //Kukunin yung inenter mo na Credit Card Number
    static public int getCC_Num(){
        return Integer.parseInt(enterCcNum.getText().toString());
    }
    Receipt receipt;
    Pay pay;
    EnterPassword enterPassword;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            pay = new Pay();
            this.dispose();
        }
        if(e.getSource() == button) {
            //Kapag hindi valid edi hindi ka makakapag bayad.
            if (isCCNumValid(getCC_Num())) {
                enterPassword = new EnterPassword();
                this.dispose();
            }else
                JOptionPane.showMessageDialog(null, "Credit Card Number Not Valid!");

        }
    }
    public static int checkCreditBalance(int CC_ID){

        int ccLimit = 0;

        try {
            Connection connection = DriverManager.getConnection(url.getDBConnect(), user.getDBConnect(), pw.getDBConnect());
            String QUERY = "SELECT Credit_Limit FROM CreditCard where Credit_Card_Num=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, CC_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ccLimit = resultSet.getInt("Credit_Limit");

                return ccLimit;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return 0;
    }
    //Isa-subtract dito yung amount spent - Credit Limit
    public static void minusCCBalance(int CC_ID, int amountSpent){

        try {
            Connection connection = DriverManager.getConnection(url.getDBConnect(), user.getDBConnect(), pw.getDBConnect());
            String QUERY = "UPDATE CreditCard SET Credit_Limit=? WHERE Credit_Card_Num=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            int ccID = CC_ID;
            int updateBalance = checkCreditBalance(CC_ID) - amountSpent;

            preparedStatement.setInt(1, updateBalance);
            preparedStatement.setInt(2, ccID);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Iche-check kung valid ba yung Credit Card Number na inenter mo
    public static boolean isCCNumValid(int CC_ID){
        int ccID = 0;

        try {
            Connection connection = DriverManager.getConnection(url.getDBConnect(), user.getDBConnect(), pw.getDBConnect());
            String QUERY = "select Credit_Card_Num from CreditCard where Credit_Card_Num=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, CC_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ccID = resultSet.getInt("Credit_Card_Num");
                if(CC_ID != ccID){

                    return false;
                }else
                    return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
    }
