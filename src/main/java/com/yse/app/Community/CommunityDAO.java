package com.yse.app.Community;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yse.app.util.DBConnection;

public class CommunityDAO {
	
	private DBConnection connection;
	
	public CommunityDAO() {
		
		this.connection = new DBConnection();
	}
	
	
	public int create(CommunityDTO dto) throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql="""
				INSERT INTO COMMUNITY (NUM, TITLE, NAME, CONTENTS, CREATE_TIME, STAR) 
				VALUES (COMMUNITY_SEQ.NEXTVAL, ?, ?, ?, sysdate, ? )
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getTitle());
		st.setString(2, dto.getName());
		st.setString(3, dto.getContents());
		st.setInt(4, dto.getStar());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	public CommunityDTO detail(long num) throws Exception {
		CommunityDTO dto = null;
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COMMUNITY WHERE NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto = new CommunityDTO();
			dto.setNum(rs.getLong("NUM"));
			dto.setTitle(rs.getString("TITLE"));
			dto.setName(rs.getNString("NAME"));
			dto.setContents(rs.getNString("CONTENTS"));
			dto.setCreateTime(rs.getDate("CREATE_TIME"));
			dto.setStar(rs.getInt("STAR"));
			
		}
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	public ArrayList<CommunityDTO> list() throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = """
				SELECT * FROM COMMUNITY
				ORDER BY NUM  DESC
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CommunityDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			CommunityDTO dto = new CommunityDTO();
			long no = rs.getInt("NUM");
			String tt = rs.getString("TITLE");
			String n = rs.getString("NAME");
			String c = rs.getString("CONTENTS");
			Date ct = rs.getDate("CREATE_TIME");
			int s = rs.getInt("STAR");
			
			dto.setNum(no);
			dto.setTitle(tt);
			dto.setName(n);
			dto.setContents(c);
			dto.setCreateTime(ct);
			dto.setStar(s);
			
			ar.add(dto);
			
			
		}
		
		rs.close();
		st.close();
		con.close();
		return ar;
		
	}

}
