package com.epam.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Parser class
 */
public class Parser {

    /** Regular expression for parsing text by sentences */
    private static final String REGEX_TEXT = "[.]{3}|\\.|\\?|!";

    /** Regular expression for parsing sentence by words */
    private static final String REGEX_SENTENCE = "[[^a-zA-Zа-яА-Я]\\s\\d]+";

    /**
     * Parses file and writes its contents to given LanguageUnit object
     * @param path Path to file
     * @param encoding Encoding of file
     * @param text LanguageUnit object to write to
     */
    public void parse(String path, Charset encoding, LanguageUnit text) {
        String lines = readFromFile(path, encoding);
        String[] sentences = parseText(lines);
        String[] temp;

        for (String sentence : sentences) {
            temp = parseSentence(sentence);

            if (temp.length != 0) {
                text.addUnit(new CompositeUnit(temp));
            }
        }
    }

    /**
     * Reads contents of file to string, replacing new line characters with spaces
     * @param path Path to file
     * @param encoding Encoding of file
     * @return String with file contents
     */
    private String readFromFile(String path, Charset encoding) {
        try {
            return String.join(" ", Files.readAllLines(Paths.get(path), encoding));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Parses given string as text by sentences (by [?], [!], [.] and [...])
     * @param string String to parse
     * @return Array of parsed strings
     */
    private String[] parseText(String string) {
        return removeEmptyEntries(string.split(REGEX_TEXT));
    }

    /**
     * Parses given string as sentence by words (by digits, whitespace and non-word characters)
     * @param string String to parse
     * @return Array of parsed strings
     */
    private String[] parseSentence(String string) {
        return removeEmptyEntries(string.split(REGEX_SENTENCE));
    }

    /**
     * Returns copy of given array without empty strings
     * @param strings String array to inspect
     * @return Copy of given array without empty strings
     */
    private String[] removeEmptyEntries(String[] strings) {
        String s;
        int i, from;
        i = from = strings.length;

        while (i > 0) {
            s = strings[--i];

            if (!s.isEmpty()) {
                strings[--from] = s;
            }
        }

        return Arrays.copyOfRange(strings, from, strings.length);
    }
}
