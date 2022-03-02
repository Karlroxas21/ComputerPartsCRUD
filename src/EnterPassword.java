import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class EnterPassword extends JFrame{

    static JPasswordField enterCCPassword;
    JButton proceed;
    JButton backBtn;

    EnterPassword(){

        enterCCPassword = new JPasswordField();
        proceed = new JButton("Proceed");
        backBtn = new JButton("Back");

        JPanel panel1 = new JPanel();

        enterCCPassword.setEchoChar('*');

        panel1.setLayout(new GridLayout(1, 3));

        panel1.add(backBtn);
        panel1.add(enterCCPassword);
        panel1.add(proceed);



        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt receipt;

                if(!isPasswordMatch()) {
                    JOptionPane.showMessageDialog(null, "Error!");
                }else {
                    if (MainGUI.getTotalAmount() <= CreditCard.checkCreditBalance(CreditCard.getCC_Num())) {
                        CreditCard.minusCCBalance(CreditCard.getCC_Num(), MainGUI.getTotalAmount());

                        Receipt.paymentType = "Credit Card";
                        CreditCardHistory();
                        JOptionPane.showMessageDialog(null, "Payment done! Thanks for buying");



                        receipt = new Receipt();

                        MainGUI.receiptDescription.setText(String.valueOf(MainGUI.receiptSB).toString());
                        dispose();
                    } else
                        JOptionPane.showMessageDialog(null, "Your limit is " + CreditCard.checkCreditBalance(CreditCard.getCC_Num()) + " and you will pay " + MainGUI.getTotalAmount());
                }



            }
        });

        backBtn.addActionListener(new ActionListener() {
            CreditCard creditCard;
            @Override
            public void actionPerformed(ActionEvent e) {
                creditCard = new CreditCard();
                dispose();
            }
        });



        this.setResizable(false);
        this.add(panel1, BorderLayout.CENTER);
        this.setTitle("Enter your password");
        this.setSize(500, 80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    static char[]  Password(){
        return enterCCPassword.getPassword();
    }
    static String getInputPassword(){
        return new String(Password());
    }
    static public String getPasswordCC() {
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=PaymentTypes";
        String user = "papers";
        String password = "papersarewhite";
        String pw_cc = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT pw_to_Pay from CreditCard where Credit_Card_Num=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            String ccNum = String.valueOf(CreditCard.getCC_Num());

            preparedStatement.setString(1, ccNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pw_cc = resultSet.getString("pw_to_Pay");
            }

            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return pw_cc;
    }

    static public boolean isPasswordMatch(){
        if(!getInputPassword().equals(getPasswordCC())){
            return false;
        }else
            return true;
    }

    static void CreditCardHistory(){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=PaymentTypes";
        String user = "papers";
        String password = "papersarewhite";
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "INSERT INTO CreditCard_History(Credit_Card_Num, Date_Time_Used, Amount_spent) select Credit_Card_Num, GETDATE(), ? from CreditCard where Credit_Card_Num=?";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            int ccNum = CreditCard.getCC_Num();
            double totalAmount = MainGUI.totalWithTAX;

            preparedStatement.setDouble(1, totalAmount);
            preparedStatement.setInt(2, ccNum );

            preparedStatement.execute();


            preparedStatement.close();



        }catch (Exception ex){
            ex.printStackTrace();
        }
    }




    public static void main(String[] args) {
        new EnterPassword();


    }
}