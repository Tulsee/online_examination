package com.TGN.OnlineExamination.utility;

public class Query {
	public static final String CREATE_STUDENT = "insert into user_details(first_name,last_name,user_name,password,dob,"
			+ "gender,email,phone_number,address,course,image) value(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String Get_detail = "select * from user_details where user_name=?";
	public static final String UPDATE_PASSWORD = "update user_details set password=? where user_name=?";
	
	//////////////////feedback//////////////
	public static String INSERT_FEEDBACK="insert into feedback(ufeedback) values(?)";
	public static String GET_ALL_FEEDBACK="select * from feedback";
	////////////////////////////Question//////////////////////////////
	public static final String CREATE_QUESTION="insert into question(Questions,opt1,opt2,opt3,opt4,correct,course) values(?,?,?,?,?,?,?)";
	public static final String GET_QUESTION="select * from question where course=?";	
	public static final String GET_ANSWER="select * from question where Questions=?";
}
