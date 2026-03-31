package com.yse.app.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yse.app.util.DBConnection;

public class PeopleDAO {
	
	private DBConnection connection;
	
	public PeopleDAO() {
		
		this.connection = new DBConnection();
				
	}
	
	public int create(PeopleDTO peopleDTO) throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = """
				INSERT INTO PEOPLE(USER_NAME, USER_ID, USER_PW, USER_EMAIL) 
				VALUES(?, ? ,?, ?)
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, peopleDTO.getUserName());
		st.setString(2, peopleDTO.getUserId());
		st.setString(3, peopleDTO.getUserPw());
		st.setString(4, peopleDTO.getUserEmail());
		
		int result = st.executeUpdate(); //쿼리 실행 
		
		st.close();
		con.close();

        return result;
		
	}
	
	public PeopleDTO login(PeopleDTO peopleDTO) throws Exception {
		
		Connection con = connection.getConnection();
		String sql = """
				SELECT * FROM PEOPLE
				WHERE USER_ID = ? AND USER_PW = ?
				""";
		
		PreparedStatement st = con.prepareStatement(sql); //sql실행
		
		st.setString(1, peopleDTO.getUserId());
		st.setString(2, peopleDTO.getUserPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			peopleDTO.setUserName(rs.getString("USER_NAME"));
			peopleDTO.setUserId(rs.getString("USER_ID"));
			peopleDTO.setUserPw(rs.getString("USER_PW"));
			peopleDTO.setUserEmail(rs.getString("USER_EMAIL"));
			
			return peopleDTO;
		}
		return null;
		
	}
	

}
