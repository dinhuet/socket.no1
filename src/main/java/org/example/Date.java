package org.example;

import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo phiên bản tương thích khi gửi objec
    public int day;
    public int month;
    public int year;
}
