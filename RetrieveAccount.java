import javax.swing.*;
import java.awt.*;

public class RetrieveAccount {
    JFrame detailsFrame = new JFrame();
    JLabel label,nameL,aadhaarNoL,mobileNoL,accountTypeL,minBalL,addressL,accountNoL;
    JLabel name,aadhaarNo,mobileNo,accountType,minBal,address,accountNo;
    JButton submit;
    JDBC jdbc;
    public void retrieveAccount(long accountNum) {
        detailsFrame.setUndecorated(true);
        detailsFrame.setSize(500,500);
        detailsFrame.setLayout(null);
        detailsFrame.setLocationRelativeTo(null);

        try {
            jdbc = new JDBC();
            jdbc.retrieveData(accountNum);
        }catch(Exception e) {
            e.printStackTrace();
        }
        label = new JLabel("Account Details");
        label.setFont(new Font("MONOSPACED",Font.BOLD,24));
        label.setBounds(125,10,350,50);

        nameL = new JLabel("Full Name    :");
        nameL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        nameL.setBounds(50,80,200,40);
//        nameL.setText();

        aadhaarNoL = new JLabel("Aadhaar No   :");
        aadhaarNoL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        aadhaarNoL.setBounds(50,120,200,40);

        mobileNoL = new JLabel("Mobile No    :");
        mobileNoL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        mobileNoL.setBounds(50,160,200,40);

        accountTypeL = new JLabel("Account Type :");
        accountTypeL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountTypeL.setBounds(50,200,200,40);

        minBalL = new JLabel("Balance      :");
        minBalL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        minBalL.setBounds(50,240,200,40);

        addressL = new JLabel("Address      :");
        addressL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        addressL.setBounds(50,280,200,40);

        accountNoL = new JLabel("Account No   :");
        accountNoL.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountNoL.setBounds(50,320,200,40);

        name = new JLabel();
        name.setFont(new Font("MONOSPACED",Font.BOLD,22));
        name.setBounds(250,80,260,40);
        name.setText(jdbc.name);

        aadhaarNo = new JLabel();
        aadhaarNo.setFont(new Font("MONOSPACED",Font.BOLD,22));
        aadhaarNo.setBounds(250,120,260,40);
        aadhaarNo.setText(String.valueOf(jdbc.aadhaarNumber));

        mobileNo = new JLabel();
        mobileNo.setFont(new Font("MONOSPACED",Font.BOLD,22));
        mobileNo.setBounds(250,160,260,40);
        mobileNo.setText(String.valueOf(jdbc.mobileNumber));

        accountType = new JLabel();
        accountType.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountType.setBounds(250,200,260,40);
        accountType.setText(jdbc.accountType);

        minBal = new JLabel();
        minBal.setFont(new Font("MONOSPACED",Font.BOLD,22));
        minBal.setBounds(250,240,260,40);
        minBal.setText(String.valueOf(jdbc.balance));

        address = new JLabel();
        address.setFont(new Font("MONOSPACED",Font.BOLD,22));
        address.setBounds(250,280,260,40);
        address.setText(jdbc.address);

        accountNo = new JLabel();
        accountNo.setFont(new Font("MONOSPACED",Font.BOLD,22));
        accountNo.setBounds(250,320,260,40);
        accountNo.setText(String.valueOf(jdbc.accountNumber));

        submit = new JButton("Exit");
        submit.setFont(new Font("MONOSPACED",Font.BOLD,24));
        submit.setBounds(225,380,150,50);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(e -> {detailsFrame.dispose(); new GUI().createGui();});

        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        detailsFrame.add(submit);
        detailsFrame.add(nameL);detailsFrame.add(aadhaarNoL);detailsFrame.add(mobileNoL);detailsFrame.add(accountTypeL);detailsFrame.add(minBalL);detailsFrame.add(addressL);
        detailsFrame.add(name);detailsFrame.add(aadhaarNo);detailsFrame.add(mobileNo);detailsFrame.add(accountType);detailsFrame.add(minBal);detailsFrame.add(address);
        detailsFrame.add(label);detailsFrame.add(accountNoL);detailsFrame.add(accountNo);
        detailsFrame.setResizable(false);
        detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailsFrame.setVisible(true);
//        try {
//            File file = new File("AccountDetails/"+jdbc.accountNumber + ".txt");
//            file.createNewFile();
//            FileOutputStream fOS = new FileOutputStream(file);
//            PrintStream pS = new PrintStream(fOS);
//            pS.print("||-----------------------------------||\n");
//            pS.append("|| Account Holder Name : "+jdbc.name + "\n");
//            pS.append("|| Account Number      : "+jdbc.accountNumber + "\n");
//            pS.append("|| Aadhaar Number      : "+jdbc.aadhaarNumber + "\n");
//            pS.append("|| Mobile Number       : "+jdbc.mobileNumber+ "\n");
//            pS.append("|| Account Type        : "+jdbc.accountType +"\n");
//            pS.append("|| Address             : "+jdbc.address + "\n");
//            pS.append("|| Opening Balance     : "+jdbc.balance + "\n");
//            pS.print("||-----------------------------------||\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
