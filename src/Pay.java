import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay extends JFrame implements  ActionListener{
    private JPanel mainPanel = new JPanel();

    private JButton creditCard = new JButton("Credit Card");
    private JButton debitCard = new JButton("Debit Card");
    private JButton cash = new JButton("Cash");



    Pay(){
        mainPanel.setLayout(new GridLayout(1, 3));



        mainPanel.add(creditCard);
        mainPanel.add(debitCard);
        mainPanel.add(cash);


        creditCard.setFocusable(false);
        debitCard.setFocusable(false);
        cash.setFocusable(false);

        creditCard.addActionListener(this);
        debitCard.addActionListener(this);
        cash.addActionListener(this);




        this.add(mainPanel, BorderLayout.CENTER);


        this.setTitle("Payment Type");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Pay();
    }

    CreditCard cc;
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == creditCard){
            cc = new CreditCard();
            this.dispose();
        }
        if(e.getSource() == debitCard){
            this.dispose();
        }
        if(e.getSource() == cash){
            this.dispose();
        }
    }
}
