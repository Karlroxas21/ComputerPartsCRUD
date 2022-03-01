import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteFromInventory extends JFrame{
    private JButton backBtn = new JButton("Back");
    private JButton deleteBtn = new JButton("Delete");
    private JButton refreshBtn = new JButton("Refresh");

    private JPanel buttonsPanel = new JPanel();

    DefaultTableModel moboDTM;
    JScrollPane scrollPane1 = new JScrollPane();
    JTable moboTable = new JTable();

    private JPanel moboDeletePanel = new JPanel();
    private JPanel cpuDeletePanel = new JPanel();
    private JTabbedPane tabbedPane = new JTabbedPane();

    private JPanel deleteMoboComponents = new JPanel();

    private JLabel productID = new JLabel("Product ID: ");
    private JTextField productID_TF = new JTextField();


    DeleteFromInventory(){
        this.setLayout(new BorderLayout());

        setMoboTable();
        moboTable.setModel(moboDTM);
        moboTable.setShowGrid(true);
        moboTable.setShowVerticalLines(true);
        moboTable.setEnabled(false);
        scrollPane1.setViewportView(moboTable);

        deleteMoboComponents.setLayout(new GridLayout(1, 2));
        deleteMoboComponents.add(productID);
        deleteMoboComponents.add(productID_TF);


        moboDeletePanel.setLayout(new GridLayout(1, 2));

        moboDeletePanel.add(deleteMoboComponents);
        moboDeletePanel.add(scrollPane1);

        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(backBtn);
        buttonsPanel.add(deleteBtn);
        buttonsPanel.add(refreshBtn);


        tabbedPane.add("Update Mobo", moboDeletePanel);
        tabbedPane.add("Update CPU", cpuDeletePanel);

        ActionListener();


        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.setTitle("Delete Items in Inventory");
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

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMobo();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.deleteFromInventory.dispose();
            }
        });
    }
    public void deleteMobo(){
        try{
            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "DELETE MOBO where Product_ID = ?";

            PreparedStatement statement = connection.prepareStatement(QUERY);

            int Product_ID = Integer.parseInt(String.valueOf(productID_TF.getText()));
            statement.setInt(1, Product_ID);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Deleted Baby");

            statement.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new DeleteFromInventory();
    }
}
