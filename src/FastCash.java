
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hButton, fhButton, othButton, fthButton, tthButton, backButton,fftButton;
    String pinNum;
    
    public FastCash(String pinNo)
    {
        pinNum=pinNo;
        setLayout(null);
        setSize(800,750);
        setLocation(280,00);
        setUndecorated(true); //removing the "full, mini, close" options
        setTitle("Fast Cash Page");
        
        getContentPane().setBackground(Color.white);   
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3= new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        
        JLabel textLabel= new JLabel("Select amount to withdraw: ");
        textLabel.setFont(new Font("Raleway",Font.BOLD,18));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(165,225,290,22);
        image.add(textLabel);
        
        hButton = new JButton("Rs. 100");
        hButton.setBounds(135,280,140,25);
        hButton.addActionListener(this);
        image.add(hButton);
        
        fhButton = new JButton("Rs. 500");
        fhButton.setBounds(300,280,140,25);
        fhButton.addActionListener(this);
        image.add(fhButton);
        
        othButton = new JButton("Rs. 1000");
        othButton.setBounds(135,325,140,25);
        othButton.addActionListener(this);
        image.add(othButton);
        
        fthButton = new JButton("Rs. 5000");
        fthButton.setBounds(300,325,140,25);
        fthButton.addActionListener(this);
        image.add(fthButton);
        
        tthButton = new JButton("Rs. 10000");
        tthButton.setBounds(135,370,140,25);
        tthButton.addActionListener(this);
        image.add(tthButton);
        
        fftButton = new JButton("Rs. 50000");
        fftButton.setBounds(300,370,140,25);
        fftButton.addActionListener(this);
        image.add(fftButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(250,425,80,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String pinNo=pinNum;
        if(ae.getSource()==backButton)
        {
            new Transactions("").setVisible(true);
            setVisible(false);
        }
        
        else 
        {
            String amount= ((JButton)ae.getSource()).getText().substring(4);
            
            try
            {
                Conne c= new Conne();
                String query="select * from bank where PIN='"+pinNo+"'";
                ResultSet rs= c.s.executeQuery(query);
                int balance=0;
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
                
                if(balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                
                else{
                    Date date= new Date();
                    String query2="insert into bank values ('"+pinNo+"','"+date+"','Withdrawn','"+amount+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" debited successfully.");
                    
                    new Transactions(pinNo).setVisible(true);
                    setVisible(false);
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        new FastCash("");
    }
}
