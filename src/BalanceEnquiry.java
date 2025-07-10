
package bank.management.system;

//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String cardNum;
    JButton backButton;
    
    public BalanceEnquiry(String cardNo)
    {
        
        
        setLayout(null);
        setSize(800,750);
        setLocation(280,00);
        setUndecorated(true);
        setTitle("Balance Enquiry Page");
        getContentPane().setBackground(Color.white); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        
           JLabel titleLabel = new JLabel("Your Current Balance is:");
        titleLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(160, 225, 300, 30);
        image.add(titleLabel);

        int balance = 0;

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM bank WHERE Card_Num = '" + cardNo + "'";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("Type");
                int amount = Integer.parseInt(rs.getString("Amount"));

                if (type.equalsIgnoreCase("Deposited")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawn")) {
                    balance -= amount;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel balanceLabel = new JLabel("Rs. " + balance);
        balanceLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        balanceLabel.setForeground(Color.white);
        balanceLabel.setBounds(200, 260, 250, 30);
        image.add(balanceLabel);
        
        backButton = new JButton("Back");
        backButton.setBounds(380,445,80,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        cardNum=cardNo;
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String cardNo=cardNum;
        if(ae.getSource()==backButton)
        {
            new Transactions(cardNo).setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new BalanceEnquiry("");
    }
}
