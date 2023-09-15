import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MiniStatement {
    JFrame miniStatementFrame;
    JLabel label,bankName,cardNoL;
    JTextArea textArea;
    JPanel panel;

    public MiniStatement(Long cardNo,int pin,JDBC jdbc) {
        miniStatementFrame = new JFrame();
        miniStatementFrame.setSize(600,600);
        miniStatementFrame.setLayout(null);
        miniStatementFrame.setLocation(20,20);
//        miniStatementFrame.setUndecorated(true);

        label = new JLabel("Mini Statement");
        label.setFont(new Font("Monospaced",Font.BOLD,25));
        label.setBounds(0,10,600,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        bankName = new JLabel("Bank Of India");
        bankName.setFont(new Font("Monospaced",Font.BOLD,22));
        bankName.setBounds(0,40,600,50);
        bankName.setHorizontalAlignment(SwingConstants.CENTER);

        String cN = cardNo.toString();
        cardNoL = new JLabel("Card Number : " + cN.substring(0,4) + "-XXXX-XXXX-" + cN.substring(12));
        cardNoL.setBounds(10,120,600,40);
        cardNoL.setFont(new Font("Monospaced",Font.BOLD,20));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(600,400);
        panel.setBounds(0,180,600,400);
        panel.setVisible(true);

        miniStatementFrame.add(panel);
        // jdbc.setConnection();
        // String data = jdbc.transactions(cardNo,pin);

        // JTextArea jt = new JTextArea(data,15,48);
        // jt.setEditable(false);
        // jt.setLineWrap(true);
        // jt.setFont(new Font("Monospaced",Font.BOLD,18));
        // JScrollPane js = new JScrollPane(jt,
        //         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        //         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // panel.add(js);

        miniStatementFrame.add(cardNoL);
        miniStatementFrame.add(label);miniStatementFrame.add(bankName);
        miniStatementFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement(1521245789562345L,1256,new JDBC());
    }
}
