package com.yse.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentCreateController
 */
@WebServlet("/dept/create")
public class DepartmentCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentCreateController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/create.jsp");
		//어떤걸 전달할지 폴더 설정 
		view.forward(request, response); //전달 하는 구문 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("departmentName");
		String m = request.getParameter("managerId");
		String l = request.getParameter("locationId");
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentName(name);
		departmentDTO.setLocationId(Integer.parseInt(l));
		//departmentDto.setLocationId(l); 하는 경우 에러남 
		//이유: DTO에는 Integer타입이기 때문
		//위처럼 Integer.parseInt 사용해서 바꿔줘야함 
		departmentDTO.setManagerId(Integer.parseInt(m));
		
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			int result = departmentDAO.create(departmentDTO);
			if(result>0){
				response.sendRedirect("/dept/list"); 
				//response.sendRedirect("/dept/list"); 이런 코드 적는 이유 
				//해당 주소를 줄테니 클라이언트 너가 직접 요청해
				
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}