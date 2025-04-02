package org.example;

import java.io.Serializable;

class Solar extends Date implements Serializable {
    private static final long serialVersionUID = 1L;
    public Solar() {
        super();
    }

    public Solar(int solarDay, int solarMonth, int solarYear) {
        this.day = solarDay;
        this.month = solarMonth;
        this.year = solarYear;
    }

    @Override
    public String toString() {
        return "Solar{" +
                "solarDay=" + day +
                ", solarMonth=" + month +
                ", solarYear=" + year +
                '}';
    }
}