import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private Panel receiptPanel  = new Panel();
    private Panel itemPanel = new Panel();
    private Panel categoryPanel = new Panel();
    private Panel qtyPanel = new Panel();

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


    MainGUI(){

        receiptPanel.setBackground(new Color(0x626060));
        receiptPanel.setBounds(10, 10, 600, 700);

        itemPanel.setBackground(new Color(0x626060));
        itemPanel.setBounds(815, 60, 655, 650);

        categoryPanel.setBackground(new Color(0x626060));
        categoryPanel.setBounds(615, 10, 195, 700);


        qtyPanel.setBackground(new Color(0x626060));
        qtyPanel.setBounds(815, 10, 655, 45);

        titleCategory.setBounds(0,0,100, 100);
        titleCategory.setForeground(new Color(0xFFFFFF));


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

        Box box = Box.createVerticalBox();
        box.set

        box.add(mouseCategoryBtn);
        box.add(kbCategoryBtn);
        box.add(headsetCategoryBtn);
        box.add(cpuCategoryBtn);
        box.add(gpuCategoryBtn);
        box.add(moboCategoryBtn);
        box.add(ssdCategoryBtn);
        box.add(hddCategoryBtn);
        box.add(ramCategoryBtn);
        box.add(caseCategoryBtn);

        mouseCategoryBtn.setBounds(20,50, 250, 30);
        this.add(receiptPanel);
        this.add(itemPanel);
        this.add(categoryPanel);
        this.add(qtyPanel);

        categoryPanel.add(titleCategory);
        categoryPanel.add(box);

        this.setTitle("Karl Marx Roxas");
        this.getContentPane().setBackground(new Color(0x142d3a));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1500, 760);
        this.setLayout(null);
        this.setVisible(true);
        
        this.validate();
    }

    public static void main(String[] args) {
        new MainGUI();
    }




}

// TODO: Category, Add Items, QTY Panel, Inventory Tab, Update Tab, Orders Tab(UNCLEAR), Add Tab, Delete Tab