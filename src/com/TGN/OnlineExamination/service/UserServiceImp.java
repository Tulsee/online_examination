package com.TGN.OnlineExamination.service;

import com.TGN.OnlineExamination.dao.UserDao;
import com.TGN.OnlineExamination.dao.UserDaoImp;
import com.TGN.OnlineExamination.dto.UserDto;

public class UserServiceImp implements UserService{
	private UserDao dao;

	public UserServiceImp() {
		dao = new UserDaoImp();
	}
	public void SaveUserInfo(UserDto udto){
		dao.SaveUserInfo(udto);
	}

}
