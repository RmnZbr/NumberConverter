package ru.zhenabomzha.validator;

import ru.zhenabomzha.enums.errors.Errors;
import ru.zhenabomzha.enums.numeralSystems.NumeralSystem;
import ru.zhenabomzha.parser.ParserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final List<Character> SYMBOLS =
            Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F');

    public ValidatorDto validate(ParserDto dto) {
        List<String> validationErrors = checkNumeralSystem(dto.getSource(), dto.getTarget());
        if (!validationErrors.isEmpty()) {
            throw new RuntimeException(String.join("\n", validationErrors));
        }
        if(!checkValue(dto)) {
            throw new RuntimeException(Errors.VALUE_ERROR.getError());
        }
        return new ValidatorDto(
                dto.getValue(),
                NumeralSystem.valueOf(dto.getSource()).getNumeralSystem(),
                NumeralSystem.valueOf(dto.getTarget()).getNumeralSystem());
    }

    private List<String> checkNumeralSystem(String source, String target) {
        List<String> errors = new ArrayList<>();
        if (!NumeralSystem.checkNumeralSystem(source).isPresent()) {
            errors.add(Errors.SOURCE_NUMERAL_SYSTEM_ERROR.getError());
        }
        if(!NumeralSystem.checkNumeralSystem(target).isPresent()) {
            errors.add(Errors.TARGET_NUMERAL_SYSTEM_ERROR.getError());
        }
        return errors;
    }

    private int findNumeralBase(String numeralSystem) {
        switch (numeralSystem) {
            case "BIN":
                return 2;
            case "OCT":
                return 8;
            case "DEC":
                return 10;
            case "HEX":
                return 16;
        }
        return -1;
    }

    private boolean checkValue(ParserDto dto) {
        final List<Character> allowedSymbols = SYMBOLS.subList(0, NumeralSystem.valueOf(dto.getSource()).getNumeralSystem());
        return dto.getValue().chars()
                .mapToObj(n -> (char) n)
                .allMatch(allowedSymbols::contains);
    }


}
