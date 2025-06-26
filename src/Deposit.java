
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener{
    
String pinNum;
JButton depoButton, backButton;
JTextField amountTextField;
    
    public Deposit(String pinNo)
    {
        pinNum=pinNo;
        
        setLayout(null);
        setSize(800,750);
        setLocation(280,00);
        setUndecorated(true); //removing the "full, mini, close" options
        setTitle("Deposit Page");
        
        getContentPane().setBackground(Color.white);   
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        
        JLabel textLabel= new JLabel("Enter the amount you want to deposit: ");
        textLabel.setFont(new Font("Raleway",Font.BOLD,15));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(155,225,290,22);
        image.add(textLabel);
        
        amountTextField= new JTextField();
        amountTextField.setBounds(155,255,290,25);
        amountTextField.setFont(new Font("Raleway", Font.BOLD,18));
        image.add(amountTextField);
        
        depoButton = new JButton("Deposit");
        depoButton.setBounds(360,390,80,25);
        depoButton.addActionListener(this);
        image.add(depoButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(360,440,80,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
      if(ae.getSource()==depoButton)
      {          
        String amount=amountTextField.getText();
        if(amount.equals("") || amount.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Enter an amount first.");
        }
        else{
            Date date = new Date();
            try{
                Conne cD= new Conne();
                String queryD="insert into bank values('"+pinNum+"','"+date+"','Deposited','"+amount+"')";
                cD.s.executeUpdate(queryD);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" deposited successfully.");
                new Transactions(pinNum).setVisible(true);
                setVisible(false);
                }
            catch(Exception e)
            {
                System.out.println(e);
            }
            }
      }
      
      else if(ae.getSource()==backButton)
      {
          new Transactions(pinNum).setVisible(true);
          setVisible(false);
      }
    }
    public static void main(String[] args)
    {
        new Deposit("");
    }
    
}
