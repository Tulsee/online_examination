package com.TGN.OnlineExamination.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.TGN.OnlineExamination.dto.UserDto;
import com.TGN.OnlineExamination.utility.Dbutility;
import com.TGN.OnlineExamination.utility.Query;

public class UserDaoImp implements UserDao {
	PreparedStatement ps = null;

	public void SaveUserInfo(UserDto udto) {
		// first_name,last_name,user_name,password,dob,"
		// + "gender,email,phone_number,address,course,image
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.CREATE_STUDENT);
			ps.setString(1, udto.getFirstName());
			ps.setString(2, udto.getLastName());
			ps.setString(3, udto.getUserName());
			ps.setString(4, udto.getPassword());
			ps.setString(5, udto.getDob());
			ps.setString(6, udto.getGender());
			ps.setString(7, udto.getEmail());
			ps.setString(8, udto.getPhone());
			ps.setString(9, udto.getAddress());
			ps.setString(10, udto.getCourse());
			ps.setString(11, udto.getImage());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public UserDto GetUserDetailsByUsername(String username) {
		UserDto udto = new UserDto();
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.Get_detail);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				udto.setFirstName(rs.getString("first_name"));
				udto.setLastName(rs.getString("last_name"));
				udto.setUserName(rs.getString("user_name"));
				udto.setPassword(rs.getString("password"));
				udto.setDob(rs.getString("dob"));
				udto.setGender(rs.getString("gender"));
				udto.setEmail(rs.getString("email"));
				udto.setPhone(rs.getString("phone_number"));
				udto.setAddress(rs.getString("address"));
				udto.setCourse(rs.getString("course"));
				udto.setImage(rs.getString("image"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return udto;
	}
	public void updateUserPassword(String pass,String user) {
		try {
		ps=Dbutility.getconnection().prepareStatement(Query.UPDATE_PASSWORD);
		ps.setString(1, pass);
		ps.setString(2, user);
		ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
