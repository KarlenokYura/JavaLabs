package context;

import entity.Reference;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceContext {
	String url = "jdbc:sqlserver://LXIBY848\\SQLEXPRESS;databaseName=Lab_18";
    String user = "yura";
    String password = "yura1605";
	
    private Connection connection;

    public ReferenceContext() throws IOException {
    	try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    public List<Reference> getReferences(String filter) throws  SQLException{
    	if (filter == null)
    		filter = "";
        //PreparedStatement preparedStatement = connection.prepareStatement("select * from reference where description like ?");
        //preparedStatement.setString(1,"%"+filter+"%");
        //ResultSet resultSet = preparedStatement.executeQuery();
        //System.out.println(resultSet);
        
        String[] resultArray = filter.split("\\,",-1); 
        String result = "select * from reference where description like '" + resultArray[0] + "' ";
        for (int i = 1; i < resultArray.length; i++) {
        	result += "or description like " + "'" + resultArray[i] + "' ";
        }
        
        if (filter == "") 
        	result = "select * from reference";
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(result);
        
        List<Reference> references = new ArrayList<Reference>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String url = resultSet.getString(2);
            String description = resultSet.getString(3);
            int minus = resultSet.getInt(4);
            int plus = resultSet.getInt(5);
            references.add(new Reference(id,url,description,minus,plus));
        }
        return references;
    }

    public void addReference(Reference reference) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into reference(url, description, minus, plus) VALUES (?,?,?,?)");
        preparedStatement.setString(1, reference.getUrl());
        preparedStatement.setString(2,reference.getDescription());
        preparedStatement.setInt(3,reference.getMinus());
        preparedStatement.setInt(4,reference.getPlus());
        preparedStatement.executeUpdate();
    }

    public void updateReference(Reference reference) throws SQLException{
        String sqlRequest = "update reference set ";
        if (reference.getUrl() != null && reference.getDescription() != null)
            sqlRequest += "url = '"+reference.getUrl()+"', description = '"+reference.getDescription()+"'";
        if (reference.getPlus() != -1)
            sqlRequest += " plus = "+(reference.getPlus()+1);
        if (reference.getMinus() != -1)
        	sqlRequest += " minus = "+(reference.getMinus()+1);
        sqlRequest += " where id ="+reference.getId();
        connection.createStatement().executeUpdate(sqlRequest);
    }

    public void deleteReference(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from comment where refId = "+id);
        statement.executeUpdate("delete from reference where id = "+id);
    }
}