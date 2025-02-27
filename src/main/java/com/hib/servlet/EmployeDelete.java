package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hib.dao.EmployeDao;

/**
 * Servlet implementation class EmployeDelete
 */
@WebServlet("/EmployeDelete")
public class EmployeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao = new EmployeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Long codeemp = Long.parseLong(req.getParameter("codeemp"));
        employeDao.deleteEmploye(codeemp);
        resp.sendRedirect("EmployeList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
