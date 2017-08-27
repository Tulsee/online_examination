package com.TGN.OnlineExamination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TGN.OnlineExamination.dao.UserDao;
import com.TGN.OnlineExamination.dao.UserDaoImp;
import com.TGN.OnlineExamination.dto.UserDto;
import com.TGN.OnlineExamination.utility.EmailUtility;

@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDto uDto = new UserDto();
	UserDao dao = new UserDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		System.out.println(userName + " " + email);
		uDto = dao.GetUserDetailsByUsername(userName);
		System.out.println(uDto.getUserName() + " " + uDto.getEmail());
		if (uDto.getUserName() == null || !uDto.getEmail().equals(email)||(uDto.getEmail().equals("aryaldinesh09@gmail.com"))) {
			RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
			rd.forward(request, response);
		} else if (uDto.getEmail().equals(email)) {
			EmailUtility.sendNewPassword(uDto.getUserName(), uDto.getEmail());
			RequestDispatcher rd = request.getRequestDispatcher("RegistationForm.jsp");
			rd.forward(request, response);
		}
	}

}
