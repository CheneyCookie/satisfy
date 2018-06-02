package com.cheney.satisfy.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.satisfy.model.Question;
import com.cheney.satisfy.service.QuestionService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    public QuestionService questionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageInfo<Question> listQuestion(PageInfo<Question> pageInfo) {
        return questionService.getByPage(pageInfo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Question getById(@PathVariable Integer id) {
        return questionService.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Boolean createQuestion(@RequestBody Question question) {
        question.setCreateTime(new Date());
        question.setIsDeleted(false);
        return questionService.addOne(question);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Boolean updateQuestion(@RequestBody Question question) {
        return questionService.updateOne(question);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Boolean deleteQuestion(@PathVariable("id") Integer id) {
        System.out.println(id);
        return questionService.deleteById(id);
    }

}
