/*Steps for JDBC :

step1: Register the Driver
step2: Create Conn
step3: Create Statement
step4: Execute Query
step5: Close Conn

*/
//
//

package bank.management.system;

import java.sql.*;


public class Conn {
    public Connection c;
    Statement s;
    public Conn() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create connection (Update DB name, username, and password)
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            s= c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}