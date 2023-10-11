package com.github.ad0wski.category;

public enum CategoryID {
    SCHOOL(1),
    HOBBY(2),
    HOME(3);

    public final int index;
    private CategoryID(int index){
        this.index = index;
    }
}
