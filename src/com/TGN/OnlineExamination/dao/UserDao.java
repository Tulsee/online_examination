package com.TGN.OnlineExamination.dao;

import com.TGN.OnlineExamination.dto.UserDto;

public interface UserDao {
	public void SaveUserInfo(UserDto udto);

	public UserDto GetUserDetailsByUsername(String username);
	public void updateUserPassword(String pass,String user);
}
