package com.yse.app.employees;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class EmployeeLoginController
 */
@WebServlet("/emp/login")
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/emp/login.jsp");
		view.forward(request, response);
		// 로그인 페이지로 이동하기 위해 RequestDispatcher 객체를 사용 /WEB-INF/views/emp/login.jsp로 이동한다.
		// WEB-INF 폴더는 외부에서 직접 접근할 수 없는 폴더이기 때문에 위 경로를 사용 
		// 로그인 페이지를 외부에서 직접 접근할 수 없도록 보호하기 위해 WEB-INF 폴더에 배치한다.
		// forward() 메서드는 요청과 응답 객체를 전달하여 지정된 JSP 페이지로 이동한다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("employeeId"); 
		//웹에서 employeeId라는 이름으로 전달된 값을 가져온다. 
		//employeeId는 웹에서 입력한 아이디값이 된다.
		
		String pw = request.getParameter("password");
		//웹에서 password라는 이름으로 전달된 값을 가져온다.
		
		int i = Integer.parseInt(id);


		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(i);
		employeeDTO.setPassword(pw);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDTO = employeeDAO.login(employeeDTO);
			
			if(employeeDTO != null) { //로그인 성공 , employeeDTO가 null이 아니면 로그인 성공 
				
				System.out.println("로그인 성공");
				
			}else {
				
				System.out.println("로그인 실패");
			}
			HttpSession session = request.getSession();
			
			session.setAttribute("dto", employeeDTO);
			//session.get
			//session.removeAttribute(pw);
			//가져온느게 있으면 넣는게 있고 삭제하는것도 있다.
			
			//포워드가 아닌 리다이렉트로 보낸다 
			response.sendRedirect("/home");
			//로그인 성공하면 리다이렉트로 홈화면으로 이동하게 
			
			//로그인 성공 여부에 관계없이 로그인 결과를 보여주는 페이지로 이동한다.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

