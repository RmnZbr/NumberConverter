package ru.zhenabomzha.converter;

import ru.zhenabomzha.validator.Validator;
import ru.zhenabomzha.validator.ValidatorDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {

    public String convert(ValidatorDto dto) {
        if(dto.getSource() == dto.getTarget()) {
            return dto.getValue();
        }
        Integer dec  = toDec(dto.getValue(), dto.getSource());
        StringBuilder sb = new StringBuilder();
        convertToList(dec, dto.getTarget()).stream()
                .map(Validator.SYMBOLS::get)
                .forEach(sb::append);
        return sb.toString();
    }

    private static Integer toDec(String value, int source) {
        if (source == 10) {
            return Integer.valueOf(value);
        }
        String[] splittedValue = value.split("");
        int[] valueForConvert = new int[splittedValue.length];
        for (int i = 0; i < splittedValue.length; i++) {
            valueForConvert[i] = Integer.parseInt(splittedValue[i]);
        }
        int[] numberInDecSystem = new int[valueForConvert.length];
        int result = 0;
        for (int i = 0; i < valueForConvert.length; i++) {
            int powValue = valueForConvert.length - 1 - i;
            int resultOfPow = 1;
            for(int j = 1; j <= powValue; j++) {
                resultOfPow = resultOfPow * source;
            }
            numberInDecSystem[i] = valueForConvert[i] * resultOfPow;
            result = result + numberInDecSystem[i];
        }
        return result;
    }

    private static List<Integer> convertToList(int number, int target) {
        List<Integer> list = new ArrayList<>();
        while (number >= target) {
            list.add(number % target);
            number = number / target;
        }
        list.add(number);
        Collections.reverse(list);
        return list;
    }
}
