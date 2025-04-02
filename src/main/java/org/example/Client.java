package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("1. Doi am thanh duong");
            System.out.println("2. Doi duong thanh am");

            int check = scanner.nextInt();
            Date date;

            if (check == 1) {
                System.out.printf("vui long nhap ngay: ");
                int day = scanner.nextInt();
                System.out.printf("vui long nhap thang: ");
                int month = scanner.nextInt();
                System.out.printf("vui long nhap nam: ");
                int year = scanner.nextInt();
                System.out.println("Co phai nam nhuan ko: ");
                System.out.println("1. Co: true");
                System.out.println("2. Khong: false");
                boolean isleap = scanner.nextBoolean();
                date = new Lunar(isleap, day, month, year);
            } else {
                System.out.printf("vui long nhap ngay: ");
                int day = scanner.nextInt();
                System.out.printf("vui long nhap thang: ");
                int month = scanner.nextInt();
                System.out.printf("vui long nhap nam: ");
                int year = scanner.nextInt();
                date = new Solar(day, month, year);
            }

            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());

            objectOutput.writeObject(date);
            System.out.println("Đã gửi: " + date);

            // Nhận phản hồi từ server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = input.readLine();
            System.out.println("Nhận từ server: " + response);

            // Đóng kết nối
            objectOutput.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
