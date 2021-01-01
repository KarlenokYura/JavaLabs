import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DbServlet extends HttpServlet {
	
	String url = "jdbc:sqlserver://LXIBY848\\SQLEXPRESS;databaseName=Lab_10";
    String user = "yura";
    String password = "yura1605";
	Connection connection;

	@Override
	public void init() throws ServletException {
		try 
		{
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try 
		{
			String sql = "SELECT * FROM Students";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString(1);
				String name = resultSet.getString(2);
				pw.println("Student id: " + id + ", Student name: " + name);
				pw.flush();
			}
		} catch (SQLException e) {
			pw.println("Error");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try 
		{
			if (request.getParameter("name") != null) {
				PreparedStatement statement;
				statement = connection.prepareStatement("INSERT INTO Students (name) VALUES (?)");
				statement.setString(1, request.getParameter("name"));
				int row = statement.executeUpdate();
				if (row > 0) {
					pw.println("Student " + request.getParameter("name") + " was inserted");
				}
			}
			if (request.getParameter("id") != null) {
				CallableStatement statement;
				statement = connection.prepareCall("{call dbo.StudentsCount(?,?,?)}");
				statement.setInt(1, 1);
				statement.setInt(2, Integer.parseInt(request.getParameter("id")));
				statement.registerOutParameter(3, java.sql.Types.INTEGER);
				statement.execute();
				int count = statement.getInt(3);
				pw.println("Students count: " + count);
				pw.flush();
			}
		} catch (SQLException e) {
			pw.println("Error");
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try 
		{
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
