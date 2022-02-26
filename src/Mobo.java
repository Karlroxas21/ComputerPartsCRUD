import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mobo extends JFrame {
    private int Product_ID, Price, Num_Stock, Cash_Price;
    private String Brand, Model, CPU_Socket, Memory_type, Form_Factor;

    public int getProduct_ID() {
        return Product_ID;
    }

    public int getPrice() {
        return Price;
    }

    public int getNum_Stock() {
        return Num_Stock;
    }

    public int getCash_Price() {
        return Cash_Price;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getCPU_Socket() {
        return CPU_Socket;
    }

    public String getMemory_type() {
        return Memory_type;
    }

    public String getForm_Factor() {
        return Form_Factor;
    }

    Mobo(int Product_ID, String Brand, String Model,
         int Price,int Num_Stock ,int Cash_Price ,
         String CPU_Socket, String Memory_type, String Form_Factor){
        this.Product_ID = Product_ID;
        this.Price = Price;
        this.Num_Stock = Num_Stock;
        this.Cash_Price = Cash_Price;
        this.Brand = Brand;
        this.Model = Model;
        this.CPU_Socket = CPU_Socket;
        this.Memory_type = Memory_type;
        this.Form_Factor = Form_Factor;
    }

    private JTable table;




}
