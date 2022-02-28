import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateInventory extends JFrame {
    private JButton backBtn = new JButton("Back");
    private JButton updateBtn = new JButton("Update");
    private JButton refreshBtn = new JButton("Refresh");

    private JPanel buttonsPanel = new JPanel();

    DefaultTableModel moboDTM;
    JScrollPane scrollPane1 = new JScrollPane();
    JTable moboTable = new JTable();

    private JPanel moboUpdatePanel = new JPanel();
    private JPanel cpuUpdatePanel = new JPanel();
    private JTabbedPane tabbedPane = new JTabbedPane();

    private JPanel updateMoboComponents = new JPanel(); // will add here the components of the UPDATES

    private JLabel productID = new JLabel("Product ID: ");
    private JTextField productID_TF = new JTextField();

    private JLabel updatePrice_Lbl = new JLabel("Update Price: ");
    private JTextField updatePrice_TF = new JTextField();

    private JLabel numStock_Lbl = new JLabel("Update Stock: ");
    private JTextField numStock_TF = new JTextField();

    private JLabel cashPrice_Lbl = new JLabel("Update Cash Price: ");
    private JTextField cashPrice_TF = new JTextField();





    UpdateInventory(){
        this.setLayout(new BorderLayout());

        setMoboTable();
        moboTable.setModel(moboDTM);
        moboTable.setShowGrid(true);
        moboTable.setShowVerticalLines(true);
        moboTable.setEnabled(false);
        scrollPane1.setViewportView(moboTable);

        updateMoboComponents.setLayout(new GridLayout(4, 2));
        updateMoboComponents.add(productID);
        updateMoboComponents.add(productID_TF);
        updateMoboComponents.add(updatePrice_Lbl);
        updateMoboComponents.add(updatePrice_TF);
        updateMoboComponents.add(numStock_Lbl);
        updateMoboComponents.add(numStock_TF);
        updateMoboComponents.add(cashPrice_Lbl);
        updateMoboComponents.add(cashPrice_TF);

        moboUpdatePanel.setLayout(new GridLayout(1, 2));

        moboUpdatePanel.add(updateMoboComponents);
        moboUpdatePanel.add(scrollPane1);

        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(backBtn);
        buttonsPanel.add(updateBtn);
        buttonsPanel.add(refreshBtn);


        tabbedPane.add("Update Mobo", moboUpdatePanel);
        tabbedPane.add("Update CPU", cpuUpdatePanel);

        ActionListener();


        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.setTitle("Update Items in Inventory");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void setMoboTable(){
        try{

            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT * FROM MOBO";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            String[] columns = {"Product_ID", "Brand", "Model", "Price", "Num_Stock", "Cash_Price",
                    "CPU_Socket", "Memory_type", "Form_Factor"};

            Object[][] data = new String[20][9];
            int i = 0;
            while (resultSet.next()) {
                int Product_ID = resultSet.getInt("Product_ID");
                String brand = resultSet.getString("Brand");
                String model = resultSet.getString("Model");
                int price = resultSet.getInt("Price");
                int num_Stock = resultSet.getInt("Num_Stock");
                int cash_Price = resultSet.getInt("Cash_Price");
                String cpu_Socket = resultSet.getString("CPU_Socket");
                String memory_Type = resultSet.getString("Memory_type");
                String form_Factor = resultSet.getString("Form_Factor");
                data[i][0] = Product_ID + "";
                data[i][1] = brand;
                data[i][2] = model;
                data[i][3] = String.valueOf(price).toString();
                data[i][4] = String.valueOf(num_Stock).toString();
                data[i][5] = String.valueOf(cash_Price).toString();
                data[i][6] = cpu_Socket;
                data[i][7] = memory_Type;
                data[i][8] = form_Factor;
                i++;
            }

            moboDTM = new DefaultTableModel(data, columns);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void ActionListener(){
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMoboTable();
                moboTable.setModel(moboDTM);
                moboTable.setShowGrid(true);
                moboTable.setShowVerticalLines(true);
                moboTable.setEnabled(false);
                scrollPane1.setViewportView(moboTable);
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!updatePrice_TF.getText().toString().equals("")) {
                    updateMoboPrice();
                }
                if(!numStock_TF.getText().toString().equals("")){
                    updateMoboStock();
                }
                if(!cashPrice_TF.getText().toString().equals("")){
                    updateCashPrice();
                }

            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.updateInventory.dispose();
            }
        });
    }
    public void updateMoboPrice(){
        try{
            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "UPDATE MOBO set Price= ? where Product_ID = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);

            int price = Integer.parseInt(String.valueOf(updatePrice_TF.getText()));
            int Product_ID = Integer.parseInt(String.valueOf(productID_TF.getText()));

            statement.setInt(1, price);
            statement.setInt(2, Product_ID);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Updated Price Baby");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateMoboStock(){
        try{
            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "UPDATE MOBO set Num_Stock= ? where Product_ID = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);

            int num_Stock = Integer.parseInt(String.valueOf(numStock_TF.getText()));
            int Product_ID = Integer.parseInt(String.valueOf(productID_TF.getText()));

            statement.setInt(1, num_Stock);
            statement.setInt(2, Product_ID);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Updated Stock Baby");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateCashPrice(){
        try{
            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "UPDATE MOBO set Cash_Price= ? where Product_ID = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);

            int cash_Price = Integer.parseInt(String.valueOf(cashPrice_TF.getText()));
            int Product_ID = Integer.parseInt(String.valueOf(productID_TF.getText()));

            statement.setInt(1, cash_Price);
            statement.setInt(2, Product_ID);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Updated Cash Price Baby");

            statement.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UpdateInventory();
    }
}
