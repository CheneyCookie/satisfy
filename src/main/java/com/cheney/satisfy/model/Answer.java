package com.cheney.satisfy.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String content;
    private Boolean rightAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", content=" + content + ", rightAnswer="
                + rightAnswer + "]";
    }
}
