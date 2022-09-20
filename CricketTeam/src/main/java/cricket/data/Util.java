package cricket.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Util {
    public static Statement getStatement(){
        Connection con = null;
        Statement st =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","password");
            st = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }

}
