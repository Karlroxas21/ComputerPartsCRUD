import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receipt extends JFrame implements  ActionListener{
    JTextArea receiptDescription = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(receiptDescription);
    JButton exit = new JButton("Exit");

    static String paymentType = "";


    Receipt(){
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        receiptDescription.setFont(new Font("monospaced", Font.PLAIN, 12));

        String text = MainGUI.receiptDescription.getText();
        receiptDescription.setText(text);
        if(paymentType.equals("Credit Card") || paymentType.equals("Debit Card")) {
            receiptDescription.append(String.format("%136s", "CHANGE: 0"));
        }
        receiptDescription.append(String.format("%96s", "Payment Type: " + paymentType));

        receiptDescription.setLineWrap(true);
        receiptDescription.setEditable(false);
        this.add(exit, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setTitle("You Receipt Baby");
        this.setResizable(false);
        this.setSize(600, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        exit.addActionListener(this);



    }

    public static void main(String[] args) {
        new Receipt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            this.dispose();
        }
    }
}
