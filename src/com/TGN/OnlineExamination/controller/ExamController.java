package com.TGN.OnlineExamination.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TGN.OnlineExamination.dao.QuestDao;
import com.TGN.OnlineExamination.dao.QuestDaoImpl;
import com.TGN.OnlineExamination.dao.UserDao;
import com.TGN.OnlineExamination.dao.UserDaoImp;
import com.TGN.OnlineExamination.dto.QuestDto;
import com.TGN.OnlineExamination.dto.UserDto;

@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestDto Qdto=new QuestDto();
	QuestDao Qdao=new QuestDaoImpl();
	UserDao dao = new UserDaoImp();
	UserDto udto = new UserDto();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String forward="";
	HttpSession session=request.getSession(false);
	String uname=(String) session.getAttribute("uname");

		udto=dao.GetUserDetailsByUsername(uname);
		for (QuestDto questDto: Qdao.getquestions(udto.getCourse())) {
			System.out.println(questDto.getQuestion());
		}
		request.setAttribute("questions",Qdao.getquestions(udto.getCourse()));
		forward="Questionpaper.jsp";
	RequestDispatcher rd = request.getRequestDispatcher(forward);

	rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
