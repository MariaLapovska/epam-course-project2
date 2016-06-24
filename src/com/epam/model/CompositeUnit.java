package com.epam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite unit class
 */
public class CompositeUnit extends LanguageUnit {

    /** List with language units*/
    private List<LanguageUnit> languageUnits = new ArrayList<>();

    /** Amount of language units stored in the language unit */
    private int languageUnitsAmount = 0;

    public CompositeUnit() {}

    /**
     * Constructor with parameters, fills language units list
     * with Word objects formed from given string array
     * @param words Array of strings to fill with
     */
    public CompositeUnit(String[] words) {
        WordFactory wordFactory = new WordFactory();

        for (String word : words) {
            this.languageUnits.add(wordFactory.getWord(word));
        }
    }

    public List<LanguageUnit> getLanguageUnits() {
        return languageUnits;
    }

    @Override
    public void addUnit(LanguageUnit languageUnit) {
        languageUnits.add(languageUnit);
        languageUnitsAmount++;
    }

    @Override
    public void removeUnit(LanguageUnit languageUnit) {
        languageUnits.remove(languageUnit);
        languageUnitsAmount--;
    }

    @Override
    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LanguageUnit languageUnit : languageUnits) {
            stringBuilder.append(languageUnit.getDescription());
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    @Override
    public CompositeUnit getClone() {
        CompositeUnit c = new CompositeUnit();

        for (LanguageUnit languageUnit : languageUnits) {
            c.addUnit(languageUnit.clone());
        }

        return c;
    }

    @Override
    public List<LanguageUnit> findUniqueUnits(int index) {
        checkIndex(index);
        checkSentence(languageUnits.get(index));

        CompositeUnit sentenceToFind = (CompositeUnit) languageUnits.get(index).clone();
        int i = 0;

        while (!sentenceToFind.getLanguageUnits().isEmpty() && i != languageUnitsAmount) {
            if ((i != index) && (languageUnits.get(i) instanceof CompositeUnit)) {
                sentenceToFind.removeAll((CompositeUnit) languageUnits.get(i));
            }
            i++;
        }

        return sentenceToFind.getLanguageUnits();
    }

    /**
     * Removes from this language units list all elements contained in the given composite unit
     * @param compositeUnit Composite unit to filter by
     */
    private void removeAll(CompositeUnit compositeUnit) {
        languageUnits.removeAll(compositeUnit.getLanguageUnits());
    }

    /**
     * Checks if given index is in range of language units amount
     * @param index Index to check
     * @throws IllegalArgumentException if index is out of range
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= languageUnitsAmount) {
            throw new IllegalArgumentException("Index should be inclusively between 0 and "
                    + (languageUnitsAmount - 1));
        }
    }

    /**
     * Checks if given language unit is instance of CompositeUnit class
     * @param languageUnit Language unit to check
     * @throws IllegalStateException if language unit is not instance of CompositeUnit class
     */
    private void checkSentence(LanguageUnit languageUnit) {
        if (!(languageUnit instanceof CompositeUnit)) {
            throw new IllegalStateException("Language unit is not instance of CompositeUnit class");
        }
    }
}