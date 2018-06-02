package com.cheney.satisfy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String questionType;
    private List<Answer> answers;
    private Integer createBy;
    private Date createTime;
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", title=" + title + ", questionType="
                + questionType + ", answers=" + answers + ", createBy="
                + createBy + ", createTime=" + createTime + ", isDeleted="
                + isDeleted + "]";
    }
}
