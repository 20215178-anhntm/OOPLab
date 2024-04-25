package hust.soict.dsai.garbage;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "D:\\2023_2\\OOP-lab\\GIT\\Lab02\\OtherProjects\\test.exe";
        long startTime, endTime;

        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.currentTimeMillis();
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] inputBytes = baos.toByteArray();
            endTime = System.currentTimeMillis();
            System.out.println("Time taken without creating garbage: " + (endTime - startTime) + " milliseconds");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

