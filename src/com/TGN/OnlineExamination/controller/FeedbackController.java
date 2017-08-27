package com.TGN.OnlineExamination.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TGN.OnlineExamination.dao.Feedbackdao;
import com.TGN.OnlineExamination.dao.Feedbackdaoimpl;
import com.TGN.OnlineExamination.dto.Feedbackdto;

@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Feedbackdto fdto = new Feedbackdto();
	Feedbackdao fdao = new Feedbackdaoimpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session1=request.getSession(false);
		String uname=(String) session1.getAttribute("uname");
		String feed=uname+":"+request.getParameter("infeedbck");
		fdto.setFeedback(feed);

		fdao.savefeedback(fdto);
		List<Feedbackdto> fdtolist = fdao.getallfeedback();

		request.setAttribute("feedbacks", fdtolist);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
		rd.include(request, response);
	}
}
