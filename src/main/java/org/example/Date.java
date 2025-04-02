package org.example;

import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo phiên bản tương thích khi gửi objec
    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Date() {}


//    public Date(Lunar lunar) {
//        this.day = lunar.lunarDay;
//        this.month = lunar.lunarMonth;
//        this.year = lunar.lunarYear;
//    }
//
//    public Date(Solar solar) {
//        this.day = solar.solarDay;
//        this.month = solar.solarMonth;
//        this.year = solar.solarYear;
//    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }


}
