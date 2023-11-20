package com.github.ad0wski.attributes;

public enum DifficultyID {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    public final int index;
    private DifficultyID(int index){
        this.index = index;
    }
}
