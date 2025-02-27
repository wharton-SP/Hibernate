package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.EmployeDao;
import com.hib.model.Employe;

/**
 * Servlet implementation class EmployeAdd
 */
@WebServlet("/EmployeAdd")
public class EmployeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao = new EmployeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-employe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String poste = req.getParameter("poste");

        Employe employe = new Employe(nom, prenom, poste);
        employeDao.saveEmploye(employe);

        resp.sendRedirect("EmployeList");
	}

}
