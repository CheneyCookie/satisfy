package com.cheney.satisfy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheney.satisfy.dao.QuestionDao;
import com.cheney.satisfy.model.Answer;
import com.cheney.satisfy.model.Question;
import com.cheney.satisfy.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.cheney.satisfy.dao")
public class QuestionTests {

    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuestionService questionService;

    @Test
    public void getUserById() {
        Question question = questionDao.getById(1);
        System.out.println(question);
    }

    @Test
    public void getUserByTitle() {
        Question question = questionDao.getByTitle("你");
        System.out.println(question);
    }

    @Test
    public void getUserByPage() throws JsonProcessingException {
        PageInfo<Question> pageInfo = new PageInfo<Question>();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(2);
        pageInfo = questionService.getByPage(pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(pageInfo);
        System.out.println(writeValueAsString);
    }

    @Test
    public void addOne() {
        Question question = new Question();
        question.setTitle("呃呃呃21");
        Answer answer1 = new Answer();
        answer1.setContent("123");
        answer1.setRightAnswer(true);
        Answer answer2 = new Answer();
        answer2.setContent("456");
        answer2.setRightAnswer(false);
        Answer answer3 = new Answer();
        answer3.setContent("789");
        answer3.setRightAnswer(false);
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        question.setAnswers(answers);
        Boolean flag = questionService.addOne(question);
        System.out.println(flag);
    }

    @Test
    public void updateOne() {
        Question question = questionService.getById(9);
        System.out.println(question);
        List<Answer> answers = question.getAnswers();
        question.setTitle("呃呃呃2122");
        Answer answer1 = answers.get(0);
        answer1.setContent("1231");
        answer1.setRightAnswer(true);
        Answer answer2 = answers.get(1);
        answer2.setContent("4564");
        answer2.setRightAnswer(false);
        Answer answer3 = answers.get(2);
        answer3.setContent("7897");
        answer3.setRightAnswer(false);
        Boolean flag = questionService.updateOne(question);
        System.out.println(flag);
    }

    @Test
    public void deleteQuestion() {
        int id = 1;
        Boolean flag = questionService.deleteById(id);
        System.out.println(flag);
    }
}
