package com.TGN.OnlineExamination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TGN.OnlineExamination.dao.UserDao;
import com.TGN.OnlineExamination.dao.UserDaoImp;
import com.TGN.OnlineExamination.dto.UserDto;

@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao udao = new UserDaoImp();
	UserDto udto = new UserDto();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String unaam = (String) session.getAttribute("uname");
		udto = udao.GetUserDetailsByUsername(unaam);
		System.out.println(udto.getUserName());
		String currentPass = request.getParameter("pass");
		String newPass = request.getParameter("newpass1");
		String confirmpass = request.getParameter("newpass2");
		if (udto.getPassword().equals(currentPass)) {
			if (newPass.equals(confirmpass)) {
				udao.updateUserPassword(newPass, unaam);
				RequestDispatcher rd = request.getRequestDispatcher("RegistationForm.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("resetPassword.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("resetPassword.jsp");
			rd.forward(request, response);
		}
	}

}
