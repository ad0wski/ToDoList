package com.github.ad0wski.attributes;

public enum PriorityID {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    public final int index;
    private PriorityID(int index){
        this.index = index;
    }
}
