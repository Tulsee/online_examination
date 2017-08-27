package com.TGN.OnlineExamination.dao;

import java.util.List;

import com.TGN.OnlineExamination.dto.Feedbackdto;

public interface Feedbackdao {
	public void savefeedback(Feedbackdto feedbackdto);

	public List<Feedbackdto> getallfeedback();

}
