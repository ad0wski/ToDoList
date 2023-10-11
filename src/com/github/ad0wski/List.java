package com.github.ad0wski;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.time.ZonedDateTime;

public interface List {
    ZonedDateTime getEndDate();
    CategoryID getCategory();
    PriorityID getPriority();
    DifficultyID getDifficulty();
    String title();
}
