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
import com.TGN.OnlineExamination.utility.EmailUtility;

@WebServlet("/ResultController")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao dao = new UserDaoImp();
	UserDto udto = new UserDto();
	QuestDto qdto = new QuestDto();
	QuestDao Qdao = new QuestDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String uname = (String) session.getAttribute("uname");
		int i = 0;
		String quest;
		udto = dao.GetUserDetailsByUsername(uname);
		for (QuestDto questDto : Qdao.getquestions(udto.getCourse())) {
			quest = questDto.getQuestion();
			qdto = Qdao.getAnswer(quest);

			if (request.getParameter(quest).equals(qdto.getCorrect())) {
				i++;
			}
		}
		EmailUtility.sendScore(udto.getEmail(), i);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

}
