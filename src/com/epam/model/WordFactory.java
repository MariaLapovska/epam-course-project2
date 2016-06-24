package com.epam.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Word factory class (flyweight pattern)
 */
public class WordFactory {

    /** Map with pairs of unique words and Word objects*/
    private static final Map<String, Word> words = new HashMap<>();

    /**
     * Checks if given word already exists in map, puts it to map if it doesn't
     * @param wordName Word to put to map
     * @return Word object with given wordName value
     */
    public Word getWord(String wordName) {
        Word word = words.get(wordName);

        if (word == null) {
            word = new Word(wordName);
            words.put(wordName, word);
        }

        return word;
    }
}
