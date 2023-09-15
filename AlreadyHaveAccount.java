import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlreadyHaveAccount {
    JDBC jdbc = new JDBC();
    boolean f;
    BufferedWriter bW;
    JFrame accountFrame = new JFrame();
    JLabel label,depositL,withdrawL,balanceL,dResponseL,wResponseL,accountNoL,copyrightLabel,nameLabel;
    JTextField depositF,withdrawF,balanceF,accountNoF,nameF;
    JButton depositB,withdrawB,balanceB,exitB,accountNoB;
    long amountD,amountW;
    String time = "";
    String day = "";
    long acN;
    public void alreadyAccount() {

        accountFrame.setUndecorated(true);
        accountFrame.setSize(600,600);
        accountFrame.setLayout(null);
        accountFrame.setLocationRelativeTo(null);

        ImageIcon backgroundImg = new ImageIcon("images/Background.jpg");
        Image backgroundImage = backgroundImg.getImage();
        accountFrame.setContentPane(new JPanel(){
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
        accountFrame.add(iconimg);accountFrame.add(slogan);

        label = new JLabel("Customer Services");
        label.setFont(new Font("MONOSPACED",Font.BOLD,24));
        label.setBounds(180,30,350,50);
        label.setForeground(Color.white);

        accountNoL = new JLabel("Account No :");
        accountNoL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        accountNoL.setBounds(10,80,150,40);
        accountNoL.setForeground(Color.white);

        accountNoF = new JTextField();
        accountNoF.setFont(new Font("MONOSPACED",Font.BOLD,20));
        accountNoF.setBounds(160,80,280,40);

        accountNoB = new JButton("Enter");
        accountNoB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        accountNoB.setBounds(450,80,130,40);

        nameLabel = new JLabel("Account Holder Name    :");
        nameLabel.setFont(new Font("MONOSPACED",Font.BOLD,20));
        nameLabel.setBounds(10,130,300,40);
        nameLabel.setForeground(Color.white);

        nameF = new JTextField();
        nameF.setFont(new Font("MONOSPACED",Font.BOLD,22));
        nameF.setBounds(320,130,260,40);
        nameF.setEditable(false);

        depositL = new JLabel("Enter Amount To Deposit :");
        depositL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        depositL.setBounds(10,190,300,40);
        depositL.setForeground(Color.white);

        dResponseL = new JLabel();
        dResponseL.setHorizontalTextPosition(SwingConstants.CENTER);
        dResponseL.setHorizontalAlignment(SwingConstants.CENTER);
        dResponseL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        dResponseL.setBounds(50,250,500,40);
        dResponseL.setForeground(Color.white);

        depositF = new JTextField();
        depositF.setFont(new Font("MONOSPACED",Font.BOLD,22));
        depositF.setBounds(320,190,120,40);
        depositF.setEnabled(false);

        depositB = new JButton("Deposit");
        depositB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        depositB.setBounds(450,190,130,40);
        depositB.setEnabled(false);
        depositB.addActionListener(e -> {
            amountD = Long.parseLong(depositF.getText());
            accountFrame.setEnabled(false);
            jdbc.depositAmount(amountD,jdbc.alBal,jdbc.alacNo);
            dResponseL.setText("Rs. "+amountD+" Is Deposited In Your Account.");
            accountFrame.setEnabled(true);
            dateAndTime();
//            try {
//                writeData();
//                bW.write("|| Rs. "+amountD+" Is Deposited In Your Account On "+day+" At "+time+"\n");
//                bW.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
            balanceB.doClick();
        });

        withdrawL = new JLabel("Enter Amount To Withdraw:");
        withdrawL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        withdrawL.setBounds(10,320,300,40);
        withdrawL.setForeground(Color.white);

        wResponseL = new JLabel();
        wResponseL.setHorizontalTextPosition(SwingConstants.CENTER);
        wResponseL.setHorizontalAlignment(SwingConstants.CENTER);
        wResponseL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        wResponseL.setBounds(50,380,500,40);
        wResponseL.setForeground(Color.white);

        withdrawF = new JTextField();
        withdrawF.setFont(new Font("MONOSPACED",Font.BOLD,22));
        withdrawF.setBounds(320,320,120,40);
        withdrawF.setEnabled(false);

        withdrawB = new JButton("Withdraw");
        withdrawB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        withdrawB.setBounds(450,320,130,40);
        withdrawB.setEnabled(false);
        withdrawB.addActionListener(e -> {
            amountW = Long.parseLong(withdrawF.getText());
            if((jdbc.alBal - amountW) < 500) {
                JOptionPane.showMessageDialog(accountFrame,"You Cannot Withdraw Rs."+amountW+" Because Rs.500 Is Compulsory As Opening Balance.You Can Withdraw "+(jdbc.alBal - 500));
            } else {
                accountFrame.setEnabled(false);
                jdbc.withdrawAmount(amountW, jdbc.alBal, jdbc.alacNo);
                wResponseL.setText("Rs. " + amountW + " Is Withdrawal From Your Account.");
                accountFrame.setEnabled(true);
                dateAndTime();
//                try {
//                    writeData();
//                    bW.write("|| Rs. " + amountW + " Is Withdrawal From Your Account "+day+" At "+time+"\n");
//                    bW.close();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
                balanceB.doClick();
            }
        });

        balanceL = new JLabel("Your Account Balance Is :");
        balanceL.setFont(new Font("MONOSPACED",Font.BOLD,20));
        balanceL.setBounds(10,450,300,40);
        balanceL.setForeground(Color.white);

        balanceF = new JTextField();
        balanceF.setFont(new Font("MONOSPACED",Font.BOLD,22));
        balanceF.setBounds(320,450,120,40);
        balanceF.setEnabled(false);

        balanceB = new JButton("Balance");
        balanceB.setFont(new Font("MONOSPACED",Font.BOLD,20));
        balanceB.setBounds(450,450,130,40);
        balanceB.setEnabled(false);
        balanceB.addActionListener(e -> {
            balanceF.setText(String.valueOf(jdbc.alBal));
        });

        accountNoB.addActionListener(e -> {
            int cou = 0;
            acN = 0;

            try{
                if(accountNoF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(accountFrame,"Account Number Is Required.");
                } else {
                    if(accountNoF.getText().length() != 12) {
                        JOptionPane.showMessageDialog(accountFrame,"Account Number Must Be 12 Digits.");
                    } else {
                        try {
                            acN = Long.parseLong(accountNoF.getText());
                            cou++;
                        }catch(Exception exception) {
                            JOptionPane.showMessageDialog(accountFrame,"Numbers Only Valid For Account Number.");
                        }
                        accountFrame.setEnabled(false);
                        f = jdbc.accountalready(acN);
                        accountFrame.setEnabled(true);
                        if(!f) {
                            JOptionPane.showMessageDialog(accountFrame,"Account Not Found");
                        }
                    }
                }
                if(cou == 1 && f) {
                    nameF.setText(jdbc.alname);
                    depositF.setEnabled(true);depositB.setEnabled(true);
                    withdrawF.setEnabled(true);withdrawB.setEnabled(true);
                    balanceB.setEnabled(true);
                    accountNoF.setEditable(false);
                    accountNoB.setEnabled(false);
                }
            } catch(Exception excep) {
                System.out.println("An Error...");
            }
        });

        exitB = new JButton("Exit");
        exitB.setFont(new Font("MONOSPACED",Font.BOLD,22));
        exitB.setBounds(225,510,150,40);
        exitB.addActionListener(e -> {
            accountFrame.dispose();
            new GUI().createGui();
        });
        copyrightLabel = new JLabel("All Rights Are Reserved By Keshav Agrawal.CopyRight @2023");
        copyrightLabel.setFont(new Font("MONOSPACED",Font.BOLD,15));
        copyrightLabel.setBounds(30,550,600,40);
        exitB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        balanceB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        accountNoB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        copyrightLabel.setForeground(Color.white);

        accountFrame.add(copyrightLabel);
        accountFrame.add(label);accountFrame.add(depositL);accountFrame.add(depositF);accountFrame.add(depositB);
        accountFrame.add(withdrawL);accountFrame.add(withdrawF);accountFrame.add(withdrawB);
        accountFrame.add(balanceL);accountFrame.add(balanceF);accountFrame.add(balanceB);
        accountFrame.add(accountNoL);accountFrame.add(accountNoF);accountFrame.add(accountNoB);
        accountFrame.add(dResponseL);accountFrame.add(wResponseL);
        accountFrame.add(nameF);accountFrame.add(nameLabel);
        accountFrame.add(exitB);

        accountFrame.setResizable(false);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setVisible(true);

    }
    public void dateAndTime() {
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        timeFormat = new SimpleDateFormat("hh:mm a");
        dayFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            time = timeFormat.format(Calendar.getInstance().getTime());
            day = dayFormat.format(Calendar.getInstance().getTime());
        }catch(Exception e) {
            System.out.println(e);
        }
    }
//    public void writeData() {
//        try {
//            File f1 = new File("Transaction_"+acN+".txt");
//            if(!f1.exists()) {
//                f1.createNewFile();
//            }
//            FileWriter fileWritter = new FileWriter(f1.getName(),true);
//            bW = new BufferedWriter(fileWritter);
//
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
