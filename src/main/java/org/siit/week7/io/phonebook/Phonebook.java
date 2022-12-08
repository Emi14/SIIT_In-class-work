package org.siit.week7.io.phonebook;

import org.siit.week7.io.phonebook.exception.NameNotFoundInPhonebookException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given the file src/main/resources/in/phonebook.txt representing a phonebook,
 * create a program to receive a name from keyboard and display the corresponding phone number on console.
 * If the name is not present in the file, a custom exception should be thrown while the user should receive an appropriate message.
 * <p>
 * Exceptions should be logged in a .log file.
 */
public class Phonebook {

    public static final String INVALID_FILE_NAME = "The given file name is invalid.";
    public static final String TERMINATE_SEARCH = "TERMINATE";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Phonebook.class.getName());

        Map<String, String> phonebook = readPhonebookFile("src/main/resources/in/phonebook.txt");
        try (Scanner scanner = new Scanner(System.in)) {
            String inputName = scanner.next();
            while (!inputName.equals(TERMINATE_SEARCH)) {
                try {
                    System.out.println(searchInPhonebook(phonebook, inputName));
                } catch (NameNotFoundInPhonebookException e) {
                    logger.log(Level.SEVERE, e.getMessage(), e.getCause());
                }
                inputName = scanner.next();
            }
        }
    }

    public static String searchInPhonebook(Map<String, String> phonebook, String inputName) throws NameNotFoundInPhonebookException {
        String phoneNumber = phonebook.get(inputName);
        if (phoneNumber == null) {
            throw new NameNotFoundInPhonebookException("The given name is not found in the phonebook");
        }
        return phoneNumber;
    }

    public static Map<String, String> readPhonebookFile(String filePath) {
        Map<String, String> phonebook = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(" "); // TODO find a regex suitable for this one
                int length = words.length;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < length - 1; i++) {
                    stringBuffer.append(words[i]).append(" ");
                }
                phonebook.put(stringBuffer.toString().trim(), words[length - 1]);
            }
        } catch (IOException e) {
            System.out.println("The phonebook file could not be found.");
            throw new RuntimeException(INVALID_FILE_NAME);
        }

        return phonebook;
    }

}