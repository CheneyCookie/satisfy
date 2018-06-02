package com.cheney.satisfy.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cheney.satisfy.model.Answer;
import com.cheney.satisfy.model.Question;
import com.cheney.satisfy.service.QuestionService;

@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {

    @Override
    public Boolean addOne(Question question) {
        questionDao.addOne(question);
        question.setIsDeleted(false);
        question.setCreateTime(new Date());
        return questionDao.insertAnswers(question);
    }

    @Override
    public Boolean updateOne(Question question) {
        Boolean flag = false;
        flag = questionDao.updateOne(question);
        if (flag) {
            for (Answer answer : question.getAnswers()) {
                flag = questionDao.updateAnswer(answer);
            }
        }

        return flag;
    }
}
