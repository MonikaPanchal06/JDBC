import java.sql.*;
import java.sql.DriverManager;

public class insert_data {

      public static void main(String[] args) {
        
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
Statement stmt=con.createStatement();  
String sql="insert into student"+"(name,rollno,address)"+"values('mouni',565,'nagda')";
stmt.executeUpdate(sql);
    System.out.println("data insert succfully");
con.close();  
}catch(Exception e)
{ System.out.println(e);
}  
}         
    
}


