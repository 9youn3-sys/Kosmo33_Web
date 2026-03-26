package com.yse.app.countries;

import java.beans.ParameterDescriptor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yse.app.departments.DepartmentDTO;
import com.yse.app.util.DBConnection;

public class CountryDAO {
	private DBConnection connection;
	
	public CountryDAO() {
		this.connection = new DBConnection();
	}
	
	public int create(CountryDTO countryDTO) throws Exception {
		//홈페이지에 create 되게 만들기 
		//REGION_ID는 부모값을 넣어야함 

//1. DAO에 creat메서드 생성
//2. coun패키지 create 컨트롤러 만들기 
//3. create.jsp
		
		
		//1. DB연결
		Connection con = connection.getConnection();
		
		
		//2. 쿼리문 작성 
		String sql = """
				
					INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID)
					VALUES (?, ?, ?)
					""";
		
		
		//3. 쿼리문 미리 보내기 
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ??값 세팅 (없으면 패스)
		//아래 코드 설명 : st에서 스트링 타입으로 넣자 1번칸에 DTO에 있는 네임을 가져와서
		st.setString(1, countryDTO.getCountryId());
		st.setString(2, countryDTO.getCountryName());
		st.setInt(3, countryDTO.getRegionId());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	public void detail()throws Exception{
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID='US'";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("COUNTRY_NAME");
			System.out.println(name);
		}else {
			System.out.println("없다");
		}
		
		rs.close();
		st.close();
		con.close();
	}
	
	
	public ArrayList<CountryDTO> list() throws Exception {
		DBConnection connection = new DBConnection();
		
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CountryDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			
			CountryDTO dto = new CountryDTO();
			
			String name = rs.getString("COUNTRY_NAME");
			String id = rs.getString("COUNTRY_ID");
			int ri = rs.getInt("REGION_ID");
			
			ar.add(dto);
			
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}

}
