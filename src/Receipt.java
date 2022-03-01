import javax.swing.*;
import java.awt.*;

public class Receipt extends JFrame {
    JTextArea receiptDescription = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(receiptDescription);


    Receipt(){
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        receiptDescription.setFont(new Font("monospaced", Font.PLAIN, 12));

        String text = MainGUI.receiptDescription.getText();
        receiptDescription.setText(text);
        receiptDescription.setLineWrap(true);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setTitle("You Receipt Baby");
        this.setResizable(false);
        this.setSize(600, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Receipt();
    }
}
