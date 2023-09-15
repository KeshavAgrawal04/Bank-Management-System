import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame();
    JLabel label;
    JButton createAccount,alreadyHaveAccount,accountClosing,exit;
    public void createGui() {
        frame.setUndecorated(true);
        frame.setSize(600,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        ImageIcon backgroundImg = new ImageIcon("images/Background.jpg");
        Image backgroundImage = backgroundImg.getImage();
        frame.setContentPane(new JPanel(){
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

        ImageIcon icon = new ImageIcon("images/banking-system.png");
        Image img = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        JLabel iconimg = new JLabel(image);
        iconimg.setBounds(10,10,50,50);
        JLabel slogan = new JLabel("Digital Banking Services");
        slogan.setForeground(Color.GREEN);
        slogan.setBounds(60,5,500,50);
        slogan.setHorizontalAlignment(SwingConstants.CENTER);
        slogan.setFont(new Font("Monospaced",Font.BOLD,30));
        frame.add(iconimg);frame.add(slogan);

        label = new JLabel("Welcome To Banking Service");
        label.setFont(new Font("MONOSPACED",Font.BOLD,24));
        label.setBounds(110,60,400,50);
        label.setForeground(Color.white);

        createAccount = new JButton("New Account Opening");
        createAccount.setFont(new Font("MONOSPACED",Font.BOLD,20));
        createAccount.setBounds(100,120,400,50);
        createAccount.addActionListener(e -> { frame.dispose(); new AccountCreate().createAccount();});

        alreadyHaveAccount = new JButton("Already Have A Account");
        alreadyHaveAccount.setFont(new Font("MONOSPACED",Font.BOLD,20));
        alreadyHaveAccount.setBounds(100,180,400,50);
        alreadyHaveAccount.addActionListener(e -> { frame.dispose(); new AlreadyHaveAccount().alreadyAccount();});

        accountClosing = new JButton("Account Closing");
        accountClosing.setFont(new Font("MONOSPACED",Font.BOLD,20));
        accountClosing.setBounds(100,240,400,50);
        accountClosing.addActionListener(e -> { frame.dispose(); new AccountClosing().closeAccount();});

        exit = new JButton("Exit");
        exit.setFont(new Font("MONOSPACED",Font.BOLD,20));
        exit.setBounds(100,300,400,50);
        exit.addActionListener(e -> {JOptionPane.showMessageDialog(frame,"Thanks For Using Banking System.I Hope You Will Use This System Again.");System.exit(0);});

        createAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        alreadyHaveAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        accountClosing.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel copyrightLabel;
        copyrightLabel = new JLabel("All Rights Are Reserved By Keshav Agrawal.CopyRight @2023");
        copyrightLabel.setFont(new Font("MONOSPACED",Font.BOLD,15));
        copyrightLabel.setBounds(30,450,600,40);
        copyrightLabel.setForeground(Color.white);

        frame.add(copyrightLabel);
        frame.add(createAccount);
        frame.add(exit);
        frame.add(accountClosing);
        frame.add(alreadyHaveAccount);
        frame.add(label);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
