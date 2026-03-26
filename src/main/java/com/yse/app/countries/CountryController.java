package com.yse.app.countries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.yse.app.countries.CountryDTO;

/**
 * Servlet implementation class CountryController
 */
@WebServlet("/country/list")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURL());
		
		CountryDAO dao = new CountryDAO();
		
		try {
			ArrayList<CountryDTO> ar = dao.list();
			request.setAttribute("list", ar);
			
			
//			request.setAttribute("list", ar);
			//request 정보는 살아있으니 request에 정보를 담는다.
			//setAttribute는 MAP과 비슷함 키와 밸류로 작성, 여러개 작성 가능 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher view	= request.getRequestDispatcher("/WEB-INF/views/country/list.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
