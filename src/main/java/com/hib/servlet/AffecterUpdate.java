package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import com.hib.dao.AffecterDao;
import com.hib.dao.EmployeDao;
import com.hib.dao.LieuDao;
import com.hib.model.Affecter;
import com.hib.model.Employe;
import com.hib.model.Lieu;

/**
 * Servlet implementation class AffecterUpdate
 */
@WebServlet("/AffecterUpdate")
public class AffecterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AffecterDao affecterDao = new AffecterDao();
    private EmployeDao employeDao = new EmployeDao();
    private LieuDao lieuDao = new LieuDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffecterUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
	        Affecter affecter = affecterDao.getAffectationById(id);

	        // Vérifie si l'affectation existe
	        if (affecter != null) {
	            request.setAttribute("affecter", affecter);
	            request.getRequestDispatcher("/update-affectation.jsp").forward(request, response);
	        } else {
	            response.sendRedirect("list-affectation.jsp");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
	        String employeId = request.getParameter("employe");
	        String lieuId = request.getParameter("lieu");
	        Date date = Date.valueOf(request.getParameter("date"));

	        // Récupérer l'affectation
	        Affecter affecter = affecterDao.getAffectationById(id);
	        if (affecter != null) {
	            // Récupérer l'employé et le lieu à partir de leur ID
	            Employe employe = employeDao.getEmploye(Long.parseLong(employeId));
	            Lieu lieu = lieuDao.getLieu(Long.parseLong(lieuId));

	            // Mettre à jour l'affectation
	            affecter.setEmploye(employe);
	            affecter.setLieu(lieu);
	            affecter.setDate(date);

	            // Mettre à jour dans la base de données
	            affecterDao.updateAffectation(affecter);
	        }

	        response.sendRedirect("AffecterList");
	}

}
