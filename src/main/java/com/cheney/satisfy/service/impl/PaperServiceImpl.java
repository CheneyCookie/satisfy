package com.cheney.satisfy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cheney.satisfy.model.Answer;
import com.cheney.satisfy.model.Paper;
import com.cheney.satisfy.model.Question;
import com.cheney.satisfy.service.PaperService;

@Service("paperService")
public class PaperServiceImpl extends BaseServiceImpl<Paper> implements PaperService {

    @Override
    public Paper generateExercisePaper(Paper paper) {
        List<Question> questions = paperDao.getQuestionByRandom(paper.getNumber());
        for (Question question : questions) {
            System.out.println(question);
            List<Answer> answers = paperDao.getAnswerByQuestion(question.getId());
            question.setAnswers(answers);
        }
        paper.setQuestions(questions);
        paper.setName("exercise" + new Date().toString());

        paperDao.addOne(paper);
        System.out.println(paper.getId());
        for (Question question : questions) {
            paperDao.insertPaperQuestion(paper.getId(), question.getId());
        }

        return paper;
    }
}
