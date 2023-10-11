package com.github.ad0wski.priority;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;

import java.time.ZonedDateTime;

public class Medium extends Priority{
    public Medium(ZonedDateTime endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        super(endDate, categoryID, priorityID, difficultyID, title);
    }
}
