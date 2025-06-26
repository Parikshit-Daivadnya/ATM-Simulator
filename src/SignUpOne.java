
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser; //imported from jcalendar jar file(present inside the libraries)

public class SignUpOne extends JFrame implements ActionListener{
    
    JTextField fnameTextField, lnameTextField, fathernameTextField,
               addrTextField,pincodeTextField, cityTextField, stateTextField,
               mailTextField;
    
    JRadioButton maleButton,femaleButton, marriedButton, unmarriedButton;
    
    JDateChooser dateChooser;
    
    String randomNum;
    JButton sAndNButton;
    
    SignUpOne()
    {
        setLayout(null);
        
        setSize(800,700); 
        setVisible(true);
        setLocation(250,25);
        setTitle("New Account Application Form - Page 1");
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
       ImageIcon i3= new ImageIcon(i2); 
       JLabel logoLabel= new JLabel(i3); 
       logoLabel.setBounds(30,10,70,80);
       add(logoLabel);
 
        getContentPane().setBackground(Color.white);
        
        Random ran= new Random();
        randomNum=""+Math.abs(ran.nextInt()%1000);
        JLabel title1Label= new JLabel("Application Form No. "+ randomNum);
        title1Label.setFont(new Font("Oswald", Font.BOLD, 32));
        title1Label.setBounds(180,10,550,80);
        add(title1Label);
        
        JLabel title2Label= new JLabel("Page 1: Personal Details");
        title2Label.setFont(new Font("Oswald", Font.BOLD, 24));
        title2Label.setBounds(245,55,500,90);
        title2Label.setForeground(Color.BLUE);
        add(title2Label);
        
        JLabel fnameLabel= new JLabel("First Name:");
        fnameLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        fnameLabel.setBounds(100,125,500,70);
        add(fnameLabel);
        
        fnameTextField = new JTextField();
        fnameTextField.setBounds(310,147,300,25);
        fnameTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(fnameTextField);
        
        JLabel lnameLabel= new JLabel("Last Name: ");
        lnameLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        lnameLabel.setBounds(100,170,500,70);
        add(lnameLabel);
        
        lnameTextField = new JTextField();
        lnameTextField.setBounds(310,192,300,25);
        lnameTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(lnameTextField);
        
        JLabel fatherNameLabel= new JLabel("Father's Name: ");
        fatherNameLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherNameLabel.setBounds(100,215,500,70);
        add(fatherNameLabel);
        
        fathernameTextField = new JTextField();
        fathernameTextField.setBounds(310,238,300,25);
        fathernameTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(fathernameTextField);
        
        JLabel dobLabel= new JLabel("Date of Birth: ");
        dobLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        dobLabel.setBounds(100,260,500,70);
        add(dobLabel);
        
        dateChooser= new JDateChooser();
        dateChooser.setBounds(310,283,300,25);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        JLabel genderLabel= new JLabel("Gender: ");
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        genderLabel.setBounds(100,305,500,70);
        add(genderLabel);
        
        maleButton= new JRadioButton("Male");
        maleButton.setBounds(310, 325, 60,30);
        maleButton.setBackground(Color.white);
        add(maleButton);
        
        femaleButton= new JRadioButton("Female");
        femaleButton.setBounds(400, 325, 80,30);
        femaleButton.setBackground(Color.white);
        add(femaleButton);
        
        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        JLabel mailLabel= new JLabel("Email address: ");
        mailLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        mailLabel.setBounds(100,345,500,70);
        add(mailLabel);
        
        mailTextField = new JTextField();
        mailTextField.setBounds(310,368,300,25);
        mailTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(mailTextField);
        
        JLabel marriedLabel= new JLabel("Marital Status: ");
        marriedLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        marriedLabel.setBounds(100,390,500,70);
        add(marriedLabel);
        
        marriedButton= new JRadioButton("Married");
        marriedButton.setBounds(310, 420, 80,25);
        marriedButton.setBackground(Color.white);
        add(marriedButton);
        
        unmarriedButton= new JRadioButton("Unmarried");
        unmarriedButton.setBounds(401, 420, 100,25);
        unmarriedButton.setBackground(Color.white);
        add(unmarriedButton);
        
        ButtonGroup marriedGroup= new ButtonGroup();
        marriedGroup.add(marriedButton);
        marriedGroup.add(unmarriedButton);
        
        JLabel addrLabel= new JLabel("Address: ");
        addrLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        addrLabel.setBounds(100,435,500,70);
        add(addrLabel);
        
        addrTextField = new JTextField();
        addrTextField.setBounds(310,459,300,25);
        addrTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(addrTextField);
        
        JLabel cityLabel= new JLabel("City: ");
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        cityLabel.setBounds(100,480,500,70);
        add(cityLabel);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(310,504,300,25);
        cityTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(cityTextField);
        
        JLabel pinLabel= new JLabel("Pin Code: ");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        pinLabel.setBounds(100,525,500,70);
        add(pinLabel);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(310,549,300,25);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(pincodeTextField);
        
        JLabel stateLabel= new JLabel("State: ");
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        stateLabel.setBounds(100,565,500,70);
        add(stateLabel);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(310,589,300,25);
        stateTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(stateTextField);
        
        
        sAndNButton = new JButton("SAVE & NEXT");
        sAndNButton.setBounds(645,615,120,40);
        sAndNButton.setBackground(Color.black);
        sAndNButton.setForeground(Color.white);
        sAndNButton.addActionListener(this);
        add(sAndNButton);
        
        
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        
        String formNo= randomNum ;
        String fname = fnameTextField.getText();
        String lname = lnameTextField.getText();
        String fathername = fathernameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(maleButton.isSelected())
        {
            gender = "Male";
        }
        else if(femaleButton.isSelected())
        {
            gender = "Female";
        }
        
        String email= mailTextField.getText();
        
        String marriedstatus = null;
        if(marriedButton.isSelected())
        {
            marriedstatus = "Married";
        }
        else if(unmarriedButton.isSelected())
        {
            marriedstatus = "Unmarried";
        }
        
        String addr = addrTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try{
            if(fname.equals(""))
            {
                //JOptionPane is used to display a pop-up
                JOptionPane.showMessageDialog(null, "Enter your First Name");
            }
            else if(lname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your Last Name");
            }
            else if(fathername.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your Father's Name");
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your Date of Birth");
            }
            else if(gender==null)
            {
                JOptionPane.showMessageDialog(null, "Select your Gender");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your Email address");
            }
            else if(marriedstatus==null)
            {
                JOptionPane.showMessageDialog(null, "Select your Marital Status");
            }
            else if(addr.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your Address\n(20 characters only)");
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your City Name");
            }
            else if(pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your locality Pincode ");
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter your State Name");
            }
            
            
            else
            {
                Conne c= new Conne();
                String query= "insert into signup values ('"+formNo+"', '"+fname+"', '"+lname+"','"+fathername+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marriedstatus+"','"+addr+"', '"+city+"','"+pincode+"','"+state+"')" ;
                c.s.executeUpdate(query);
            
                new SignUpTwo(formNo).setVisible(true);
                setVisible(false);  
            }
            
        }catch(Exception ae)
        {
            System.out.println(ae);
        }
    }   
    
    public static void main(String args[])
    {
        new SignUpOne();
    }

  
    
}
