package org.siit.week7.io;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class MainIO {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/in/aFile.txt");
        FileWriter fileWriter = new FileWriter("src/main/resources/out/aFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/in/aFile.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/out/aFile-buffered.txt"));

        printCopyTime("Simple file reader ", fileReader, fileWriter);
        printCopyTime("BufferedReader ", bufferedReader, bufferedWriter);

//        copyFile(null, null);
//        System.err.println("This is an error");
    }

    private static void copyFile(Reader fileReader, Writer fileWriter) throws IOException {
//        if(fileReader == null || fileWriter == null)
//        {
//            System.out.println("Invalid arguments");
//            return;
//        }

        try {
            int x = fileReader.read();
            while (x != -1) {
                fileWriter.write(x);
                x = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    private static void printCopyTime(String message, Reader fileReader, Writer fileWriter) throws IOException {
        Instant startTime = Instant.now();
        copyFile(fileReader, fileWriter);
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println(message + "duration was " + duration.toString());
    }
}