package com.github.ad0wski;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Task {
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
        return "Task{" +
                "endDate=" + endDate +
                ", categoryID=" + categoryID +
                ", priorityID=" + priorityID +
                ", difficultyID=" + difficultyID +
                ", title='" + title + '\'' +
                '}';
    }
}
