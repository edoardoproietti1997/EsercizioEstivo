package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.db.DBConnection;
import it.dstech.model.Transazioni;

public class ServletVisualizzaTransazione extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) req.getAttribute("username");
		String password = (String) req.getAttribute("password");
		getServletContext().getRequestDispatcher("/visualizzaTransazioni.jsp").forward(req, resp);
//		int id = 0;
//		ArrayList<Transazioni> listaTransazioni = null;
//		try {
//			id = db.recoverId(username);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			listaTransazioni = (ArrayList<Transazioni>) db.transazioneObjectBySQL(id);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		for (Transazioni transazioni : listaTransazioni) {
//			req.setAttribute("categoria", transazioni.getCategoria());
//			req.setAttribute("descrizione", transazioni.getDescrizione());
//			req.setAttribute("importo", transazioni.getImporto());
//			req.setAttribute("data", transazioni.getData());
//			req.setAttribute("size", listaTransazioni.size());
//		}
		req.setAttribute("username", username);
		req.setAttribute("password", password);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}