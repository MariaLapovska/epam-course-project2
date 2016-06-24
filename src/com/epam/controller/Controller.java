package com.epam.controller;

import com.epam.constants.GlobalConstants;
import com.epam.model.*;
import com.epam.view.View;

import java.nio.charset.Charset;

/**
 * Controller class
 */
public class Controller {

    private Parser parser;
    private View view;

    /** Constructor with parameters */
    public Controller(Parser parser, View view) {
        this.parser = parser;
        this.view = view;
    }

    // Work method

    public void processUser() {
        LanguageUnit text = new CompositeUnit();

        parser.parse(GlobalConstants.PATH, Charset.forName(GlobalConstants.ENCODING), text);
        view.printMessage(View.WORDS, text.getDescription());
        view.printMessageAndInt(View.RESULT, GlobalConstants.SENTENCE_INDEX + 1);
        view.printMessage(text.findUniqueUnits(GlobalConstants.SENTENCE_INDEX).toString());
    }
}