package net.codejava.sql;
 
import java.sql.*;
 
public class JavaConnect2SQL {
 
    public static void main(String[] args) {
 
    	String url = "jdbc:sqlserver://LXIBY848\\SQLEXPRESS;databaseName=Lab_10";
        String user = "yura";
        String password = "yura1605";
    	Connection connection;
 
    	try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			CallableStatement statement;
    		connection = DriverManager.getConnection(url, user, password);
			statement = connection.prepareCall("{call dbo.StudentsCount(?,?,?)}");
			statement.setInt(1, 1);
			statement.setInt(2, 5);
			statement.registerOutParameter(3, java.sql.Types.INTEGER);
			statement.execute();
			int countryCount = statement.getInt(3);
			System.out.println(countryCount);	
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}