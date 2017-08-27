package com.TGN.OnlineExamination.dao;

import java.util.List;

import com.TGN.OnlineExamination.dto.QuestDto;

public interface QuestDao {
	public void savequest(QuestDto Qdto);
	public List<QuestDto> getquestions(String course);
	public QuestDto getAnswer(String quest);

}
