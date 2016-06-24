package com.epam.model;

import java.util.List;

/**
 * Language unit class
 */
public abstract class LanguageUnit {

    /**
     * Adds given language unit to language unit
     * @param languageUnit Language unit to add
     */
    public abstract void addUnit(LanguageUnit languageUnit);

    /**
     * Removes given language unit from language unit
     * @param languageUnit Language unit to remove
     */
    public abstract void removeUnit(LanguageUnit languageUnit);

    /**
     * Finds units in the language unit that are not duplicated in other units
     * @param index Index of sentence to check
     * @return List of found unique units
     */
    public abstract List<LanguageUnit> findUniqueUnits(int index);

    /**
     * Gets string with description of language unit object
     * @return Language unit description
     */
    public abstract String getDescription();

    /**
     * Gets deep copy of language unit object
     * @return Deep copy of language unit
     */
    public abstract LanguageUnit getClone();

    @Override
    public String toString() {
        return getDescription();
    }

    @Override
    public LanguageUnit clone() {
        return getClone();
    }
}