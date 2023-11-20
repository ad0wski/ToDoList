package com.github.ad0wski;

import com.github.ad0wski.attributes.CategoryID;
import com.github.ad0wski.attributes.DifficultyID;
import com.github.ad0wski.attributes.PriorityID;

import java.time.LocalDate;

public class Task {
    private int id;
    private LocalDate endDate;
    private CategoryID categoryID;
    private PriorityID priorityID;
    private DifficultyID difficultyID;
    private String title;

    public Task(LocalDate endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        this.endDate = endDate;
        this.categoryID = categoryID;
        this.priorityID = priorityID;
        this.difficultyID = difficultyID;
        this.title = title;
    }

    public Task(int id, LocalDate endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        this.id = id;
        this.endDate = endDate;
        this.categoryID = categoryID;
        this.priorityID = priorityID;
        this.difficultyID = difficultyID;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CategoryID getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryID categoryID) {
        this.categoryID = categoryID;
    }

    public PriorityID getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(PriorityID priorityID) {
        this.priorityID = priorityID;
    }

    public DifficultyID getDifficultyID() {
        return difficultyID;
    }

    public void setDifficultyID(DifficultyID difficultyID) {
        this.difficultyID = difficultyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return id +
                " " + endDate +
                " " + categoryID +
                " " + priorityID +
                " " + difficultyID +
                " " + title;
    }
}
