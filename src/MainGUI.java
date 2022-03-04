import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
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
    private JLabel totalAmount = new JLabel();

    private JLabel youPayTXT = new JLabel("You Pay: ");
    private JTextField youPay = new JTextField();

    private JLabel exchangeTXT = new JLabel("Exchange: ");
    private JLabel exchange = new JLabel("1234567890");

    static JTextArea receiptDescription = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(receiptDescription);

    private JButton payButton = new JButton("PAY");

    int QTY;


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
        exchangeTXT.setForeground(new Color(0xFFFFFF));
        exchange.setForeground(new Color(0xFFFFFF));

        youPay.setForeground(Color.BLACK);



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

        checkbox1.addActionListener(this);
        checkBox2.addActionListener(this);
        checkbox3.addActionListener(this);
        checkbox4.addActionListener(this);
        checkbox5.addActionListener(this);
        checkbox6.addActionListener(this);
        checkbox7.addActionListener(this);
        checkbox8.addActionListener(this);
        checkbox9.addActionListener(this);
        checkbox10.addActionListener(this);
        payButton.addActionListener(this);


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



        receiptDescription.setFont(new Font("monospaced", Font.PLAIN, 12));
//        importFont();


        receiptDescription.setText(String.valueOf(receiptSB));

        this.add(receiptPanel);
        this.add(itemPanel);
        this.add(categoryPanel);
        this.add(qtyPanel);
        this.add(functionPanel);

        receiptDescription.setEditable(false);


        this.setTitle("Karl Marx Roxas");
        this.getContentPane().setBackground(new Color(0x142d3a));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1500, 760);
        this.setLayout(null);
        this.setVisible(true);

        //if not manager then the buttons will be not added.
        if(ConnectUserSQL.isManagerAccess()) {
            functionPanel.add(inventoryBtn);
            functionPanel.add(updateBtn);
            functionPanel.add(addBtn);
            functionPanel.add(deleteBtn);
        }


    }


    public void setTotalAmount(int i){
        totalAmount.setText(String.valueOf(i).toString());
    }

    public int getPayment(){
        return Integer.parseInt(youPay.getText().toString());
    }


    static Inventory inventory;
    static AddToInventory addToInventory;
    static UpdateInventory updateInventory;
    static DeleteFromInventory deleteFromInventory;

    public static void main(String[] args) {
        new MainGUI();

    }
    public void resetButtonGroup(){
        buttonGroup.clearSelection();
        QTY = 0;
    }

    static int receiptNum = 1000;
    static String cashier = LoginGUI.getAccFName() + " " + LoginGUI.getAccLName();

    //Default string in Receipt
    static StringBuilder receiptSB = new StringBuilder(String.format("**************************************" + "\n"
            + "Computer Parts/Peripherals Point of Sale System" + "\n"
            + "TIN No.: 010-021-930-002"
            + "Contact No-09298359386" + "\n"
            + "Address- Manila City" + "\n"
            + "**************************************" + "\n"
            + "SALES NOTICE" + "\n"
            + "Cashier: " + cashier + "\n"
            + "**************************************" + "\n"
            + "%-10s %20s %30s\n", "QTY", "Description", "Price"));


    static int price = 0;
    int totalItems = 0;


    public static int getTotalAmount(){
        return price;
    }

    Pay pay;
    static Double total;
    static Double totalWithTAX;
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
            if(e.getSource() == item1){

                if(QTY != 0) {
                    if(QTY <= checkItemStock(1006)) {
                        price += checkItemPrice(1006) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);

                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%5s", brand.get(0) + " " + model.get(0)));
                        receiptDescription.append(String.format("%19d", checkItemPrice(1006)));
                        minusItemStock(1006, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1006) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%5s", brand.get(0) + " " + model.get(0)));
//                receiptDescription.append(String.format("%19d", checkItemPrice(1006)));



            }
            if(e.getSource() == item2){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1007)) {
                        price += checkItemPrice(1007) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(1) + " " + model.get(1)));
                        receiptDescription.append(String.format("%36d", checkItemPrice(1007)));
                        minusItemStock(1007, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1007) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(1) + " " + model.get(1)));
//                receiptDescription.append(String.format("%36d", checkItemPrice(1007)));


            }
            if(e.getSource() == item3){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1008)) {
                        price += checkItemPrice(1008) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(2) + " " + model.get(2)));
                        receiptDescription.append(String.format("%32d", checkItemPrice(1008)));
                        minusItemStock(1008, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1008) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(2) + " " + model.get(2)));
//                receiptDescription.append(String.format("%32d", checkItemPrice(1008)));

            }
            if(e.getSource() == item4){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1009)) {
                        price += checkItemPrice(1009) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(3) + " " + model.get(3)));
                        receiptDescription.append(String.format("%32d", checkItemPrice(1009)));
                        minusItemStock(1009, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1009) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(3) + " " + model.get(3)));
//                receiptDescription.append(String.format("%32d", checkItemPrice(1009)));


            }
            if(e.getSource() == item5){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1010)) {
                        price += checkItemPrice(1010) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(4) + " " + model.get(4)));
                        receiptDescription.append(String.format("%28s", checkItemPrice(1010)));
                        minusItemStock(1010, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1010) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(4) + " " + model.get(4)));
//                receiptDescription.append(String.format("%28s", checkItemPrice(1010)));

            }
            if(e.getSource() == item6){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1011)) {
                        price += checkItemPrice(1011) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(5) + " " + model.get(5)));
                        receiptDescription.append(String.format("%32s", checkItemPrice(1011)));
                        minusItemStock(1011, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1011) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(5) + " " + model.get(5)));
//                receiptDescription.append(String.format("%32s", checkItemPrice(1011)));

            }
            if(e.getSource() == item7){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1012)) {
                        price += checkItemPrice(1012) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(6) + " " + model.get(6)));
                        receiptDescription.append(String.format("%33s", checkItemPrice(1012)));
                        minusItemStock(1012, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1012) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(6) + " " + model.get(6)));
//                receiptDescription.append(String.format("%33s", checkItemPrice(1012)));

            }
            if(e.getSource() == item8){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1013)) {
                        price += checkItemPrice(1013) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-9s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(7) + " " + model.get(7)));
                        receiptDescription.append(String.format("%37s", checkItemPrice(1013)));
                        minusItemStock(1013, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1013) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-9s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(7) + " " + model.get(7)));
//                receiptDescription.append(String.format("%37s", checkItemPrice(1013)));

            }
            if(e.getSource() == item9){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1014)) {
                        price += checkItemPrice(1014) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);

                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(8) + " " + model.get(8)));
                        receiptDescription.append(String.format("%25d", checkItemPrice(1014)));
                        minusItemStock(1014, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1014) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(8) + " " + model.get(8)));
//                receiptDescription.append(String.format("%25d", checkItemPrice(1014)));


            }
            if(e.getSource() == item10){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1015)) {
                        price += checkItemPrice(1015) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(9) + " " + model.get(9)));
                        receiptDescription.append(String.format("%32d", checkItemPrice(1015)));
                        minusItemStock(1015, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1015) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(9) + " " + model.get(9)));
//                receiptDescription.append(String.format("%32d", checkItemPrice(1015)));


            }
            if(e.getSource() == item11){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1016)) {
                        price += checkItemPrice(1016) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(10) + " " + model.get(10)));
                        receiptDescription.append(String.format("%16d", checkItemPrice(1016)));
                        minusItemStock(1016, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1016) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(10) + " " + model.get(10)));
//                receiptDescription.append(String.format("%16d", checkItemPrice(1016)));

            }
            if(e.getSource() == item12){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1017)) {
                        price += checkItemPrice(1017) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(11) + " " + model.get(11)));
                        receiptDescription.append(String.format("%25d", checkItemPrice(1017)));
                        minusItemStock(1017, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1017) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%15s", brand.get(11) + " " + model.get(11)));
//                receiptDescription.append(String.format("%25d", checkItemPrice(1017)));

            }
            if(e.getSource() == item13){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1018)) {
                        price += checkItemPrice(1018) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%15s", brand.get(12) + " " + model.get(12)));
                        receiptDescription.append(String.format("%36d", checkItemPrice(1018)));
                        minusItemStock(1018, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1018) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                receiptDescription.append(String.format("%15s", brand.get(12) + " " + model.get(12)));
                receiptDescription.append(String.format("%36d", checkItemPrice(1018)));

            }
            if(e.getSource() == item14){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1019)) {
                        price += checkItemPrice(1019) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%13s", brand.get(13) + " " + model.get(13)));
                        receiptDescription.append(String.format("%39d", checkItemPrice(1019)));
                        minusItemStock(1019, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1019) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%13s", brand.get(13) + " " + model.get(13)));
//                receiptDescription.append(String.format("%39d", checkItemPrice(1019)));

            }
            if(e.getSource() == item15){
                if(QTY != 0) {
                    if(QTY <= checkItemStock(1020)) {
                        price += checkItemPrice(1020) * QTY;
                        totalItems += QTY;
                        setTotalAmount(price);


                        receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
                        receiptDescription.append(String.format("%13s", brand.get(14) + " " + model.get(14)));
                        receiptDescription.append(String.format("%33d", checkItemPrice(1020)));
                        minusItemStock(1020, QTY);
                        resetButtonGroup();
                    }else
                        JOptionPane.showMessageDialog(null, "We have only " + checkItemStock(1020) + " Stock");
                }else{
                    JOptionPane.showMessageDialog(null, "Choose QTY ");
                }
//                receiptDescription.append(String.format("\n" + "%-10s", String.valueOf(QTY)));
//                receiptDescription.append(String.format("%13s", brand.get(14) + " " + model.get(14)));
//                receiptDescription.append(String.format("%33d", checkItemPrice(1020)));

            }
            if(e.getSource() == payButton){


                char pesoSign = '\u20B1';
                receiptNum++;

                receiptDescription.append(String.format("\n"+"%70s", "---------------------"));
                receiptDescription.append(String.format("%134s", String.valueOf(totalItems).toString() + " Item(s)"));
                receiptDescription.append(String.format("%23d", price));
                receiptDescription.append(String.format("\n"+"%70s", "---------------------"));
                receiptDescription.append(String.format("%142s", "Amount Due        : "));
                receiptDescription.append(String.format("%1s", String.valueOf(pesoSign)));
                receiptDescription.append(String.format("%5d", price));

                Double vat = (double) (price * (12 / 100.0f));
                total = Double.parseDouble(vat.toString()) + price;
                totalWithTAX = Double.parseDouble(vat.toString()) + price;
                receiptDescription.append(String.format("%76s", "VAT AMOUNT(12%)   : "));
                receiptDescription.append(String.format("%2.2f", Double.parseDouble(String.valueOf(vat))));
                receiptDescription.append(String.format("%79s", "TOTAL             : "));
                receiptDescription.append(String.format("%2.2f", Double.parseDouble(String.valueOf(total))));

                receiptDescription.append(String.format("%80s", "Receipt Number    :  "));
                receiptDescription.append(String.format("%3d", receiptNum)); //TODO: the receipt num should be located at database!







                pay = new Pay();


            }
            if(e.getSource() == checkbox1){
                QTY = 1;
            }
            if(e.getSource() == checkBox2){
                QTY = 2;
            }
            if(e.getSource() == checkbox3){
                QTY = 3;
            }
            if(e.getSource() == checkbox4){
                QTY = 4;
            }
            if(e.getSource() == checkbox5){
                QTY = 5;
            }
            if(e.getSource() == checkbox6){
                QTY = 6;
            }
            if(e.getSource() == checkbox7){
                QTY = 7;
            }
            if(e.getSource() == checkbox8){
                QTY = 8;
            }
            if(e.getSource() == checkbox9){
                QTY = 9;
            }
            if(e.getSource() == checkbox10){
                QTY = 10;
            }

    }


    ArrayList<String> brand = new ArrayList<>();
    ArrayList<String> model = new ArrayList<>();




    /* Return the stock number*/
    public static int checkItemStock(int product_id){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
        String user = "papers";
        String password = "papersarewhite";
        int num_Stock = 0;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT Num_Stock from MOBO WHERE Product_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, String.valueOf(product_id).toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                num_Stock = resultSet.getInt("Num_Stock");
                return  num_Stock;
            }


        }catch (Exception ex){

        }

        return 0;
    }

    /* Return the updated stock after buying. Will return nothing if QTY > Stock.
    * Also it updates automatically in DB */
    public static int minusItemStock(int product_id, int QTY){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
        String user = "papers";
        String password = "papersarewhite";
        int num_Stock = 0;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT Num_Stock from MOBO WHERE Product_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, String.valueOf(product_id).toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                num_Stock = resultSet.getInt("Num_Stock");

                if(QTY > num_Stock){
                    JOptionPane.showMessageDialog(null, "Stock is only " + num_Stock);
                }else {
                    String updateStockQuery = "UPDATE MOBO set Num_Stock=? where Product_ID=?";
                    PreparedStatement ps = connection.prepareStatement(updateStockQuery);
                    int updateStock = num_Stock - QTY;
                    ps.setInt(1, updateStock);
                    ps.setInt(2, product_id);

                    ps.execute();
                    ps.close();

                    return updateStock;

                }
            }
            preparedStatement.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return 0;
    }

    /* Return item price in db */
    public static int checkItemPrice(int product_id){
        String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
        String user = "papers";
        String password = "papersarewhite";
        int Price = 0;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String QUERY = "SELECT Price from MOBO WHERE Product_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, String.valueOf(product_id).toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Price = resultSet.getInt("Price");
                return  Price;
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return 0;
    }







    //sets the Button text (limited to 15 products only)
    public void setItemPanelName(){

        try{

            String url = "jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=computer_parts";
            String user = "papers";
            String password = "papersarewhite";

            Connection connection = DriverManager.getConnection(url,user, password);
            String QUERY = "SELECT Brand, Model from MOBO";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            brand = new ArrayList<>();
            model = new ArrayList<>();

            int i = 0;
            while(resultSet.next()){
                String Brand = resultSet.getString("Brand");
                String Model = resultSet.getString("Model");

                brand.add(Brand);
                model.add(Model);

            }

            resultSet.close();

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
            ex.printStackTrace();
        }
    }




}
