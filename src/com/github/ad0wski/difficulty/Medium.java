package com.github.ad0wski.difficulty;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.priority.PriorityID;

import java.time.ZonedDateTime;

public class Medium extends Difficulty{
    public Medium(ZonedDateTime endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        super(endDate, categoryID, priorityID, difficultyID, title);
    }
}
