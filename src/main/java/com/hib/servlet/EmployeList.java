package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.hib.dao.EmployeDao;
import com.hib.model.Employe;

/**
 * Servlet implementation class EmployeList
 */
@WebServlet("/EmployeList")
public class EmployeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao employeDao = new EmployeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employe> employes = employeDao.getEmployes();
		request.setAttribute("employes", employes);
		request.getRequestDispatcher("list-employes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
