package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import database.DBManager;

@WebServlet(name="TestServlet",urlPatterns={"/test"}, initParams={@WebInitParam(name="name",value="HELLO!!")})
public class TestServlet extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		List<User> users = null;
		try {
			users = DBManager.findList(request.getParameter("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
