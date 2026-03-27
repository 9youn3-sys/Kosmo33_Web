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
	
	public ArrayList<CommunityDTO> list() throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = """
				SELECT * FROM COMMUNITY
				ORDER BY NUM  DESC;
				""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CommunityDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			CommunityDTO dto = new CommunityDTO();
			int no = rs.getInt("NUM");
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
