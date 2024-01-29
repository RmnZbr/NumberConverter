package ru.zhenabomzha.engine;

import ru.zhenabomzha.converter.Converter;
import ru.zhenabomzha.input.ConsoleUserInput;
import ru.zhenabomzha.output.OutputService;
import ru.zhenabomzha.parser.Parser;
import ru.zhenabomzha.parser.ParserDto;
import ru.zhenabomzha.validator.Validator;
import ru.zhenabomzha.validator.ValidatorDto;

public class Engine {

    public static void run() {
        ConsoleUserInput input = new ConsoleUserInput();
        Parser parser = new Parser();
        Validator validator = new Validator();
        Converter converter = new Converter();

        String userInput = input.getUserInput();
        ParserDto parserDto = parser.parse(userInput);
        ValidatorDto validatorDto = validator.validate(parserDto);
        String result = converter.convert(validatorDto);
        OutputService.print(result);
    }
}
