package com.TGN.OnlineExamination.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TGN.OnlineExamination.dto.QuestDto;
import com.TGN.OnlineExamination.utility.Dbutility;
import com.TGN.OnlineExamination.utility.Query;

public class QuestDaoImpl implements QuestDao {

	PreparedStatement ps = null;

	public void savequest(QuestDto Qdto) {
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.CREATE_QUESTION);
			ps.setString(1, Qdto.getQuestion());
			ps.setString(2, Qdto.getOption1());
			ps.setString(3, Qdto.getOption2());
			ps.setString(4, Qdto.getOption3());
			ps.setString(5, Qdto.getOption4());
			ps.setString(6, Qdto.getCorrect());
			ps.setString(7, Qdto.getCourse());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<QuestDto> getquestions(String course) {
		List<QuestDto> qdtolist = new ArrayList<>();
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.GET_QUESTION);
			ps.setString(1, course);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				QuestDto qdto = new QuestDto();
				qdto.setQuestion(rs.getString("Questions"));
				qdto.setOption1(rs.getString("opt1"));
				qdto.setOption2(rs.getString("opt2"));
				qdto.setOption3(rs.getString("opt3"));
				qdto.setOption4(rs.getString("opt4"));
				qdto.setCorrect(rs.getString("correct"));
				qdto.setCourse(rs.getString("course"));
				qdtolist.add(qdto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return qdtolist;
	}

	public QuestDto getAnswer(String quest) {
		QuestDto qdto = new QuestDto();
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.GET_ANSWER);
			ps.setString(1, quest);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				qdto.setCorrect(rs.getString("correct"));
	}

}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			return qdto;
}
}
