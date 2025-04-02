package org.example;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server đang chờ kết nối...");
            Socket socket = serverSocket.accept();
            System.out.println("Client đã kết nối!");

            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            Date receivedDate = (Date) objectInput.readObject(); // Ép kiểu về Date
            System.out.println("Nhận được từ client: " + receivedDate);

            Date changedDate;

            if (receivedDate instanceof Lunar) {
                changedDate = LunarSolarConverter.LunarToSolar((Lunar) receivedDate);
            } else {
                Lunar newDate = LunarSolarConverter.SolarToLunar((Solar) receivedDate);
                if (newDate.year % 4 == 0 && newDate.year % 400 != 0) {
                    newDate.isleap = true;
                }
                changedDate = newDate;
            }

            // Xử lý dữ liệu (Ví dụ: phản hồi lại cho Client)
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Server đã nhận: " + changedDate);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

