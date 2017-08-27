package com.TGN.OnlineExamination.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.TGN.OnlineExamination.dao.UserDao;
import com.TGN.OnlineExamination.dao.UserDaoImp;
import com.TGN.OnlineExamination.dto.UserDto;
import com.TGN.OnlineExamination.utility.EmailUtility;

@WebServlet("/NewUser")
@MultipartConfig(maxFileSize = 16177215)
public class NewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPLOAD_DIR = "userProfilepicforonexam";
	UserDao dao = new UserDaoImp();
	UserDto udto = new UserDto();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadFilePath = "C:/Users/tulsee/Desktop/" + File.separator + UPLOAD_DIR;
		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		Part filePart = request.getPart("file");
		System.out.println(filePart);
		String imageUrl = writeImageToFile(filePart, uploadFilePath + File.separator + getFileName(filePart));

		// first_name,last_name,user_name,password,dob,"
		// + "gender,email,phone_number,address,course,image
		udto.setFirstName(request.getParameter("First_Name"));
		udto.setLastName(request.getParameter("last_Name"));
		udto.setUserName(request.getParameter("user_Name"));
		udto.setPassword(request.getParameter("password"));
		String Day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("years");
		String dob = Day + "/" + month + "/" + year;
		udto.setDob(dob);
		udto.setGender(request.getParameter("radio"));
		udto.setEmail(request.getParameter("mail"));
		udto.setPhone(request.getParameter("phone"));
		udto.setAddress(request.getParameter("address"));
		udto.setCourse(request.getParameter("radio1"));
		udto.setImage(imageUrl);
		dao.SaveUserInfo(udto);
		EmailUtility.sendEmail(udto.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("RegistationForm.jsp");
		rd.forward(request, response);

	}

	private String writeImageToFile(Part filePart, String imageUrl) throws IOException {
		OutputStream out = null;
		InputStream filecontent = null;
		try {
			out = new FileOutputStream(new File(imageUrl));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
		return imageUrl;
	}

	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
