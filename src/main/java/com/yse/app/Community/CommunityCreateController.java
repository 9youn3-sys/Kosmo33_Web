package com.yse.app.Community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class CommunityCreateController
 */
@WebServlet("/comm/create")
public class CommunityCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/comm/create.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String t = request.getParameter("title");
		String n = request.getParameter("name");
		String c = request.getParameter("contents");
		String s = request.getParameter("star");
		
		CommunityDTO communityDTO = new CommunityDTO();
		
		communityDTO.setTitle(t);
		communityDTO.setName(n);
		communityDTO.setContents(c);
		communityDTO.setStar(Integer.parseInt(s));
		
		CommunityDAO communityDAO = new CommunityDAO();
		try {
			int result = communityDAO.create(communityDTO);

			if (result > 0) {
				response.sendRedirect("/comm/list");
			} else {
				response.sendRedirect("/comm/create");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
