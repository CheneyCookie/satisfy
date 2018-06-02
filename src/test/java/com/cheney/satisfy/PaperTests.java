package com.cheney.satisfy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheney.satisfy.dao.PaperDao;
import com.cheney.satisfy.model.Paper;
import com.cheney.satisfy.model.Question;
import com.cheney.satisfy.service.PaperService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.cheney.satisfy.dao")
public class PaperTests {

    @Autowired
    PaperDao paperDao;
    @Autowired
    PaperService paperService;

    @Test
    public void getUserById() {
        Paper paper = paperDao.getById(1);
        System.out.println(paper);
    }

    @Test
    public void getQuestionByRandom() {
        List<Question> questions = paperDao.getQuestionByRandom(10);
        System.out.println(questions.size());
    }

    @Test
    public void generateExercisePaper() {
        Paper paper = new Paper();
        paper.setNumber(10);
        paper = paperService.generateExercisePaper(paper);

        System.out.println(paper);
    }
}
