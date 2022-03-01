import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

public class CreditCard extends JFrame implements ActionListener {

    private JLabel cc_Num = new JLabel("Enter CC number: ");
    private JTextArea enterCcNum = new JTextArea();
    private JButton button = new JButton("ENTER");

    private JPanel panel = new JPanel();

    CreditCard(){
        panel.setLayout(new GridLayout(1, 3));

        panel.add(cc_Num);
        panel.add(enterCcNum);
        panel.add(button);

        button.addActionListener(this);

        button.setFocusable(false);
        enterCcNum.setLineWrap(true);


        this.setResizable(false);
        this.add(panel, BorderLayout.CENTER);
        this.setTitle("Credit Card");
        this.setSize(400, 80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
//        new CreditCard();


    }

    public int getCC_Num(){
        return Integer.parseInt(enterCcNum.getText().toString());
    }
    Receipt receipt;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(MainGUI.getTotalAmount() <= checkCreditBalance(getCC_Num())) {
                minusCCBalance(getCC_Num(), MainGUI.getTotalAmount());

                JOptionPane.showMessageDialog(null, "Payment done! Thanks for buying");

                receipt = new Receipt();

                MainGUI.receiptDescription.setText(String.valueOf(MainGUI.receiptSB).toString());
                this.dispose();
            }else
                JOptionPane.showMessageDialog(null, "Your balance is " + checkCreditBalance(getCC_Num()) + " and you will pay " + MainGUI.getTotalAmount());
        }

    }
    public static int checkCreditBalance(int CC_ID){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=PaymentTypes";
        String user = "papers";
        String password = "papersarewhite";
        int ccLimit = 0;

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
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

    public static void minusCCBalance(int CC_ID, int amountSpent){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=PaymentTypes";
        String user = "papers";
        String password = "papersarewhite";



        try {
            Connection connection = DriverManager.getConnection(url, user, password);
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


}
