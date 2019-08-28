package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.db.DBConnection;
import it.dstech.model.Transazioni;

public class ServletInserimentoTransazione extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/inseriscitransazione.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		Transazioni transazioni = new Transazioni();
		transazioni.setData(req.getParameter("data"));
		transazioni.setCategoria(req.getParameter("categoria"));
		transazioni.setImporto(Double.parseDouble((String)(req.getParameter("importo"))));
		transazioni.setDescrizione(req.getParameter("descrizione"));
		try {
			db.insertTransazione(transazioni);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String successo = "inserimento effettuato con successo";
		req.setAttribute("successo", successo);
		getServletContext().getRequestDispatcher("/homepage.jsp").forward(req, resp);
	}
}
