package context;

import entity.Comment;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentContext {
	String url = "jdbc:sqlserver://LXIBY848\\SQLEXPRESS;databaseName=Lab_18";
    String user = "yura";
    String password = "yura1605";
	
    private Connection connection;

    public CommentContext() throws IOException {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    public List<Comment> getComments(int refId) throws  SQLException{
        ResultSet resultSet = connection.createStatement().executeQuery("select * from comment where refId ="+refId);
        List<Comment> comments = new ArrayList<Comment>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            refId = resultSet.getInt(2);
            String sessionId = resultSet.getString(3);
            Date stamp = resultSet.getDate(4);
            String comment = resultSet.getString(5);
            comments.add(new Comment(id,refId,sessionId,stamp,comment));
        }
        return  comments;
    }

    public void addComment(Comment comment) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comment(refId, sessionId, stamp, comment) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, comment.getRefId());
        preparedStatement.setString(2,comment.getSessionId());
        preparedStatement.setDate(3,comment.getStamp());
        preparedStatement.setString(4,comment.getComment());
        preparedStatement.executeUpdate();
    }

    public void updateComment(Comment comment) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("update comment set comment = ? where id = ?");
        preparedStatement.setString(1,comment.getComment());
        preparedStatement.setInt(2,comment.getId());
        preparedStatement.executeUpdate();
    }

    public void  deleteComment(int id) throws SQLException {
        connection.createStatement().executeUpdate("delete from comment where id = "+id);
    }
}
