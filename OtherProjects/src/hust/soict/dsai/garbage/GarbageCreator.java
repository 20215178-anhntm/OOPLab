package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "D:\\2023_2\\OOP-lab\\GIT\\Lab02\\OtherProjects\\test.exe";
        long startTime, endTime;

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            // Create garbage by concatenating bytes to a string
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken without optimization: " + (endTime - startTime) + " milliseconds");

            // Create garbage using StringBuffer
            startTime = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                stringBuffer.append((char) b);
            }
            String outputStringBuffer = stringBuffer.toString();
            endTime = System.currentTimeMillis();
            System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + " milliseconds");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
