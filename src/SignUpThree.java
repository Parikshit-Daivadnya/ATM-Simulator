
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpThree extends JFrame implements ActionListener {
 
    String formNo;
    JRadioButton sButton,cButton, fdButton, rdButton;
    JCheckBox a,b,c,d,e,f,g;
    JButton cancelButton, submitButton, gotoLoginButton;
    
    public SignUpThree(String formNum)
    {
        formNo=formNum;
        //this.formNum=formNum;
        setLayout(null);
        
        setSize(800,700); 
        setVisible(true);
        setLocation(250,25);
        setTitle("New Account Application Form - Page 3");
        
        getContentPane().setBackground(Color.white);
        
        JLabel formNoLabel= new JLabel("Form No: "+formNo);
        formNoLabel.setFont(new Font("Raleway",Font.BOLD,22));
        formNoLabel.setBounds(620,17,150,22);
        add(formNoLabel);
        
        JLabel title1Label= new JLabel("Page 3 - Account Details");
        title1Label.setFont(new Font("Oswald", Font.BOLD, 32));
        title1Label.setForeground(Color.BLUE);
        title1Label.setBounds(225,30,550,80);
        add(title1Label);
        
        JLabel accTypeLabel= new JLabel("Select Account Type: ");
        accTypeLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        accTypeLabel.setBounds(80,100,550,80);
        add(accTypeLabel);
        
        sButton= new JRadioButton("Savings Account");
        sButton.setFont(new Font("Oswald", Font.BOLD, 15));
        sButton.setBounds(90, 160, 220,20);
        sButton.setBackground(Color.white);
        add(sButton);
        
        fdButton= new JRadioButton("Fixed Deposit Account");
        fdButton.setFont(new Font("Oswald", Font.BOLD, 15));
        fdButton.setBounds(350, 160, 220,20);
        fdButton.setBackground(Color.white);
        add(fdButton);
        
        cButton= new JRadioButton("Current Account");
        cButton.setFont(new Font("Oswald", Font.BOLD, 15));
        cButton.setBounds(90, 190, 220,20);
        cButton.setBackground(Color.white);
        add(cButton);
        
        rdButton= new JRadioButton("Recurring Deposit Account");
        rdButton.setFont(new Font("Oswald", Font.BOLD, 15));
        rdButton.setBounds(350, 190, 250,20);
        rdButton.setBackground(Color.white);
        add(rdButton);
        
        ButtonGroup accTypeGroup= new ButtonGroup();
        accTypeGroup.add(sButton);
        accTypeGroup.add(fdButton);
        accTypeGroup.add(cButton);
        accTypeGroup.add(rdButton);
        
        
        JLabel cardNoLabel= new JLabel("Card Number: ");
        cardNoLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        cardNoLabel.setBounds(80,240,550,40);
        add(cardNoLabel);
        
        JLabel cNumLabel= new JLabel("XXXX-XXXX-XXXX-2302");
        cNumLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        cNumLabel.setBounds(350,240,550,40);
        add(cNumLabel);
        
        JLabel cardNoLabel2= new JLabel("(Your 16-digit card number)");
        cardNoLabel2.setFont(new Font("Oswald", Font.BOLD, 14));
        cardNoLabel2.setBounds(80,265,300,30);
        add(cardNoLabel2);
        
        JLabel pinLabel= new JLabel("PIN: ");
        pinLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        pinLabel.setBounds(80,310,550,40);
        add(pinLabel);
        
        JLabel pNumLabel= new JLabel("XXXX");
        pNumLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        pNumLabel.setBounds(350,310,550,40);
        add(pNumLabel);
        
        JLabel pinLabel2= new JLabel("(Your 4-digit PIN)");
        pinLabel2.setFont(new Font("Oswald", Font.BOLD, 14));
        pinLabel2.setBounds(80,335,300,30);
        add(pinLabel2);
        
        JLabel servicesLabel= new JLabel("Select Required Services: ");
        servicesLabel.setFont(new Font("Oswald", Font.BOLD, 22));
        servicesLabel.setBounds(80,380,550,40);
        add(servicesLabel);
        
        a=new JCheckBox("ATM Card");
        a.setBackground(Color.white);
        a.setFont(new Font("Ariel",Font.ITALIC,15));
        a.setBounds(80,420,100,40);
        add(a);
        
        b=new JCheckBox("Internet Banking");
        b.setBackground(Color.white);
        b.setFont(new Font("Ariel",Font.ITALIC,15));
        b.setBounds(300,420,150,40);
        add(b);
        
        c=new JCheckBox("Mobile Banking");
        c.setBackground(Color.white);
        c.setFont(new Font("Ariel",Font.ITALIC,15));
        c.setBounds(80,460,150,40);
        add(c);
        
        d=new JCheckBox("EMAIL and SMS alerts");
        d.setBackground(Color.white);
        d.setFont(new Font("Ariel",Font.ITALIC,15));
        d.setBounds(300,460,200,40);
        add(d);
        
        e=new JCheckBox("Cheque Book");
        e.setBackground(Color.white);
        e.setFont(new Font("Ariel",Font.ITALIC,15));
        e.setBounds(80,500,150,40);
        add(e);
        
        f=new JCheckBox("E-statement");
        f.setBackground(Color.white);
        f.setFont(new Font("Ariel",Font.ITALIC,15));
        f.setBounds(300,500,150,40);
        add(f);
        
        g=new JCheckBox("I hereby declare that the above entered details are correct and to the best of my knowledge.");
        g.setBackground(Color.white);
        g.setFont(new Font("Ariel",Font.BOLD,12));
        g.setBounds(40,560,700,40);
        add(g);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(260,610,100,30);
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.white);
        submitButton.addActionListener(this);
        add(submitButton);
        
        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(470,610,100,30);
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submitButton)
        {
            String accType=null;
            if(sButton.isSelected())
            {
                accType = "Savings Account";
            }
            else if(fdButton.isSelected())
            {
                accType = "Fixed Deposit Account";
            }
            else if(cButton.isSelected())
            {
                accType = "Current Account";
            }
            else if(rdButton.isSelected())
            {
                accType = "Recurring Deposit Account";
            }
            
            Random r= new Random();
            String cardNum = String.format("%012d", Math.abs(r.nextLong() % 1000000000000L)) + 2302;
            String pinNum = String.format("%04d", r.nextInt(9000) + 1000);

            
            String services="";
            
            if(a.isSelected())
            {
                services+="ATM card";
            }
            if(b.isSelected())
            {
                services+="Internet Banking";
            }
            if(c.isSelected())
            {
                services+="Mobile Banking";
            }
            if(d.isSelected())
            {
                services+="EMAIL and SMS alerts";
            }
            if(e.isSelected())
            {
                services+="Cheque Book";
            }
            if(f.isSelected())
            {
                services+="E-statement";
            }
            
        try{
            if(accType==null)
                {
                    JOptionPane.showMessageDialog(null, "Select Type of Account");
                }

                else if(services.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Select atleast 1 Service");
                }
                
                else if(!g.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Check the Declaration to proceed");
                }
                
                else{
                    Conne c= new Conne();
                    String query1= "insert into signup3 values ("+formNo+", '"+accType+"', '"+cardNum+"',"+pinNum+", '"+services+"')" ;
                    String query2="insert into login values("+formNo+", "+cardNum+", "+pinNum+")";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNum+"\nPin: "+pinNum);
                    
                    submitButton.setVisible(false);
                    
                    gotoLoginButton = new JButton("Go to Log In Page");
                    gotoLoginButton.setBounds(245,610,145,30);
                    gotoLoginButton.setBackground(Color.black);
                    gotoLoginButton.setForeground(Color.white);
                    gotoLoginButton.addActionListener(this);
                    add(gotoLoginButton);
                    
                }
                
            }
        
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
            
        }
        else if(ae.getSource()==cancelButton)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        
        else if(ae.getSource()==gotoLoginButton)
        {
            new Login().setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new SignUpThree("");
    }
}


