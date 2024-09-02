/*
CREATE DATABASE test_db;
USE test_db;
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);
*/

//code for full CRUD operation using JDBC 
import java.util.Scanner;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


 public class Implementation {
   public void SelectEmployee() {
        String sql = "SELECT id, name, rollno, address FROM student  WHERE id = ?";
        try {
           Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("rollno: " + rs.getString("rollno"));
                System.out.println("address: " + rs.getString("address"));
            
            }
             }
         catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
   }

   public void insertEmployee() {
        String sql = "INSERT INTO student (name, rollno, address) VALUES ( ?, ?, ?)";
        try {
            Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "6775");
            pstmt.setString(3, "USA");
            pstmt.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
   }

   public void updateEmployee() {
        String sql = "UPDATE student SET name = ?, rollno = ?, address = ? WHERE id = ?";
        try {
Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Jane Doe");
            pstmt.setInt(2, 4334);
            pstmt.setString(3, "Canada");
            pstmt.setInt(4,8);
            pstmt.executeUpdate();
            System.out.println("Record updated.");
         }catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
   }

   public void deleteEmployee()  {
        String sql = "DELETE FROM student WHERE id =?";
        try {
           Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 2);
            pstmt.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
   }


   public static void main(String[] args) {
	int choice;
	Implementation obj=new Implementation();
	
	System.out.println("Welcome to ABC Limited \n Please Enter your Choice");
	System.out.println(" 1. View student \n 2. Add New student \n 3. Update Existing student \n 4. Delete Exisitng student \n 5. Exit ");
	Scanner sc=new Scanner(System.in);
	choice=sc.nextInt();
	
	switch(choice)
	{
		case 1: 
        obj.SelectEmployee();
        break;
		case 2:
        obj. insertEmployee();
        break;
		case 3:
         obj.updateEmployee();
         break;
		case 4:
         obj.deleteEmployee();
         break;
	
	}
}
}