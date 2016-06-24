package com.epam.model;

import java.util.List;

/**
 * Word class (leaf)
 */
public class Word extends LanguageUnit {

    private String word;

    public Word(String word) {
        this.word = word.toLowerCase();
    }

    @Override
    public void addUnit(LanguageUnit languageUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeUnit(LanguageUnit languageUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<LanguageUnit> findUniqueUnits(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getDescription() {
        return word + " ";
    }

    @Override
    public Word getClone() {
        return new Word(word);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Word) {
            Word word = (Word) o;

            return this.word.equals(word.word);
        }

        return false;
    }
}