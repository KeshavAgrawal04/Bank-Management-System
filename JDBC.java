import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class JDBC {
    String url;
    String userName;
    String pass;
    Connection connection;

    PreparedStatement stmt;

    public void setConnection() throws Exception {
       url = "jdbc:mysql://localhost/bank_management";
       userName = "root";
       pass = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, userName, pass);
       System.out.println("Connected To Database...");
    }

    public void addData(Customer customer) {

        PreparedStatement add;
        try {
            setConnection();
            add = connection.prepareStatement("insert into data values(?, ?, ?, ?, ?, ?, ?)");
            accountNoValidation(customer);

            add.setLong(1, customer.getAccountNo());
            add.setString(2, customer.getAccountHolderName());
            add.setLong(3,customer.getAadhaarNo());
            add.setString(4, customer.getAccountType());
            add.setString(5, customer.getAddress());
            add.setLong(6,customer.getBalance());
            add.setLong(7,customer.getMobileNo());
            add.executeUpdate();
        } catch (Exception e) {
            System.out.println("An Error In Inserting Data...");
            e.printStackTrace();
        }
    }
    public void accountNoValidation(Customer c) {
        try {
            long no = 0;
            ResultSet rS = connection.createStatement().executeQuery("select * from data where Account_No = "+c.getAccountNo());
            if(rS.next()) {
//                System.out.println("Account Number Is Already Exists...");
                long min = 892300001001L;
                long max = 892300001050L;
                no = (long) (Math.random() * (max - min + 1) + min);
                c.setAccountNo(no);
                accountNoValidation(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An Error In Validation...");
        }
    }
//    public void clearTable() {
//        try {
//            stmt = connection.prepareStatement("delete from data where 1");
//            stmt.executeUpdate();
//            System.out.println("Table Data Deleted Successfully...");
//        } catch(Exception e) {
//            System.out.println("An Error In Deletion Of Data ...");
//        }
//    }
    long alBal;
    long alacNo = 0;
    String alname = "";
    boolean flag;
    public boolean accountalready(Long accountNum) {
        try {
            int c = 0;
            setConnection();
            Statement statement = connection.createStatement();
            ResultSet rS1 = statement.executeQuery("select * from data");
            AlreadyHaveAccount al = new AlreadyHaveAccount();

            while(rS1.next()) {
                if(rS1.getLong(1) == accountNum) {
                    alBal = rS1.getLong(6);
                    alacNo = rS1.getLong(1);
                    alname = rS1.getString(2);
                    flag = true;
                }
            }
        } catch (Exception e) {
            System.out.println("An Error In Account Already");
        }
        return flag;
    }
    public void withdrawAmount(long amount,long bal,long accountNum) {
        try {
            setConnection();
            PreparedStatement pS3 = connection.prepareStatement("update data set balance="+(bal - amount)+" where Account_No="+accountNum);
            pS3.executeUpdate();
            accountalready(accountNum);
        }catch(Exception e) {
            System.out.println("An Error In Debiting Amount");
        }
    }
    public void depositAmount(long amount,long bal,long accountNum) {
        try {
            setConnection();
            PreparedStatement pS3 = connection.prepareStatement("update data set balance=+"+(bal + amount)+" where Account_No="+accountNum);
            pS3.executeUpdate();
            accountalready(accountNum);
        }catch(Exception e) {
            System.out.println("An Error In Crediting Amount");
        }
    }
    String address;
    long balance;
    long mobileNumber;
    String accountType;
    long accountNumber;
    String name;
    long aadhaarNumber;
    public void retrieveData(Long accountNum) {
        try {
            setConnection();
            Statement statement = connection.createStatement();
            ResultSet rS1 = statement.executeQuery("select * from data");
            while(rS1.next()) {
                if(rS1.getLong(1) == accountNum) {
//                    System.out.println("||**************************************************||");
//                    System.out.println("|| Account Number      : "+rS1.getLong(1));
//                    System.out.println("|| Account Holder Name : "+rS1.getString(2));
//                    System.out.println("|| Aadhaar Number      : "+rS1.getLong(3));
//                    System.out.println("|| Account Type        : "+rS1.getString(4));
//                    System.out.println("|| Address             : "+rS1.getString(5));
//                    System.out.println("|| Balance             : "+rS1.getLong(6));
//                    System.out.println("|| Mobile Number       : "+rS1.getLong(7));
//                    System.out.println("||**************************************************||");
                    accountNumber = rS1.getLong(1);
                    name = rS1.getString(2);
                    aadhaarNumber = rS1.getLong(3);
                    accountType = rS1.getString(4);
                    address = rS1.getString(5);
                    balance = rS1.getLong(6);
                    mobileNumber = rS1.getLong(7);
                }
            }
        } catch (Exception e) {
            System.out.println("An Error In Validation...");
        }
    }


    public void deleteByAccountNo(String accountNum) {
        try {
            setConnection();
            long accountN = Long.parseLong(accountNum);
            stmt = connection.prepareStatement("delete from data where Account_No="+accountN);
            stmt.executeUpdate();
//            System.out.println("|| Account "+ accountNum + " Is Successfully Closed      ||");
        } catch(Exception e) {
            System.out.println("An Error In Deleting...");
        }
    }
}

