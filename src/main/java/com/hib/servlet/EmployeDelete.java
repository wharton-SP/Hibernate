package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.EmployeDao;

@WebServlet("/EmployeDelete")
public class EmployeDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeDao employeDao = new EmployeDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        try {
            String codeemp = req.getParameter("codeemp"); // Changé de Long à String
            employeDao.deleteEmploye(codeemp);
            resp.sendRedirect("EmployeList");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Erreur lors de la suppression");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}