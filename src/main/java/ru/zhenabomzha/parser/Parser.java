package ru.zhenabomzha.parser;

import ru.zhenabomzha.enums.errors.Errors;

public class Parser {

    public static final int MINIMUM_ARGUMENTS = 3;

    public ParserDto parse(String userInput) {

        String[] splittedUserInput = userInput.split("\\s+");
        if (splittedUserInput.length < MINIMUM_ARGUMENTS) {
            throw new RuntimeException(Errors.MINIMUM_ARGUMENTS_ERROR.getError());
        }

        String value = splittedUserInput[0];
        String source = splittedUserInput[1];
        String target = splittedUserInput[2];

        return new ParserDto(value, source, target);
    }
}
