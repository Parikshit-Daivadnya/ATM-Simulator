
package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;


public class SignUpTwo  extends JFrame implements ActionListener{
    
    String formNum;
    JTextField panTextField, aadharTextField;
    JRadioButton srYesButton,srNoButton,existingNoButton,existingYesButton;
    JComboBox religionMenu, categoryMenu,incomeMenu, eduMenu,occuMenu;
    JButton sAndNButton;
    
    public SignUpTwo(String formNo)
    {
        formNum=formNo;
        
        
        setLayout(null);
        
        setSize(800,700); 
        setVisible(true);
        setLocation(250,25);
        setTitle("New Account Application Form - Page 2");
        
        JLabel formNoLabel= new JLabel("Form No: "+formNum);
        formNoLabel.setFont(new Font("Raleway",Font.BOLD,22));
        formNoLabel.setBounds(620,17,150,22);
        add(formNoLabel);
        
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
       ImageIcon i3= new ImageIcon(i2); 
       JLabel logoLabel= new JLabel(i3); 
       logoLabel.setBounds(30,10,70,80);
       add(logoLabel);
       
        getContentPane().setBackground(Color.white);
       
        
        JLabel title1Label= new JLabel("Page 2 - Additional Details");
        title1Label.setFont(new Font("Oswald", Font.BOLD, 32));
        title1Label.setForeground(Color.BLUE);
        title1Label.setBounds(240,25,550,80);
        add(title1Label);
        
        JLabel religionLabel= new JLabel("Religion: ");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100,125,500,70);
        add(religionLabel);
        
        String[] valReligion = {"--","Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionMenu= new JComboBox(valReligion);
        religionMenu.setBounds(310,148,300,25);
        religionMenu.setBackground(Color.WHITE);
        religionMenu.setFont(new Font("Arial",Font.BOLD, 15));
        add(religionMenu);
        
        JLabel categoryLabel= new JLabel("Category: ");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100,170,500,70);
        add(categoryLabel);
        
        String[] valCategory = {"--","General", "OBC", "SC", "ST", "Other"};
        categoryMenu= new JComboBox(valCategory);
        categoryMenu.setBounds(310,193,300,25);
        categoryMenu.setBackground(Color.WHITE);
        categoryMenu.setFont(new Font("Arial",Font.BOLD, 15));
        add(categoryMenu);
        
        JLabel incomeLabel= new JLabel("Income: ");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100,215,500,70);
        add(incomeLabel);
        
        String[] valIncome = {"--","Null", "<= 1,00,000", "<= 2,50,000", "<= 5,00,000", "<= 10,00,000"," > 10,00,000"};
        incomeMenu= new JComboBox(valIncome);
        incomeMenu.setBounds(310,238,300,25);
        incomeMenu.setBackground(Color.WHITE);
        incomeMenu.setFont(new Font("Arial",Font.BOLD, 15));
        add(incomeMenu);
        
        JLabel eduLabel= new JLabel("Educational  ");
        eduLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        eduLabel.setBounds(100,260,500,70);
        add(eduLabel);
        
        JLabel quaLabel= new JLabel("Qualification: ");
        quaLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        quaLabel.setBounds(100,282,500,70);
        add(quaLabel);
        
        String[] valEdu = {"--","Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        eduMenu= new JComboBox(valEdu);
        eduMenu.setBounds(310,298,300,25);
        eduMenu.setBackground(Color.WHITE);
        eduMenu.setFont(new Font("Arial",Font.BOLD, 15));
        add(eduMenu);
        
        JLabel occuLabel= new JLabel("Occupation: ");
        occuLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occuLabel.setBounds(100,325,500,70);
        add(occuLabel);
        
        String[] valOccu = {"--","Salaried", "Self-Employed", "Business", "Student", "Retired","Others"};
        occuMenu= new JComboBox(valOccu);
        occuMenu.setBounds(310,348,300,25);
        occuMenu.setBackground(Color.WHITE);
        occuMenu.setFont(new Font("Arial",Font.BOLD, 15));
        add(occuMenu);
        
        JLabel panNoLabel= new JLabel("PAN No: ");
        panNoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panNoLabel.setBounds(100,369,500,70);
        add(panNoLabel);
        
        panTextField = new JTextField();
        panTextField.setBounds(310,393,300,25);
        panTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(panTextField);
        
        JLabel aadharNoLabel= new JLabel("Aadhar No: ");
        aadharNoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNoLabel.setBounds(100,414,500,70);
        add(aadharNoLabel);
        
        aadharTextField= new JTextField();
        aadharTextField.setBounds(310, 435, 300,25);
        aadharTextField.setFont(new Font("Arial",Font.BOLD, 15));
        add(aadharTextField);
        
        JLabel srCitizenLabel= new JLabel("Senior Citizen: ");
        srCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        srCitizenLabel.setBounds(100,460,500,70);
        add(srCitizenLabel);
        
        srYesButton= new JRadioButton("Yes");
        srYesButton.setBounds(310, 484, 80,25);
        srYesButton.setBackground(Color.white);
        add(srYesButton);
        
        srNoButton= new JRadioButton("No");
        srNoButton.setBounds(421, 484, 100,25);
        srNoButton.setBackground(Color.white);
        add(srNoButton);
        
        ButtonGroup srCitizenGroup= new ButtonGroup();
        srCitizenGroup.add(srYesButton);
        srCitizenGroup.add(srNoButton);
        
        JLabel existAccountLabel= new JLabel("Existing Account: ");
        existAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existAccountLabel.setBounds(100,506,500,70);
        add(existAccountLabel);
        
        existingYesButton= new JRadioButton("Yes");
        existingYesButton.setBounds(310, 531, 80,25);
        existingYesButton.setBackground(Color.white);
        add(existingYesButton);
        
        existingNoButton= new JRadioButton("No");
        existingNoButton.setBounds(421, 531, 100,25);
        existingNoButton.setBackground(Color.white);
        add(existingNoButton);
        
        ButtonGroup existAccountGroup= new ButtonGroup();
        existAccountGroup.add(existingYesButton);
        existAccountGroup.add(existingNoButton);
        
        sAndNButton = new JButton("SAVE and NEXT");
        sAndNButton.setBounds(625,615,150,40);
        sAndNButton.setBackground(Color.black);
        sAndNButton.setForeground(Color.white);
        sAndNButton.addActionListener(this);
        add(sAndNButton);
        
        
    }
    
     public void actionPerformed(ActionEvent e) 
    {
        String formNo=formNum ;
        String religion = (String) religionMenu.getSelectedItem();
        String category = (String) categoryMenu.getSelectedItem();
        String income = (String) incomeMenu.getSelectedItem();
        String education = (String) eduMenu.getSelectedItem();
        String occupation = (String) occuMenu.getSelectedItem();
        String panNo = panTextField.getText();
        String aadharNo = aadharTextField.getText();
        
        String srCitizen = null;
        if(srYesButton.isSelected())
        {
            srCitizen = "Yes";
        }
        else if(srNoButton.isSelected())
        {
            srCitizen = "No";
        }
        
        String existing = null;
        if(existingYesButton.isSelected())
        {
            existing = "Yes";
        }
        else if(existingNoButton.isSelected())
        {
            existing = "No";
        }
        
        try{
 
            if(religion.equals("--"))
            {
                //JOptionPane is used to display a pop-up 
                JOptionPane.showMessageDialog(null, "Religion is Required");
                setVisible(true);
            }
            else if(category.equals("--"))
            {
                JOptionPane.showMessageDialog(null, "Category is Required");
            }
            else if(income.equals("--"))
            {
                JOptionPane.showMessageDialog(null, "Income is Required");
            }
            else if(education.equals("--"))
            {
                JOptionPane.showMessageDialog(null, "Education is Required");
            }
            else if(occupation.equals("--"))
            {
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }
            else if(panNo.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }
            else if(aadharNo.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            }
            else if(srCitizen==null)
            {
                JOptionPane.showMessageDialog(null, "Senior Citizen or Not?");
            }
            else if(existing==null)
            {
                JOptionPane.showMessageDialog(null, "Existing Account or Not?");
            }
            
            else{
                Conne c= new Conne();
                String query= "insert into signup2 values ('"+formNo+"', '"+religion+"', '"+category+"','"+income+"', '"+education+"', '"+occupation+"', '"+panNo+"', '"+aadharNo+"','"+srCitizen+"', '"+existing+"')" ;
                c.s.executeUpdate(query);
                
                
                new SignUpThree(formNo).setVisible(true);
                setVisible(false);
                }
            
            
        }catch(Exception ae)
        {
            System.out.println(ae);
        }
        
        
       
    }
    
    public static void main(String[] args)
    {
        new SignUpTwo("");
    }
}
