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

@WebServlet("/AffecterAdd")
public class AffecterAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AffecterDao affecterDao = new AffecterDao();
    private EmployeDao employeDao = new EmployeDao();
    private LieuDao lieuDao = new LieuDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Rediriger vers le formulaire d'ajout d'affectation
        request.getRequestDispatcher("add-affectation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Récupération des paramètres
            String codeemp = request.getParameter("codeemp");
            Long codelieu = Long.parseLong(request.getParameter("codelieu"));
            String dateStr = request.getParameter("date");

            // Conversion de la date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            // Récupération des objets métier
            Employe employe = employeDao.getEmploye(codeemp);
            Lieu lieu = lieuDao.getLieu(codelieu);

            // Validation
            if (employe == null || lieu == null) {
                request.setAttribute("errorMessage", "Employé ou Lieu introuvable !");
                request.getRequestDispatcher("add-affectation.jsp").forward(request, response);
                return;
            }

            // Création et sauvegarde de l'affectation
            Affecter affectation = new Affecter();
            affectation.setEmploye(employe);
            affectation.setLieu(lieu);
            affectation.setDate(date);

            affecterDao.saveAffectation(affectation);

            // Redirection vers la liste des affectations
            response.sendRedirect("AffecterList");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Format du code lieu invalide");
            request.getRequestDispatcher("add-affectation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur lors de l'ajout de l'affectation");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}