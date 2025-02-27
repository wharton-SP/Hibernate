package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.hib.dao.LieuDao;
import com.hib.model.Lieu;

/**
 * Servlet implementation class LieuList
 */
@WebServlet("/LieuList")
public class LieuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LieuDao lieuDao = new LieuDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Lieu> lieux = lieuDao.getLieux(); // Récupère tous les lieux
        request.setAttribute("lieux", lieux); // Met les lieux dans l'attribut
        request.getRequestDispatcher("list-lieux.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String designation = request.getParameter("designation");
        String province = request.getParameter("province");

        Lieu lieu = new Lieu(null, designation, province); // Crée un nouveau lieu
        lieuDao.saveLieu(lieu); // Sauvegarde le lieu dans la base

        response.sendRedirect("LieuList");
	}

}
