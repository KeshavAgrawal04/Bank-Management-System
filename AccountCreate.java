import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

public class AccountCreate {
    JFrame openingFrame = new JFrame();
    JLabel label,nameL,aadhaarNoL,mobileNoL,accountTypeL,minBalL,addressL;
    JTextField name,aadhaarNo,mobileNo,accountType,minBal,address;
    JButton submit,exit;
    JComboBox<String> dropDown;

    public void createAccount() {
        Customer c = new Customer();
        openingFrame.setUndecorated(true);
        openingFrame.setSize(600,500);
        openingFrame.setLocationRelativeTo(null);
        openingFrame.setLayout(null);

        ImageIcon backgroundImg = new ImageIcon("images/Background.jpg");
        Image backgroundImage = backgroundImg.getImage();
        openingFrame.setContentPane(new JPanel(){
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
        openingFrame.add(iconimg);openingFrame.add(slogan);

        Pattern p = Pattern.compile("[6-9][0-9]{9}");
        label = new JLabel("Fill The Given Fields");
        label.setFont(new Font("MONOSPACED",Font.BOLD,24));
        label.setBounds(125,35,350,50);
        label.setForeground(Color.white);

        nameL = new JLabel("Full Name    :");
        nameL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        nameL.setBounds(50,80,200,40);
        nameL.setForeground(Color.white);

        aadhaarNoL = new JLabel("Aadhaar No   :");
        aadhaarNoL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        aadhaarNoL.setBounds(50,120,200,40);
        aadhaarNoL.setForeground(Color.white);

        mobileNoL = new JLabel("Mobile No    :");
        mobileNoL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        mobileNoL.setBounds(50,160,200,40);
        mobileNoL.setForeground(Color.white);

        accountTypeL = new JLabel("Account Type :");
        accountTypeL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountTypeL.setBounds(50,200,200,40);
        accountTypeL.setForeground(Color.white);

        minBalL = new JLabel("Minimum Bal  :");
        minBalL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        minBalL.setBounds(50,240,200,40);
        minBalL.setForeground(Color.white);

        addressL = new JLabel("Address      :");
        addressL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        addressL.setBounds(50,280,200,40);
        addressL.setForeground(Color.white);

        name = new JTextField();
        name.setFont(new Font("MONOSPACED",Font.BOLD,22));
        name.setBounds(250,80,260,40);

        aadhaarNo = new JTextField();
        aadhaarNo.setFont(new Font("MONOSPACED",Font.BOLD,22));
        aadhaarNo.setBounds(250,120,260,40);

        mobileNo = new JTextField();
        mobileNo.setFont(new Font("MONOSPACED",Font.BOLD,22));
        mobileNo.setBounds(250,160,260,40);

        String accountTypes[] = {"Select","Savings","Current","Loan"};
        dropDown = new JComboBox<>(accountTypes);
        dropDown.setBounds(250,200,260,40);
        dropDown.setFont(new Font("MONOSPACED",Font.BOLD,22));

        minBal = new JTextField();
        minBal.setFont(new Font("MONOSPACED",Font.BOLD,22));
        minBal.setBounds(250,240,260,40);

        address = new JTextField();
        address.setFont(new Font("MONOSPACED",Font.BOLD,22));
        address.setBounds(250,280,260,40);

        submit = new JButton("Submit");
        submit.setFont(new Font("MONOSPACED",Font.BOLD,24));
        submit.setBounds(225,350,150,50);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        exit = new JButton("Exit");
        exit.setFont(new Font("MONOSPACED",Font.BOLD,24));
        exit.setBounds(225,410,150,50);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addActionListener(e -> {
            openingFrame.dispose();
            new GUI().createGui();
        });
        Icon icon = new ImageIcon("images/loading.gif");
        JLabel loader = new JLabel(icon);
        loader.setBounds(200,150,200,200);
        loader.setVisible(false);
        openingFrame.add(loader);

        submit.addActionListener(e -> {
            int cou = 0;
            long aN = 0;
            long mN = 0;
            long bal = 0;
                cou = 0;
                if (name.getText().isEmpty() && aadhaarNo.getText().isEmpty() && mobileNo.getText().isEmpty() && minBal.getText().isEmpty() && address.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(openingFrame, "All Fields Are Required To Fill.");
                } else {
                    if (aadhaarNo.getText().length() != 12) {
                        JOptionPane.showMessageDialog(openingFrame, "Aadhaar Number Must Be 12 Digits.");
                    } else { cou++; }
                    if (dropDown.getItemAt(dropDown.getSelectedIndex()).equals("Select")) {
                        JOptionPane.showMessageDialog(openingFrame, "Please Select Account Type.");
                    } else { cou++; }
                    Matcher m = p.matcher(mobileNo.getText());
                    boolean res = m.find();
                    if (!res) {
                        JOptionPane.showMessageDialog(openingFrame, "Mobile Number Must Be 10 Digits.");
                    } else {
                        cou++;
                        try {
                            aN = Long.parseLong(aadhaarNo.getText());
                            mN = Long.parseLong(mobileNo.getText());
                            bal = Long.parseLong(minBal.getText());
                            if(bal < 500) {
                                JOptionPane.showMessageDialog(openingFrame, "Rs. 500 Is Opening Balance Its Required To Deposit.");
                            } else { cou++; }
                            cou++;
                        } catch (Exception exce) {
                            JOptionPane.showMessageDialog(openingFrame, "Invalid Only Numbers Are Valid.");
                        }
                    }

                }
                c.setAadhaarNo(aN);
                c.setMobileNo(mN);
                c.setBalance(bal);
                c.setAccountHolderName(name.getText());
                c.setAccountType(dropDown.getItemAt(dropDown.getSelectedIndex()));
                c.setAddress(address.getText());
                long min = 892300001001L;
                long max = 892300001050L;
                long no = (long) (Math.random() * (max - min + 1) + min);
                c.setAccountNo(no);
                if(cou == 5) {
                    try {
                        JDBC jdbc = new JDBC();
                        jdbc.setConnection();
                        jdbc.addData(c);
                        JOptionPane.showMessageDialog(openingFrame, "Your Account Is Created");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    RetrieveAccount retrieveAccount = new RetrieveAccount();
                    retrieveAccount.retrieveAccount(c.getAccountNo());
                    openingFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(openingFrame,"Check All Details Given By You Is Correct");
                }
        });
        JLabel copyrightLabel;
        copyrightLabel = new JLabel("All Rights Are Reserved By Keshav Agrawal.CopyRight @2023");
        copyrightLabel.setFont(new Font("MONOSPACED",Font.BOLD,15));
        copyrightLabel.setBounds(30,450,600,40);
        copyrightLabel.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        openingFrame.add(copyrightLabel);
        openingFrame.add(submit);openingFrame.add(exit);
        openingFrame.add(nameL);openingFrame.add(aadhaarNoL);openingFrame.add(mobileNoL);openingFrame.add(accountTypeL);openingFrame.add(minBalL);openingFrame.add(addressL);
        openingFrame.add(name);openingFrame.add(aadhaarNo);openingFrame.add(mobileNo);openingFrame.add(dropDown);openingFrame.add(minBal);openingFrame.add(address);
        openingFrame.add(label);
        openingFrame.setResizable(false);
        openingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openingFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AccountCreate().createAccount();
    }
}
