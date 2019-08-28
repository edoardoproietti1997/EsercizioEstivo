package it.dstech.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.db.DBConnection;
import it.dstech.model.Account;

public class ServletRegistrazione extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		Account account = new Account();
		String username = req.getParameter("username");
		try {
			if (db.usernameCheck(username)) {
				String errore = "errore durante la registrazione";
				req.setAttribute("errore", errore);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		account.setUsername(username);
		String password = (req.getParameter("password"));
		account.setPassword(password);
		try {
			db.addAccount(account);
			String ok = "registrazione effettuata con successo";
			System.out.println(ok);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		getServletContext().getRequestDispatcher("/homepage.jsp").forward(req, resp);
	}

}
