import javax.swing.*;
import java.awt.*;

public class AccountClosing {
    JFrame closingFrame = new JFrame();
    JLabel label,accountNumL,copyrightLabel;
    JTextField accountNum;
    JButton submit,exit;
    String accountNumber = "";
    public void closeAccount() {
        closingFrame.setUndecorated(true);
        closingFrame.setSize(600,500);
        closingFrame.setLayout(null);
        closingFrame.setLocationRelativeTo(null);

        ImageIcon backgroundImg = new ImageIcon("images/Background.jpg");
        Image backgroundImage = backgroundImg.getImage();
        closingFrame.setContentPane(new JPanel(){
            @Override
            public void setLayout(LayoutManager mgr) {
                super.setLayout(null);
            }

            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        });

        ImageIcon iconi = new ImageIcon("images/banking-system.png");
        Image img = iconi.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        JLabel iconimg = new JLabel(image);
        iconimg.setBounds(10,10,50,50);
        JLabel slogan = new JLabel("Digital Banking Services");
        slogan.setForeground(Color.GREEN);
        slogan.setBounds(60,5,500,50);
        slogan.setHorizontalAlignment(SwingConstants.CENTER);
        slogan.setFont(new Font("Monospaced",Font.BOLD,30));
        closingFrame.add(iconimg);closingFrame.add(slogan);

        label = new JLabel("Enter Details");
        label.setFont(new Font("MONOSPACED",Font.BOLD,24));
        label.setBounds(200,40,200,50);
        label.setForeground(Color.white);

        accountNumL = new JLabel("Account No   :");
        accountNumL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountNumL.setBounds(50,110,200,40);
        accountNumL.setForeground(Color.white);

        accountNum = new JTextField();
        accountNum.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountNum.setBounds(250,110,260,40);

        submit = new JButton("Submit");
        submit.setFont(new Font("MONOSPACED",Font.BOLD,24));
        submit.setBounds(225,350,150,50);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(e -> {
            accountNumber = accountNum.getText();
            try{
                JDBC jdbc = new JDBC();
                jdbc.deleteByAccountNo(accountNumber);
                JOptionPane.showMessageDialog(closingFrame,"Account "+accountNumber+" Is Closed.");
                closingFrame.dispose();
                new GUI().createGui();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        });
        exit = new JButton("Exit");
        exit.setFont(new Font("MONOSPACED",Font.BOLD,24));
        exit.setBounds(225,410,150,50);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addActionListener(e -> {closingFrame.dispose(); new GUI().createGui();});

        copyrightLabel = new JLabel("All Rights Are Reserved By Keshav Agrawal.CopyRight @2023");
        copyrightLabel.setFont(new Font("MONOSPACED",Font.BOLD,15));
        copyrightLabel.setBounds(30,450,600,40);
        copyrightLabel.setForeground(Color.white);
        closingFrame.add(copyrightLabel);
        closingFrame.add(submit);closingFrame.add(exit);
        closingFrame.add(accountNumL);
        closingFrame.add(accountNum);
        closingFrame.add(label);
        closingFrame.setResizable(false);
        closingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        closingFrame.setVisible(true);
    }
}
