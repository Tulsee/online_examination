package com.TGN.OnlineExamination.controller;

import java.io.IOException;

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

/**
 * Servlet implementation class QuestController
 */
@WebServlet("/QuestController")
	public class QuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestDto Qdto=new QuestDto();
	QuestDao Qdao=new QuestDaoImpl();
	UserDao dao = new UserDaoImp();
	UserDto udto = new UserDto();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action=request.getParameter("action");
	HttpSession session=request.getSession(false);
	String uname=(String) session.getAttribute("uname");
	System.out.println(uname);
	udto=dao.GetUserDetailsByUsername(uname);
	String forward="Home.jsp";
	if((udto.getUserName().equalsIgnoreCase("dinesh"))&&(udto.getPassword().equals("qwerty"))){
		forward="Newquestion.jsp";
	}
	RequestDispatcher rd = request.getRequestDispatcher(forward);

	rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Qdto.setQuestion(request.getParameter("Question"));
		Qdto.setOption1(request.getParameter("opt1"));
		Qdto.setOption2(request.getParameter("opt2"));
		Qdto.setOption3(request.getParameter("opt3"));
		Qdto.setOption4(request.getParameter("opt4"));
		Qdto.setCorrect(request.getParameter("correct"));
		Qdto.setCourse(request.getParameter("faculty"));
		Qdao.savequest(Qdto);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");

		rd.forward(request, response);
	}

}
