package com.github.ad0wski.priority;

import com.github.ad0wski.List;
import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;

import java.time.ZonedDateTime;

public class Priority implements List {
    private ZonedDateTime endDate;
    private CategoryID categoryID;
    private PriorityID priorityID;
    private DifficultyID difficultyID;
    private String title;

    public Priority(ZonedDateTime endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        this.endDate = endDate;
        this.categoryID = categoryID;
        this.priorityID = priorityID;
        this.difficultyID = difficultyID;
        this.title = title;
    }

    public void setEndDate(ZonedDateTime endDate) {
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
        return "Priority{" +
                "endDate=" + endDate +
                ", categoryID=" + categoryID +
                ", priorityID=" + priorityID +
                ", difficultyID=" + difficultyID +
                ", title='" + title + '\'' +
                '}';
    }

    //----------------------------
    @Override
    public ZonedDateTime getEndDate() {
        return null;
    }

    @Override
    public CategoryID getCategory() {
        return null;
    }

    @Override
    public PriorityID getPriority() {
        return null;
    }

    @Override
    public DifficultyID getDifficulty() {
        return null;
    }

    @Override
    public String title() {
        return null;
    }
}
