import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainGUI extends JFrame implements ActionListener {
    static MainGUI mainGUI;
    private Panel receiptPanel  = new Panel();
    private JPanel northReceiptPanel = new JPanel();
    private JPanel centerReceiptPanel = new JPanel();
    private Panel itemPanel = new Panel();
    private Panel categoryPanel = new Panel();
    private Panel qtyPanel = new Panel();
    private JPanel functionPanel = new JPanel();


    private JLabel titleCategory = new JLabel("CATEGORY:");

    private JButton mouseCategoryBtn = new JButton("MOUSE");
    private JButton kbCategoryBtn = new JButton("KEYBOARD");
    private JButton headsetCategoryBtn = new JButton("HEADSET");
    private JButton cpuCategoryBtn = new JButton("CPU");
    private JButton gpuCategoryBtn = new JButton("GRAPHICS CARD");
    private JButton moboCategoryBtn = new JButton("MOTHERBOARD");
    private JButton ssdCategoryBtn = new JButton("SSD");
    private JButton hddCategoryBtn = new JButton("HDD");
    private JButton ramCategoryBtn = new JButton("RAM");
    private JButton caseCategoryBtn = new JButton("CASE");

    private JButton inventoryBtn = new JButton("Inventory");
    private JButton updateBtn = new JButton("Update");
    private JButton ordersBtn = new JButton("Orders");
    private JButton addBtn = new JButton("Add");
    private JButton deleteBtn = new JButton("Delete");

    private JButton item1 = new JButton("Item 1");
    private JButton item2 = new JButton("Item 2");
    private JButton item3 = new JButton("Item 3");
    private JButton item4 = new JButton("Item 4");
    private JButton item5 = new JButton("Item 5");
    private JButton item6 = new JButton("Item 6");
    private JButton item7 = new JButton("Item 7");
    private JButton item8 = new JButton("Item 8");
    private JButton item9 = new JButton("Item 9");
    private JButton item10 = new JButton("Item 10");
    private JButton item11 = new JButton("Item 11");
    private JButton item12 = new JButton("Item 12");
    private JButton item13 = new JButton("Item 13");
    private JButton item14 = new JButton("Item 14");
    private JButton item15 = new JButton("Item 15");

    private JRadioButton checkbox1 = new JRadioButton("1");
    private JRadioButton checkBox2 = new JRadioButton("2");
    private JRadioButton checkbox3 = new JRadioButton("3");
    private JRadioButton checkbox4 = new JRadioButton("4");
    private JRadioButton checkbox5 = new JRadioButton("5");
    private JRadioButton checkbox6 = new JRadioButton("6");
    private JRadioButton checkbox7 = new JRadioButton("7");
    private JRadioButton checkbox8 = new JRadioButton("8");
    private JRadioButton checkbox9 = new JRadioButton("9");
    private JRadioButton checkbox10 = new JRadioButton("10");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JLabel loggedInTxt = new JLabel("Logged in: ");
    private JLabel loggedInAs = new JLabel(LoginGUI.getAccFName());

    private JLabel totalAmountTXT = new JLabel("TOTAL: ");
    private JLabel totalAmount = new JLabel("1234567890");

    private JLabel youPayTXT = new JLabel("You Pay: ");
    private JLabel youPay = new JLabel("1234567890");

    private JLabel exchangeTXT = new JLabel("Exchange: ");
    private JLabel exchange = new JLabel("1234567890");

    JTextArea receiptDescription = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(receiptDescription);

    private JButton payButton = new JButton("PAY");

    public void addComponents(){
        categoryPanel.add(mouseCategoryBtn);
        categoryPanel.add(kbCategoryBtn);
        categoryPanel.add(headsetCategoryBtn);
        categoryPanel.add(cpuCategoryBtn);
        categoryPanel.add(gpuCategoryBtn);
        categoryPanel.add(moboCategoryBtn);
        categoryPanel.add(ssdCategoryBtn);
        categoryPanel.add(hddCategoryBtn);
        categoryPanel.add(ramCategoryBtn);
        categoryPanel.add(caseCategoryBtn);
        categoryPanel.add(loggedInAs);
        categoryPanel.add(loggedInTxt);

        itemPanel.add(item1);
        itemPanel.add(item2);
        itemPanel.add(item3);
        itemPanel.add(item4);
        itemPanel.add(item5);
        itemPanel.add(item6);
        itemPanel.add(item7);
        itemPanel.add(item8);
        itemPanel.add(item9);
        itemPanel.add(item10);
        itemPanel.add(item11);
        itemPanel.add(item12);
        itemPanel.add(item13);
        itemPanel.add(item14);
        itemPanel.add(item15);


        functionPanel.add(ordersBtn);

        qtyPanel.add(checkbox1);

        qtyPanel.add(checkBox2);
        qtyPanel.add(checkbox3);
        qtyPanel.add(checkbox4);
        qtyPanel.add(checkbox5);
        qtyPanel.add(checkbox6);
        qtyPanel.add(checkbox7);
        qtyPanel.add(checkbox8);
        qtyPanel.add(checkbox9);
        qtyPanel.add(checkbox10);
        buttonGroup.add(checkbox1);
        buttonGroup.add(checkBox2);
        buttonGroup.add(checkbox3);
        buttonGroup.add(checkbox4);
        buttonGroup.add(checkbox5);
        buttonGroup.add(checkbox6);
        buttonGroup.add(checkbox7);
        buttonGroup.add(checkbox8);
        buttonGroup.add(checkbox9);
        buttonGroup.add(checkbox10);

        receiptPanel.add(northReceiptPanel);
        receiptPanel.add(centerReceiptPanel);

        northReceiptPanel.add(totalAmountTXT);
        northReceiptPanel.add(totalAmount);
        northReceiptPanel.add(youPayTXT);
        northReceiptPanel.add(youPay);
        northReceiptPanel.add(exchangeTXT);
        northReceiptPanel.add(exchange);

        centerReceiptPanel.add(scrollPane);


        categoryPanel.add(titleCategory);

        receiptPanel.add(payButton);
    }
    public void setBound(){
        receiptPanel.setBounds(10, 10, 600, 700);
        itemPanel.setBounds(815, 60, 655, 590);
        categoryPanel.setBounds(615, 10, 195, 700);
        titleCategory.setBounds(40,0,130, 30);
        functionPanel.setBounds(815, 655, 655,55);
        qtyPanel.setBounds(815, 10, 655, 45);

        mouseCategoryBtn.setBounds(0,50, 195, 50);
        kbCategoryBtn.setBounds(0, 110, 195, 50);
        headsetCategoryBtn.setBounds(0, 170, 195, 50);
        cpuCategoryBtn.setBounds(0, 230, 195, 50);
        gpuCategoryBtn.setBounds(0, 290, 195, 50);
        moboCategoryBtn.setBounds(0, 350, 195, 50);
        ssdCategoryBtn.setBounds(0, 410, 195, 50);
        hddCategoryBtn.setBounds(0, 470, 195, 50);
        ramCategoryBtn.setBounds(0, 530, 195, 50);
        caseCategoryBtn.setBounds(0, 590, 195, 50);
        loggedInTxt.setBounds(0, 640, 195, 50);
        loggedInAs.setBounds(90, 640, 195, 50);


        northReceiptPanel.setBounds(0,0, 600, 100);
        centerReceiptPanel.setBounds(0, 100, 600, 550);


        scrollPane.setBounds(0,0,600, 550);

        totalAmountTXT.setBounds(0,0, 300, 100);
        totalAmount.setBounds(80, 0, 220, 100);
        youPayTXT.setBounds(310, 0, 290, 50);
        youPay.setBounds(405, 0, 290, 50);
        exchangeTXT.setBounds(310, 50, 290, 50);
        exchange.setBounds(420, 50, 290, 50);

        payButton.setBounds(0, 650, 600, 50);


    }
    public void setBackground(){
        receiptPanel.setBackground(new Color(0x626060));
        itemPanel.setBackground(new Color(0x626060));
        categoryPanel.setBackground(new Color(0x626060));
        functionPanel.setBackground(new Color(0x626060));


        checkbox1.setBackground(new Color(0x142d3a));
        checkBox2.setBackground(new Color(0x142d3a));
        checkbox3.setBackground(new Color(0x142d3a));
        checkbox4.setBackground(new Color(0x142d3a));
        checkbox5.setBackground(new Color(0x142d3a));
        checkbox6.setBackground(new Color(0x142d3a));
        checkbox7.setBackground(new Color(0x142d3a));
        checkbox8.setBackground(new Color(0x142d3a));
        checkbox9.setBackground(new Color(0x142d3a));
        checkbox10.setBackground(new Color(0x142d3a));


        northReceiptPanel.setBackground(new Color(0x142d3a));
        centerReceiptPanel.setBackground(Color.green);

//                 qtyPanel.setBackground(new Color(0x626060));


    }
    public void setLayout(){
        receiptPanel.setLayout(null);
        itemPanel.setLayout(new GridLayout(5, 3));
        qtyPanel.setLayout(new GridLayout(1, 10));
        functionPanel.setLayout(new GridLayout(1, 5));

        northReceiptPanel.setLayout(null);
        centerReceiptPanel.setLayout(null);

        categoryPanel.setLayout(null);





    }
    public void setForeground(){
        checkbox1.setForeground(new Color(0xFFFFFF));
        checkBox2.setForeground(new Color(0xFFFFFF));
        checkbox3.setForeground(new Color(0xFFFFFF));
        checkbox4.setForeground(new Color(0xFFFFFF));
        checkbox5.setForeground(new Color(0xFFFFFF));
        checkbox6.setForeground(new Color(0xFFFFFF));
        checkbox7.setForeground(new Color(0xFFFFFF));
        checkbox8.setForeground(new Color(0xFFFFFF));
        checkbox9.setForeground(new Color(0xFFFFFF));
        checkbox10.setForeground(new Color(0xFFFFFF));

        titleCategory.setForeground(new Color(0xFFFFFF));

        loggedInTxt.setForeground(new Color(0xFFFFFF));
        loggedInAs.setForeground(new Color(0xFFFFFF));

        totalAmountTXT.setForeground(new Color(0xFFFFFF));
        totalAmount.setForeground(new Color(0xFFFFFF));
        youPayTXT.setForeground(new Color(0xFFFFFF));
        youPay.setForeground(new Color(0xFFFFFF));
        exchangeTXT.setForeground(new Color(0xFFFFFF));
        exchange.setForeground(new Color(0xFFFFFF));



    }
    public void setFont(){
        titleCategory.setFont(new Font("Arial", Font.ITALIC, 20));

        loggedInTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        loggedInAs.setFont(new Font("Arial", Font.BOLD, 20));

        totalAmountTXT.setFont(new Font("Arial", Font.BOLD, 20));
        totalAmount.setFont(new Font("Arial", Font.BOLD, 20));

        youPayTXT.setFont(new Font("Arial", Font.BOLD, 20));
        youPay.setFont(new Font("Arial", Font.BOLD, 20));
        exchangeTXT.setFont(new Font("Arial", Font.BOLD, 20));
        exchange.setFont(new Font("Arial", Font.BOLD, 20));
        receiptDescription.setFont(new Font("Monospace", Font.PLAIN, 10));

    }
    public void setBorder(){
        totalAmountTXT.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        youPayTXT.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        exchangeTXT.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }
    public void addActionListener(){
        inventoryBtn.addActionListener(this);
        ordersBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        addBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        item7.addActionListener(this);
        item8.addActionListener(this);
        item9.addActionListener(this);
        item10.addActionListener(this);
        item11.addActionListener(this);
        item12.addActionListener(this);
        item13.addActionListener(this);
        item14.addActionListener(this);
        item15.addActionListener(this);

    }

    MainGUI(){
        addComponents();
        setBound();
        setBackground();
        setLayout();
        setForeground();
        setFont();
        setBorder();
        addActionListener();




        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        receiptDescription.setLineWrap(true);
//        receiptDescription.setEditable(false);
//        setTextReceiptDescription();

        
        setItemPanelName();

        this.add(receiptPanel);
        this.add(itemPanel);
        this.add(categoryPanel);
        this.add(qtyPanel);
        this.add(functionPanel);


        this.setTitle("Karl Marx Roxas");
        this.getContentPane().setBackground(new Color(0x142d3a));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1500, 760);
        this.setLayout(null);
        this.setVisible(true);

        if(ConnectUserSQL.isManagerAccess()) {
            functionPanel.add(inventoryBtn);
            functionPanel.add(updateBtn);
            functionPanel.add(addBtn);
            functionPanel.add(deleteBtn);
        }


    }
    public void setTextReceiptDescription(String s){
        receiptDescription.setText(s);
    }

    public int getTotalAmount(){
        return Integer.parseInt(totalAmount.getText());
    }

    static Inventory inventory;
    static AddToInventory addToInventory;
    static UpdateInventory updateInventory;
    static DeleteFromInventory deleteFromInventory;

    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == inventoryBtn) {
                inventory = new Inventory();
            }
            if(e.getSource() == addBtn){
                addToInventory = new AddToInventory();
            }
            if(e.getSource() == updateBtn){
                updateInventory = new UpdateInventory();
            }
            if(e.getSource() == deleteBtn){
                deleteFromInventory = new DeleteFromInventory();
            }

    }

    public void setItemPanelName(){

        try{

                String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
                String user = "papers";
                String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url,user, password);
            String QUERY = "SELECT Brand, Model from MOBO";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            ArrayList<String> brand = new ArrayList<>();
            ArrayList<String> model = new ArrayList<>();

            int i = 0;
            while(resultSet.next()){
                String Brand = resultSet.getString("Brand");
                String Model = resultSet.getString("Model");

                brand.add(Brand);
                model.add(Model);

            }

            item1.setText("<html><center>"+brand.get(0)+"<br>"+model.get(0)+"</center></html>");
            item2.setText("<html><center>"+brand.get(1)+"<br>"+model.get(1)+"</center></html>");
            item3.setText("<html><center>"+brand.get(2)+"<br>"+model.get(2)+"</center></html>");
            item4.setText("<html><center>"+brand.get(3)+"<br>"+model.get(3)+"</center></html>");
            item5.setText("<html><center>"+brand.get(4)+"<br>"+model.get(4)+"</center></html>");
            item6.setText("<html><center>"+brand.get(5)+"<br>"+model.get(5)+"</center></html>");
            item7.setText("<html><center>"+brand.get(6)+"<br>"+model.get(6)+"</center></html>");
            item8.setText("<html><center>"+brand.get(7)+"<br>"+model.get(7)+"</center></html>");
            item9.setText("<html><center>"+brand.get(8)+"<br>"+model.get(8)+"</center></html>");
            item10.setText("<html><center>"+brand.get(9)+"<br>"+model.get(9)+"</center></html>");
            item11.setText("<html><center>"+brand.get(10)+"<br>"+model.get(10)+"</center></html>");
            item12.setText("<html><center>"+brand.get(11)+"<br>"+model.get(11)+"</center></html>");
            item13.setText("<html><center>"+brand.get(12)+"<br>"+model.get(12)+"</center></html>");
            item14.setText("<html><center>"+brand.get(12)+"<br>"+model.get(13)+"</center></html>");
            item15.setText("<html><center>"+brand.get(12)+"<br>"+model.get(14)+"</center></html>");


        }catch (Exception ex){

        }
    }


}

// TODO: Buttons in order and receipt