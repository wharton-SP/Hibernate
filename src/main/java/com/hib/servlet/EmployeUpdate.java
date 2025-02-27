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
 * Servlet implementation class EmployeUpdate
 */
@WebServlet("/EmployeUpdate")
public class EmployeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao = new EmployeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Long codeemp = Long.parseLong(req.getParameter("codeemp"));
	     Employe employe = employeDao.getEmploye(codeemp);
	     req.setAttribute("employe", employe);
	     req.getRequestDispatcher("update-employe.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long codeemp = Long.parseLong(req.getParameter("codeemp"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String poste = req.getParameter("poste");

        Employe employe = new Employe(nom, prenom, poste);
        employe.setCodeemp(codeemp);

        employeDao.updateEmploye(employe);

        resp.sendRedirect("EmployeList");
	}

}
