package org.example;

import java.io.Serializable;

class Lunar extends Date implements Serializable {
    private static final long serialVersionUID = 1L;
    public boolean isleap;

    public Lunar(boolean isleap, int lunarDay, int lunarMonth, int lunarYear) {
        super();
        this.isleap = isleap;
        this.day = lunarDay;
        this.month = lunarMonth;
        this.year = lunarYear;
    }

    public Lunar() {
        super();
    }

    @Override
    public String toString() {
        return "Lunar{" +
                "isleap=" + isleap +
                ", lunarDay=" + day +
                ", lunarMonth=" + month +
                ", lunarYear=" + year +
                '}';
    }
}