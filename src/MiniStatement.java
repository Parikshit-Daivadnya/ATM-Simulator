
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    
    public MiniStatement(String pinNo)
    {
       String pinNum=pinNo;
        setLayout(null);
        setSize(400,550);
        setLocation(450,50);
       // setUndecorated(true);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.white); 
        
        JLabel miniLabel= new JLabel();
        add(miniLabel);
        
        JLabel titleLabel=new JLabel("Indian Bank");
        titleLabel.setBounds(145,05,200,30);
        titleLabel.setFont(new Font("Raleway",Font.BOLD,18));
        add(titleLabel);
        
        JLabel cardNumLabel= new JLabel();
        add(cardNumLabel);
        
        JLabel titleLabel2=new JLabel("Transactions History: ");
        titleLabel2.setBounds(20,130,200,30);
        titleLabel2.setFont(new Font("Raleway",Font.BOLD,15));
        add(titleLabel2);
        
  try {
    Conne con = new Conne();
    String query="select * from login where PIN ='"+pinNum+"'";   
    ResultSet rs1=con.s.executeQuery(query);
    while(rs1.next())
    {
        cardNumLabel.setText("Card Number: " + rs1.getString("Card_Num"));
    }
            
    String query2 = "SELECT * FROM bank WHERE PIN = '" + pinNum + "' ORDER BY Date DESC LIMIT 5";
    ResultSet rs2 = con.s.executeQuery(query2);

    String transactions = "<html>";

    while (rs2.next()) {
        transactions+=rs2.getString("Date")+
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                    rs2.getString("Type")+
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                    rs2.getString("Amount")+
                    "<br><br>";
    }

    transactions +="</html>";
    miniLabel.setText(transactions);

} catch (Exception e) {
    System.out.println(e);
}

        cardNumLabel.setBounds(20,60,300,40);
        cardNumLabel.setFont(new Font("Raleway",Font.BOLD,18));
       
        miniLabel.setBounds(20,190,450,100);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args)
    {
        new MiniStatement("");
    }
}
