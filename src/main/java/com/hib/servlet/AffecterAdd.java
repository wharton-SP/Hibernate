package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.AffecterDao;
import com.hib.dao.EmployeDao;
import com.hib.dao.LieuDao;
import com.hib.model.Affecter;
import com.hib.model.Employe;
import com.hib.model.Lieu;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class AffecterAdd
 */
@WebServlet("/AffecterAdd")
public class AffecterAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AffecterDao affecterDao = new AffecterDao();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AffecterAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Long codeemp = Long.parseLong(request.getParameter("codeemp"));
            Long codelieu = Long.parseLong(request.getParameter("codelieu"));
            String dateStr = request.getParameter("date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            EmployeDao employeDao = new EmployeDao();
            LieuDao lieuDao = new LieuDao();

            Employe employe = employeDao.getEmploye(codeemp);
            Lieu lieu = lieuDao.getLieu(codelieu);

            if (employe == null || lieu == null) {
                response.getWriter().write("Erreur: Employé ou Lieu introuvable !");
                return;
            }

            Affecter affectation = new Affecter();
            affectation.setEmploye(employe);
            affectation.setLieu(lieu);
            affectation.setDate(date);

            affecterDao.saveAffectation(affectation);

            response.sendRedirect("AffecterList");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
	}

}
