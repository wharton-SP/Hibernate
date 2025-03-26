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

@WebServlet("/AffecterUpdate")
public class AffecterUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AffecterDao affecterDao = new AffecterDao();
    private EmployeDao employeDao = new EmployeDao();
    private LieuDao lieuDao = new LieuDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Affecter affecter = affecterDao.getAffectationById(id);

            if (affecter != null) {
                request.setAttribute("affecter", affecter);
                request.getRequestDispatcher("/update-affectation.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Affectation introuvable");
                request.getRequestDispatcher("AffecterList").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur lors de la récupération de l'affectation");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String employeCode = request.getParameter("employe"); // Changé de employeId à employeCode
            Long lieuId = Long.parseLong(request.getParameter("lieu"));
            Date date = Date.valueOf(request.getParameter("date"));

            Affecter affecter = affecterDao.getAffectationById(id);
            if (affecter != null) {
                // Récupération avec le code employé (String)
                Employe employe = employeDao.getEmploye(employeCode);
                Lieu lieu = lieuDao.getLieu(lieuId);

                if (employe == null || lieu == null) {
                    request.setAttribute("errorMessage", "Employé ou Lieu introuvable");
                    doGet(request, response);
                    return;
                }

                affecter.setEmploye(employe);
                affecter.setLieu(lieu);
                affecter.setDate(date);

                affecterDao.updateAffectation(affecter);
                response.sendRedirect("AffecterList");
            } else {
                request.setAttribute("errorMessage", "Affectation introuvable");
                doGet(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur lors de la mise à jour");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}