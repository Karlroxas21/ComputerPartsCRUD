import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inventory extends JFrame {
    static DBConnect url = DBConnect.URL;
    static DBConnect user = DBConnect.USER;
    static DBConnect pw = DBConnect.PASSWORD;

    JButton backButton = new JButton("Back");

    private JTable moboTable = new JTable();
    private JTable cpuTable = new JTable();
    private JPanel moboPanel = new JPanel();
    private JPanel cpuPanel = new JPanel();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JScrollPane scrollpane1 = new JScrollPane();
    private JScrollPane scrollpane2 = new JScrollPane();

    DefaultTableModel moboDTM;

    Inventory(){

        setLayout(new BorderLayout());

        //Temporary kasi wala pa tayong cpu products
        cpuTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null},

                },
                new String[]{
                        "Title Mobo", "Title 2", "Title 3", "Title 4"
                }
        ));

        setMoboTable();
        moboTable.setModel(moboDTM);
        moboTable.setShowGrid(true);
        moboTable.setShowVerticalLines(true);
        moboTable.setEnabled(false);
        scrollpane1.setViewportView(moboTable);
        scrollpane1.setSize(500, 500);
        moboPanel.setLayout(new CardLayout());
        moboPanel.add(scrollpane1);

        scrollpane2.setViewportView(cpuTable);
        cpuPanel.add(scrollpane2);

        tabbedPane.add("Motherboard", moboPanel);
        tabbedPane.add("CPU", cpuPanel);

        ActionListener();

        this.add(backButton, BorderLayout.SOUTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.setTitle("Inventory");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //Display table sa System natin galing sa DB
    public void setMoboTable(){
        try{

            Connection connection = DriverManager.getConnection(url.getDBConnect(), user.getDBConnect(), pw.getDBConnect());
            String QUERY = "SELECT * FROM MOBO";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            String[] columns = {"Product_ID", "Brand", "Model", "Price", "Num_Stock", "Cash_Price",
                    "CPU_Socket", "Memory_type", "Form_Factor"};

            Object[][] data = new String[AddToInventory.getRowCount()][9];
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
            resultSet.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
    public void ActionListener(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.inventory.dispose();
            }
        });
    }
}
