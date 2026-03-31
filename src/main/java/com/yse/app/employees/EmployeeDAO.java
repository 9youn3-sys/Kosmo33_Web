package com.yse.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yse.app.util.DBConnection;

public class EmployeeDAO {
	
	private DBConnection connecion; //pirivate
	
	public EmployeeDAO() {
		
		this.connecion = new DBConnection();
	}
	
	//로그인을 검증하는 메서드 
	public EmployeeDTO login(EmployeeDTO employeeDTO)throws Exception{
		
		Connection con = connecion.getConnection();
		String sql = """
				SELECT * FROM EMPLOYEES
				WHERE EMPLOYEE_ID=?AND PASSWORD=?
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployeeId()); //?값 설정
		st.setString(2, employeeDTO.getPassword()); //?값 설정 employeeDTO에서 패스워드를 가져오자
		
		ResultSet rs = st.executeQuery(); //쿼리 실행 
		
		if(rs.next()) { //로그인 성공, rs.next()는 결과셋에서 다음 행이 있는지 확인하는 메서드로, 로그인 성공 여부를 판단하는 데 사용된다.
			employeeDTO.setFirstName(rs.getString("FIRST_NAME"));
			employeeDTO.setLastName(rs.getString("LAST_NAME"));
			employeeDTO.setHireDate(rs.getDate("HIRE_DATE"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setDpartmentId(rs.getInt("DEPARTMENT_ID"));
			
			return employeeDTO; //찾으면 employeeDTO를 리턴한다.
			
		}
		
		return null; //못찾으면 널을 리턴한다.
	}

}
