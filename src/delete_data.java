import java.sql.*;
import java.sql.DriverManager;

public class delete_data {
     
      public static void main(String[] args) {
        
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
Statement stmt=con.createStatement();  
String sql="delete from student where id=1";
stmt.executeUpdate(sql);
    System.out.println("data delete succfully");
con.close();  
}catch(Exception e)
{ System.out.println(e);
}  
}         
    
}
