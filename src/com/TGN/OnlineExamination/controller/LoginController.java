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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDto udto = new UserDto();

		String userName = request.getParameter("use_name");
		HttpSession session=request.getSession(true);
		session.setAttribute("uname", userName);
		
		String pass = request.getParameter("pass");
		udto = dao.GetUserDetailsByUsername(userName);
		if (udto.getUserName() == null) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistationForm.jsp");
			rd.forward(request, response);
		} else if (udto.getPassword().equalsIgnoreCase(pass) && udto.getUserName().equalsIgnoreCase(userName)) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		} else if (udto.getPassword() != pass) {
			RequestDispatcher rd = request.getRequestDispatcher("RegistationForm.jsp");
			rd.forward(request, response);
		}

	}

}
