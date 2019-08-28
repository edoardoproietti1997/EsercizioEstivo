package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.db.DBConnection;

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 2L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			if (db.loginCheck(username, password) == false) {
				getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/homepage.jsp").forward(req, resp);
		req.setAttribute("username", username);
		req.setAttribute("password", password);
	}
}
