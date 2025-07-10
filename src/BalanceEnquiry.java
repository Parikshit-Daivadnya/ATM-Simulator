
package bank.management.system;

//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String cardNum;
    JButton backButton;
    
    public BalanceEnquiry(String pinNo)
    {
        cardNum=pinNo;
        int balance=0;
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
        
         try
            {
                Conne c= new Conne();
                String query="select * from bank where PIN='"+pinNum+"'";
                
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next())  //loops on rs result-set
                {
                    if(rs.getString("Type").equals("Deposited"))
                    {
                        balance+=Integer.parseInt(rs.getString("Amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("Amount"));
                    }
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }

        
        JLabel textLabel= new JLabel("Your Current Account Balance is Rs. "+balance);
        textLabel.setFont(new Font("Raleway",Font.BOLD,13));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(115,225,320,22);
        image.add(textLabel);
        
        backButton = new JButton("Back");
        backButton.setBounds(380,445,80,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==backButton)
        {
            new Transactions(pinNum).setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new BalanceEnquiry("");
    }
}
