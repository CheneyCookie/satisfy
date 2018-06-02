package com.cheney.satisfy.dao;

import com.cheney.satisfy.model.Answer;
import com.cheney.satisfy.model.Question;

public interface QuestionDao extends BaseDao<Question> {

    public Question getByTitle(String title);

    public boolean insertAnswers(Question question);

    public boolean updateAnswer(Answer answer);
}
