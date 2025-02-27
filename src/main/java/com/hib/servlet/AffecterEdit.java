package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.hib.dao.AffecterDao;
import com.hib.dao.EmployeDao;
import com.hib.dao.LieuDao;
import com.hib.model.Affecter;
import com.hib.model.Employe;
import com.hib.model.Lieu;

/**
 * Servlet implementation class AffecterEdit
 */
@WebServlet("/AffecterEdit")
public class AffecterEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AffecterDao affecterDao = new AffecterDao();
	EmployeDao employeDao = new EmployeDao();
	LieuDao lieuDao = new LieuDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffecterEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")); // Récupérer l'id de l'affectation
        Affecter affecter = affecterDao.getAffectationById(id); // Récupérer l'affectation

        // Récupérer les listes des employés et des lieux
        List<Employe> employes = employeDao.getEmployes();
        List<Lieu> lieux = lieuDao.getLieux();

        // Passer les données à la JSP
        request.setAttribute("affecter", affecter);
        request.setAttribute("employes", employes);
        request.setAttribute("lieux", lieux);

        // Rediriger vers la JSP pour modifier l'affectation
        request.getRequestDispatcher("AffecterUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
