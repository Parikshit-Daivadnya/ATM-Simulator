
package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton depButton, fCashButton, wdButton, mStateButton, pinChButton, exitButton,balEButton;
    String pinNum;
    
    public Transactions(String pinNo)
    {
        pinNum=pinNo;
        setLayout(null);
        setSize(800,750);
        setLocation(280,00);
        setUndecorated(true); //removing the "full, mini, close" options
        setTitle("Transactions Page");
        
        getContentPane().setBackground(Color.white);   
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        
        JLabel textLabel= new JLabel("Please select your Transaction: ");
        textLabel.setFont(new Font("Raleway",Font.BOLD,18));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(155,225,290,22);
        image.add(textLabel);
        
        depButton = new JButton("Cash Deposit");
        depButton.setBounds(135,280,140,25);
        depButton.addActionListener(this);
        image.add(depButton);
        
        wdButton = new JButton("Cash Withdraw");
        wdButton.setBounds(300,280,140,25);
        wdButton.addActionListener(this);
        image.add(wdButton);
        
        fCashButton = new JButton("Fast Cash");
        fCashButton.setBounds(135,325,140,25);
        fCashButton.addActionListener(this);
        image.add(fCashButton);
        
        mStateButton = new JButton("Mini Statement");
        mStateButton.setBounds(300,325,140,25);
        mStateButton.addActionListener(this);
        image.add(mStateButton);
        
        pinChButton = new JButton("Pin Change");
        pinChButton.setBounds(135,370,140,25);
        pinChButton.addActionListener(this);
        image.add(pinChButton);
        
        balEButton = new JButton("Balance Enquiry");
        balEButton.setBounds(300,370,140,25);
        balEButton.addActionListener(this);
        image.add(balEButton);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(250,425,80,25);
        exitButton.addActionListener(this);
        image.add(exitButton);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String pinNo=pinNum;
        
        if(ae.getSource()==exitButton)
        {
            System.exit(0);
        }
        
        else if(ae.getSource()==depButton)
        {
          
            new Deposit(pinNo).setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==wdButton)
        {
          
            new Withdraw(pinNo).setVisible(true);
            setVisible(false);
           
        }
         else if(ae.getSource()==fCashButton)
        {
          
            new FastCash(pinNo).setVisible(true);
            setVisible(false);
           
        }
        
          else if(ae.getSource()==balEButton)
        {
          
            new BalanceEnquiry(pinNo).setVisible(true);
            setVisible(false);
           
        }
        
           else if(ae.getSource()==pinChButton)
        {
          
            new PinChange(pinNo).setVisible(true);
            setVisible(false);
           
        }
        
            else if(ae.getSource()==mStateButton)
        {
          
            new MiniStatement(pinNo).setVisible(true);
        }
    }
    
    public static void main(String[] args)
    {
        new Transactions("");
    }
}
