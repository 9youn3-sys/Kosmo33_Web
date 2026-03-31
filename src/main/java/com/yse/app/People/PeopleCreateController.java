package com.yse.app.People;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PeopleController
 */
@WebServlet("/pp/create")
public class PeopleCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/pp/create.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 값 받기 
		String name = request.getParameter("userName");
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String e = request.getParameter("userEmail");
		
		//DTO에 정보 담기
		PeopleDTO peopleDTO = new PeopleDTO(); //담기위해 객체생성
		peopleDTO.setUserName(name);
		peopleDTO.setUserId(id);
		peopleDTO.setUserPw(pw);
		peopleDTO.setUserEmail(e);
		
		PeopleDAO peopleDAO = new PeopleDAO();
		try {
			int result = peopleDAO.create(peopleDTO);
			
			if(result>0) {
				
				System.out.println("회원가입 성공");
			}else {
				
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		response.sendRedirect("/home");
		
	}

}
