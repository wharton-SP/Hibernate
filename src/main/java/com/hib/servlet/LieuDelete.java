package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.LieuDao;

/**
 * Servlet implementation class LieuDelete
 */
@WebServlet("/LieuDelete")
public class LieuDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LieuDao lieuDao = new LieuDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long codelieu = Long.parseLong(request.getParameter("codelieu"));
        lieuDao.deleteLieu(codelieu); // Supprime le lieu de la base
        response.sendRedirect("LieuList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
