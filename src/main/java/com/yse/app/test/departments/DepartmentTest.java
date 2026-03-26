package com.yse.app.test.departments;

import com.yse.app.departments.DepartmentDAO;
import com.yse.app.departments.DepartmentDTO;

public class DepartmentTest {

	public static void main(String[] args) {
		
		DepartmentDAO dao = new DepartmentDAO();
		try {
              
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartmentName("Class3");
			departmentDTO.setManagerId(null);
			departmentDTO.setLocationId(null);
			dao.create(departmentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
