package it.dstech.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.model.Transazioni;

public class ServletInserimentoTransazione extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/inseriscitrnsazione.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Transazioni transazioni = new Transazioni();
		transazioni.setData(req.getParameter("data"));
		transazioni.setCategoria(req.getParameter("categoria"));
		transazioni.setImporto(Integer.parseInt(req.getParameter("importo")));
		transazioni.setDescrizione(req.getParameter("descrizione"));
	}
}
