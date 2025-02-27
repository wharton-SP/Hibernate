package com.hib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.hib.dao.AffecterDao;
import com.hib.model.Affecter;

/**
 * Servlet implementation class AffecterSearch
 */
@WebServlet("/AffecterSearch")
public class AffecterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffecterSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("keyword");

        // Appel de la méthode de recherche de la DAO
        AffecterDao affecterDao = new AffecterDao();
        List<Affecter> affectations = affecterDao.searchAffectations(keyword);

        // Passage des affectations trouvées à la page JSP
        request.setAttribute("affectations", affectations);

        // Redirection vers la page de liste
        request.getRequestDispatcher("/list-affectation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
