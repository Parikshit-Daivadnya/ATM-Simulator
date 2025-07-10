
package bank.management.system;

import javax.swing.*;     //for the JFrame class
import java.awt.*;        //for the Image class
import java.awt.event.*;  //because the ActionListener interface is present in the event package
import java.sql.*;        //for ResultSet class

public class Login extends JFrame implements ActionListener 
{
    //declaring buttons and textfields globally so that all methods of the Login class can acces them:
    JButton loginButton, clearButton, signUpButton;
    JTextField cardnoTextField; 
    JPasswordField pinTextField;
    
    Login()
    {
        setLayout(null);//by default layout of frame
        setSize(800,600); //size of frame
        setVisible(true); //because initially the frame is not made visible to the users
        setLocation(250,90); //location of frame
        setTitle("AUTOMATED TELLER MACHINE"); //frame title
        
        getContentPane().setBackground(Color.white);// frame background color
        
        //Adding an image as logo:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
        //for scaling the logo. Image class is in java.awt package
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
        
        ImageIcon i3= new ImageIcon(i2); //created new i3 obj beacuse JLabel does not accept Image class object 
        //hence converting the Image class i2 object to ImageIcon i3 object
        
        JLabel logolabel= new JLabel(i3); //TO add content on the frame
        logolabel.setBounds(355,10,100,100);//wihtout setbounds nothing will be visible
        //location of logo (dist from left, from top, width and height of logo)
        add(logolabel); //anything to added on the frame, add() function is used
        
        JLabel greetLabel = new JLabel("Welcome to ATM");
        greetLabel.setBounds(250,100,350,40);
        greetLabel.setFont(new Font("Osward", Font.BOLD, 38));
        add(greetLabel);
        
        JLabel cardnoLabel = new JLabel("Card No: ");
        cardnoLabel.setBounds(100,210,150,40);
        cardnoLabel.setFont(new Font("Raleway", Font.BOLD, 24));
        add(cardnoLabel);
        
        //card-no. text-fied
        cardnoTextField = new JTextField();
        cardnoTextField.setBounds(250,210,300,40);
        cardnoTextField.setFont(new Font("Arial",Font.BOLD, 20));
        add(cardnoTextField);
        
        JLabel pinLabel = new JLabel("PIN: ");
        pinLabel.setBounds(100,290,150,40);
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 24));
        add(pinLabel);
        
        //PIN text-field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(250,290,300,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 20));
        add(pinTextField);
        
        //login button
        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(250,410,140,40);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        add(loginButton);
          
        //clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(420,410,130,40);
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);
        clearButton.addActionListener(this); //adding the action functionality
        add(clearButton);
        
        
        //signUp button
        signUpButton = new JButton("Not registered?\n SIGN UP");
        signUpButton.setBounds(315,470,180,40);
        signUpButton.setBackground(Color.black);
        signUpButton.setForeground(Color.white);
        signUpButton.addActionListener(this);
        add(signUpButton);
                  
    }
    
    public void actionPerformed(ActionEvent ae)//overriding this abstract method from the ActionListener Interface
    {
      if(ae.getSource() == clearButton )
      {
        cardnoTextField.setText("");
        pinTextField.setText("");
      }
      
      else if(ae.getSource() == loginButton)
      {
          Conn c= new Conn(); // to establish connection
          String cardNum=cardnoTextField.getText(); // getting entered values from TextFields
          String pin=pinTextField.getText();
          String query ="select * from login where Card_Num = '"+cardNum+"' and PIN= '"+pin+"'"; // getting values from db
          try
          {
              ResultSet rs=c.s.executeQuery(query); // executeQuery because it is a DDL command
              //executeUpdate is for DML commands
              //ResultSet to store the result returned by query
              
              if(rs.next()) //if there is any value returned
              {
                setVisible(false);
                new Transactions(cardNum).setVisible(true);
              }
              else
              {
                JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN!");
                pinTextField.setText("");
              }
          }catch(Exception e)
          {
              System.out.println(e);
          }  
      }
      
      else if(ae.getSource() == signUpButton)
      {
        new SignUpOne().setVisible(true);
        setVisible(false);
      }
    }
    
    public static void main(String args[])
    {
        new Login();//anonyms obj so that as soon as the main() runs, obj is created and constructer is called
    }       
}



//try-catch block only for :
//1)Database query
//2)Error checking