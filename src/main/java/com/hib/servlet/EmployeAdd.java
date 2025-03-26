package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.EmployeDao;
import com.hib.model.Employe;

@WebServlet("/EmployeAdd")
public class EmployeAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeDao employeDao = new EmployeDao();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("add-employe.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String codeemp = req.getParameter("codeemp"); // Nouveau champ
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String poste = req.getParameter("poste");

        Employe employe = new Employe(codeemp, nom, prenom, poste); // Utilisation du nouveau constructeur
        employeDao.saveEmploye(employe);

        resp.sendRedirect("EmployeList");
    }
}