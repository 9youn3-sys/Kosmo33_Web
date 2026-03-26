package com.yse.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yse.app.util.DBConnection;


	
	public class DepartmentDAO {
		private DBConnection connection;
		
		
		
		public DepartmentDAO() {
			this.connection = new DBConnection();
		}
		
		
		public int create(DepartmentDTO departmentDTO) throws Exception {
			            //매개변수 DepartmentDTO 넣은 이유: 
			            // ? 값이 추가 될 수 있으니 정보를 모아놓은 DTO를 넣는다
			//외부에서 만든 데이터를 DAO로 전달하기 위해서
			//DTO를 매개변수로 받는 이유 = DB에 넣을 데이터를 전달받기 위해서
			
			Connection con = connection.getConnection();
			String sql="""
					
					INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
					VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?,?,?)
					
					""";
			//쿼리문 미리 보내기 
			PreparedStatement st = con.prepareStatement(sql);
			
			//?값 세팅 
			st.setString(1, departmentDTO.getDepartmentName());
			//st에서 스트링 타입으로 넣자 1번칸에 DTO에 있는 네임을 가져와서 
			st.setInt(2, departmentDTO.getManagerId());
			st.setInt(3, departmentDTO.getLocationId());
			
			//SELECT는 신호 보내면 응답해서 정보를 줘서 리설트셋에 저장하지만 숫자로 정보를 주기 때문에 앞에 int를 붙인다.
			//INSERT는 정보가 아닌 성공하면 1 실패하면 0을 줌 
			int result = st.executeUpdate();
			//리설트가 0이면 실패 1이면 성공
			
		
			
			st.close();
			con.close();
			
			return result;
			//result로 리턴하고 result가 선언된 타입은 int이기때문에 public 뒤에 int로 바꿈
			
		}
	
	                  //?값을 st.~~로 세팅하고 매개변수 적어줌 (int또는 String ~~)
		public DepartmentDTO detail(int departmentId) throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//? 세팅
		st.setInt(1, departmentId);
		
		ResultSet rs = st.executeQuery();
		DepartmentDTO dto=null;
		if(rs.next()) {
			dto = new DepartmentDTO();
			
			
			dto.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
			
			dto.setManagerId(rs.getInt("MANAGER_ID"));
			dto.setLocationId(rs.getInt("LOCATION_ID"));
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dto;
		
	}
	
	public ArrayList<DepartmentDTO> list() throws Exception {
		//1. DB연결
		
		Connection con = connection.getConnection();
		
		//2. 쿼리문 작성
		String sql =""" 
				SELECT * FROM DEPARTMENTS
				ORDER BY DEPARTMENT_ID DESC
				""";
				
		
		//3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값을 세팅
		
		//5. 최종전송 및 결과처리
		ResultSet rs = st.executeQuery();
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			String name = rs.getString("DEPARTMENT_NAME");
			int id= rs.getInt("DEPARTMENT_ID");
			int mid = rs.getInt("MANAGER_ID");
			int lid = rs.getInt("LOCATION_ID");
			
			dto.setDepartmentName(name);
			dto.setDepartmentId(id);
			dto.setManagerId(mid);
			dto.setLocationId(lid);
			
			ar.add(dto);
			
		}
		
		//6. 연결 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}

}