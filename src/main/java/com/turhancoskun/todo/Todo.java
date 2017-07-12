package com.turhancoskun.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document
public class Todo {

    @Id
    private BigInteger id;

    private String title;

    private boolean completed;

    private Date createdDate;

    private Date completedDate;

    public Todo(String title) {
        this.title = title;
        this.createdDate = new Date();
    }

    public Todo() {
    }

    public Todo complete() {
        this.setCompleted(true);
        this.setCompletedDate(new Date());
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
