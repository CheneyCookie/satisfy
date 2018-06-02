package com.cheney.satisfy.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.satisfy.model.Paper;
import com.cheney.satisfy.model.User;
import com.cheney.satisfy.service.PaperService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    public PaperService paperService;

    @RequestMapping(value = "/special", method = RequestMethod.POST)
    public Paper generateExercisePaper(@RequestBody Paper paper, HttpSession session) {
        User user = (User) session.getAttribute("user");
        paper.setIsDeleted(false);
        paper.setCreateTime(new Date());
        paper.setCreateBy(user.getId());

        return paperService.generateExercisePaper(paper);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Paper getById(@PathVariable Integer id) {
        return paperService.getById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageInfo<Paper> listPaper(PageInfo<Paper> pageInfo) {
        return paperService.getByPage(pageInfo);
    }

}
