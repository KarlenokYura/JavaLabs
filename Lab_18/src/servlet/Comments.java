package servlet;

import com.google.gson.Gson;
import context.CommentContext;
import entity.Comment;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

//@WebServlet("/Comments")
public class Comments extends HttpServlet implements Servlet {
    private CommentContext commentContext;

    @Override
    public void init() {
        try {
            commentContext = new CommentContext();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = new Gson().toJson(commentContext.getComments(Integer.parseInt(request.getParameter("refId"))));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Comment comment = new Gson().fromJson(json,Comment.class);
            comment.setStamp(new Date(System.currentTimeMillis()));
            commentContext.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String json = request.getReader().readLine();
            Comment comment = new Gson().fromJson(json,Comment.class);
            commentContext.updateComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	commentContext.deleteComment(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
