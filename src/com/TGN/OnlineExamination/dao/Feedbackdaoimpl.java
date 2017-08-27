package com.TGN.OnlineExamination.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.TGN.OnlineExamination.dto.Feedbackdto;
import com.TGN.OnlineExamination.utility.Dbutility;
import com.TGN.OnlineExamination.utility.Query;

public class Feedbackdaoimpl implements Feedbackdao {
	PreparedStatement ps = null;

	public void savefeedback(Feedbackdto fdto) {
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.INSERT_FEEDBACK);
			ps.setString(1, fdto.getFeedback());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Feedbackdto> getallfeedback() {
		List<Feedbackdto> fdto = new ArrayList<>();
		try {
			ps = Dbutility.getconnection().prepareStatement(Query.GET_ALL_FEEDBACK);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Feedbackdto feedbackdto = new Feedbackdto();
				feedbackdto.setFeedback(rs.getString("ufeedback"));
				fdto.add(feedbackdto);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return fdto;
	}

}
