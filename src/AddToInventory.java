import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class AddToInventory extends JFrame {
    JButton backButton = new JButton("Back");

    private JPanel moboAddPanel = new JPanel();
    private JPanel cpuAddPanel = new JPanel();
    private JTabbedPane tabbedPane = new JTabbedPane();

    private JLabel brand = new JLabel("Brand:");
    private JLabel model = new JLabel("Model:");
    private JLabel price = new JLabel("Price:");
    private JLabel num_Stock = new JLabel("Number of Stock:");
    private JLabel cash_Price = new JLabel("Cash Price:");
    private JLabel cpu_Socket = new JLabel("CPU Socket:");
    private JLabel mem_Type = new JLabel("Memory Type:");
    private JLabel form_Factor = new JLabel("Form Factor:");

    private JTextField brandTF = new JTextField();
    private JTextField modelTF = new JTextField();
    private JTextField priceTF = new JTextField();
    private JTextField num_StockTF = new JTextField();
    private JTextField cash_PriceTF = new JTextField();
    private JTextField cpu_SocketTF = new JTextField();
    private JTextField mem_TypeTF = new JTextField();
    private JTextField form_FactorTF = new JTextField();

    private JButton insertBTN = new JButton("INSERT");

    private JPanel buttonsPanel = new JPanel();


    AddToInventory(){
        this.setLayout(new BorderLayout());

        moboAddPanel.setLayout(new GridLayout(8, 3));

        moboAddPanel.add(brand);
        moboAddPanel.add(brandTF);

        moboAddPanel.add(model);
        moboAddPanel.add(modelTF);

        moboAddPanel.add(price);
        moboAddPanel.add(priceTF);

        moboAddPanel.add(num_Stock);
        moboAddPanel.add(num_StockTF);

        moboAddPanel.add(cash_Price);
        moboAddPanel.add(cash_PriceTF);

        moboAddPanel.add(cpu_Socket);
        moboAddPanel.add(cpu_SocketTF);

        moboAddPanel.add(mem_Type);
        moboAddPanel.add(mem_TypeTF);

        moboAddPanel.add(form_Factor);
        moboAddPanel.add(form_FactorTF);



        tabbedPane.add("Add MOBO", moboAddPanel);
        tabbedPane.add("Add CPU", cpuAddPanel);

        ActionListener();

        buttonsPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.add(backButton);
        buttonsPanel.add(insertBTN);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.setTitle("Add items to Inventory");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void insertToSQL(){
        try{
            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user,password);

            String QUERY = "INSERT INTO MOBO(Brand, Model, Price, Num_Stock, Cash_Price, CPU_Socket, Memory_type, Form_Factor)" +
                    "VALUES(?, ? ,?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(QUERY);
            String Brand = brandTF.getText().toString();
            String Model = modelTF.getText().toString();
            int Price = Integer.parseInt(priceTF.getText());
            int Num_Stock = Integer.parseInt(num_StockTF.getText());
            int Cash_Price = Integer.parseInt(cash_PriceTF.getText());
            String CPU_Socket = cpu_SocketTF.getText().toString();
            String Memory_type = mem_TypeTF.getText().toString();
            String Form_Factor = form_FactorTF.getText().toString();

            statement.setString(1, Brand);
            statement.setString(2, Model);
            statement.setInt(3, Price);
            statement.setInt(4, Num_Stock);
            statement.setInt(5, Cash_Price);
            statement.setString(6, CPU_Socket);
            statement.setString(7, Memory_type);
            statement.setString(8, Form_Factor);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Data Inserted Baby");

            statement.close();


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void ActionListener(){
        insertBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getRowCount() <= 15){
                    insertToSQL();
                }else if(getRowCount() > 15){
                    JOptionPane.showMessageDialog(null, "15 is the max Product");
                }


                brandTF.setText("");
                modelTF.setText("");
                priceTF.setText("");
                num_StockTF.setText("");
                cash_PriceTF.setText("");
                cpu_SocketTF.setText("");
                mem_TypeTF.setText("");
                form_FactorTF.setText("");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.addToInventory.dispose();
            }
        });
    }

    public static int getRowCount(){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
        String user = "papers";
        String password = "papersarewhite";
        int count = 0;

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT COUNT (*) as 'rowcount' From MOBO;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();
            count += resultSet.getInt("rowcount");
            resultSet.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  count;
    }

    public static void main(String[] args) {
        new AddToInventory();
    }
}
