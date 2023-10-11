package com.github.ad0wski.category;

import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.time.ZonedDateTime;

public class Home extends Category{

    public Home(ZonedDateTime endDate, CategoryID categoryID, PriorityID priorityID, DifficultyID difficultyID, String title) {
        super(endDate, categoryID, priorityID, difficultyID, title);
    }
}
