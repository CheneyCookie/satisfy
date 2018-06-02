package com.cheney.satisfy.dao;

import java.util.List;

import com.cheney.satisfy.model.Answer;
import com.cheney.satisfy.model.Paper;
import com.cheney.satisfy.model.Question;

public interface PaperDao extends BaseDao<Paper> {

    List<Question> getQuestionByRandom(int number);

    List<Answer> getAnswerByQuestion(int questionId);

    boolean insertPaperQuestion(int id, int questionId);

}
