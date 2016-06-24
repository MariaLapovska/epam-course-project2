package com.epam.view;

/**
 * View class
 */
public class View {

    public static final String WORDS = "Words of text divided by sentences:";
    public static final String RESULT = "Unique words from %d sentence:";

    /**
     * Outputs messages
     * @param messages Messages to print
     */
    public void printMessage(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * Outputs formatted message and integer number
     * @param message Message to print
     * @param number Integer number to print
     */
    public void printMessageAndInt(String message, int number) {
        System.out.printf(message, number);
        System.out.println();
    }
}
