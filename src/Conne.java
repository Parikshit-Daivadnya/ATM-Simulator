/*Steps for JDBC :

step1: Register the Driver
step2: Create Conne
step3: Create Statement
step4: Execute Query
step5: Close Conne

*/

package bank.management.system;

import java.sql.*;


public class Conne {
    
    Connection c; //Connection class obj for establishing connection
    Statement s;  // For creating statement
    
   
    public Conne()
    {
        //try catch block i.e. exception handling because MySQL is an external entity and it may throw errors at runtime not at compile time
try{
          // Class.forName(com.mysql.cj.jdbc.Driver);
          //for registering driver...commented beacause connector file is added
          //Now no need to register any driver, java automatically detects and sets the path once the library is added.
          //so just add the file that's it
          
           c= DriverManager.getConnection("jdbc:mysql:///your database name","your username" ,"your password ");
           s= c.createStatement();    
        
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
