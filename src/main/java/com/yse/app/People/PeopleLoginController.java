package com.yse.app.People;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.yse.app.People.PeopleDAO;
import com.yse.app.People.PeopleDTO;

/**
 * Servlet implementation class PeopleLoginController
 */
@WebServlet("/pp/login")
public class PeopleLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/pp/login.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		
		PeopleDTO peopleDTO = new PeopleDTO();
		peopleDTO.setUserId(id);
		peopleDTO.setUserPw(pw);
		
		PeopleDAO peopleDAO = new PeopleDAO();
		try {
			peopleDTO = peopleDAO.login(peopleDTO);
			
			if(peopleDTO != null) { //로그인 성공 , employeeDTO가 null이 아니면 로그인 성공 
				
				System.out.println("로그인 성공");
				
				HttpSession session = request.getSession();
				
				session.setAttribute("dto", peopleDTO);
				//세션저장은 성공했을때만 적용 
				
				response.sendRedirect("/home");
				
			}else {
				
				System.out.println("로그인 실패");
				request.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다");

				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/pp/login.jsp");
				view.forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
		
		
