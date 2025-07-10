
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    
    
    JTextField amountTextField;
    JButton wdButton, backButton;
    String cardNum;
    
     public Withdraw(String cardNo)
    {
        
        cardNum=cardNo;
        
        setLayout(null);
        setSize(800,750);
        setLocation(280,00);
        setUndecorated(true); //removing the "full, mini, close" options
        setTitle("Withdrawl Page");
        
        getContentPane().setBackground(Color.white);   
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        
        JLabel textLabel= new JLabel("Enter the amount you want to withdraw:");
        textLabel.setFont(new Font("Raleway",Font.BOLD,15));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(150,225,300,22);
        image.add(textLabel);
        
        amountTextField= new JTextField();
        amountTextField.setBounds(155,255,290,25);
        amountTextField.setFont(new Font("Raleway", Font.BOLD,18));
        image.add(amountTextField);
        
        wdButton = new JButton("Withdraw");
        wdButton.setBounds(360,390,100,25);
        wdButton.addActionListener(this);
        image.add(wdButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(360,440,100,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
      String cardNo=cardNum;
      if(ae.getSource()==wdButton)
      {          
        String amount=amountTextField.getText();
        
        if(amount.equals("") || amount.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Enter an amount first.");
        }
       else
        {
            try{
                Conn cObj= new Conn();
                String query="select balance from account where Card_Num='"+cardNo+"'";               
                ResultSet rs=cObj.s.executeQuery(query);
                
                if(rs.next())
                {
                    long currentBalance=rs.getLong("balance");
                    long withdrawAmount=Long.parseLong(amount);
                    
                    if(currentBalance<withdrawAmount)
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                        return;
                    }
                }
              
                Date date= new Date();
                try{
                Conn cW= new Conn();
                
                String queryW= "insert into bank values ('"+cardNo+"','"+date+"','Withdrawn','"+amount+"')";
                String queryA = "UPDATE account SET balance = balance - " + Integer.parseInt(amount) + " WHERE Card_Num = '" + cardNo + "'";
                cW.s.executeUpdate(queryA);
             
                cW.s.executeUpdate(queryW);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" successfully withdrawn.");
                setVisible(false);
                new Transactions(cardNo).setVisible(true);
              
                }
            catch(Exception e)
            {
                System.out.println(e);
            }
         
      }catch(Exception e)
      {
          System.out.println(e);
      }
        }
        }
      else if(ae.getSource()==backButton)
      {
          setVisible(false);
          new Transactions(cardNo).setVisible(true);

      }
    }
      
    
     public static void main(String[] args)
    {
        new Withdraw("");
    }
}
