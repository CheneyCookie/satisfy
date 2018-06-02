package com.cheney.satisfy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private List<Paper> papers;
    private List<String> examinneEmails;
    private List<User> examinerEmails;
    private Date stratTime;
    private Date endTime;
    private Boolean openMonitor;
    private Boolean forbidSwitchPage;
    private Integer createBy;
    private Date createTime;
    private Boolean isDeleted;
    private Long duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Paper> getPaper() {
        return papers;
    }

    public void setPaperParts(List<Paper> papers) {
        this.papers = papers;
    }

    public List<String> getExaminneEmails() {
        return examinneEmails;
    }

    public void setExaminneEmails(List<String> examinneEmails) {
        this.examinneEmails = examinneEmails;
    }

    public List<User> getExaminerEmails() {
        return examinerEmails;
    }

    public void setExaminerEmails(List<User> examinerEmails) {
        this.examinerEmails = examinerEmails;
    }

    public Date getStratTime() {
        return stratTime;
    }

    public void setStratTime(Date stratTime) {
        this.stratTime = stratTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getOpenMonitor() {
        return openMonitor;
    }

    public void setOpenMonitor(Boolean openMonitor) {
        this.openMonitor = openMonitor;
    }

    public Boolean getForbidSwitchPage() {
        return forbidSwitchPage;
    }

    public void setForbidSwitchPage(Boolean forbidSwitchPage) {
        this.forbidSwitchPage = forbidSwitchPage;
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

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exam [id=" + id + ", name=" + name + ", papers="
                + papers + ", examinneEmails=" + examinneEmails
                + ", examinerEmails=" + examinerEmails + ", stratTime="
                + stratTime + ", endTime=" + endTime + ", openMonitor="
                + openMonitor + ", forbidSwitchPage=" + forbidSwitchPage
                + ", createBy=" + createBy + ", createTime=" + createTime
                + ", isDeleted=" + isDeleted + "]";
    }
}
