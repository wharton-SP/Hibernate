package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.LieuDao;
import com.hib.model.Lieu;

/**
 * Servlet implementation class LieuUpdate
 */
@WebServlet("/LieuUpdate")
public class LieuUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LieuDao lieuDao = new LieuDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long codelieu = Long.parseLong(request.getParameter("codelieu"));
        Lieu lieu = lieuDao.getLieu(codelieu);
        request.setAttribute("lieu", lieu);
        request.getRequestDispatcher("update-lieu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long codelieu = Long.parseLong(request.getParameter("codelieu"));
        String designation = request.getParameter("designation");
        String province = request.getParameter("province");

        Lieu lieu = new Lieu(codelieu, designation, province);
        lieuDao.updateLieu(lieu); // Met à jour le lieu

        response.sendRedirect("LieuList"); 
	}

}
