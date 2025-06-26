
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    String pinNum;
    JPasswordField newPinField, newPinReField;
    JButton changeButton, backButton;
    
    public PinChange(String pinNo)
    {
        pinNum=pinNo;
        
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
        
        JLabel textLabel= new JLabel("CHANGE YOUR PIN");
        textLabel.setFont(new Font("Raleway",Font.BOLD,18));
        textLabel.setForeground(Color.white);
        textLabel.setBounds(195,225,290,22);
        image.add(textLabel);
        
        JLabel newPinLabel= new JLabel("Enter New PIN:");
        newPinLabel.setFont(new Font("Raleway",Font.BOLD,15));
        newPinLabel.setForeground(Color.white);
        newPinLabel.setBounds(145,275,290,22);
        image.add(newPinLabel);
        
        newPinField= new JPasswordField();
        newPinField.setBounds(290,275,120,25);
        newPinField.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(newPinField);
        
        JLabel newPinReLabel= new JLabel("Re-Enter New PIN:");
        newPinReLabel.setFont(new Font("Raleway",Font.BOLD,15));
        newPinReLabel.setForeground(Color.white);
        newPinReLabel.setBounds(145,330,290,22);
        image.add(newPinReLabel);
        
        newPinReField= new JPasswordField();
        newPinReField.setBounds(290,330,120,25);
        newPinReField.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(newPinReField);
        
        changeButton = new JButton("Change");
        changeButton.setBounds(380,405,80,25);
        changeButton.addActionListener(this);
        image.add(changeButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(380,445,80,25);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String pinNo=pinNum;
        
        if(ae.getSource()==backButton)
        {
            new Transactions(pinNo).setVisible(true);
            setVisible(false);
        }
        
        else if(ae.getSource()==changeButton)
        {
            try{
                String npin=newPinField.getText();
                String rpin=newPinReField.getText();
                
                if(npin.equals("") || rpin.equals(""))
                {
                     JOptionPane.showMessageDialog(null,"Enter new PIN");
                }
                if(!rpin.equals(npin))
                {
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    newPinField.setText("");
                    newPinReField.setText("");
                    return;
                }
                
                else{
                    Conne c= new Conne();
                    String queryB="update bank set PIN='"+rpin+"' where PIN ='"+pinNo+"'";
                    String queryL="update login set PIN='"+rpin+"' where PIN ='"+pinNo+"'";
                    String queryS="update signup3 set PIN='"+rpin+"' where PIN ='"+pinNo+"'";
                    c.s.executeUpdate(queryB);
                    c.s.executeUpdate(queryL);
                    c.s.executeUpdate(queryS);
                    
                    JOptionPane.showMessageDialog(null,"PIN changed successfully");
                    
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                    
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args)
    {
        new PinChange("");
    }
}
