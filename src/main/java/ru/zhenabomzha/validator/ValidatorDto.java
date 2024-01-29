package ru.zhenabomzha.validator;

public class ValidatorDto {

    private final String value;
    private final int source;
    private final int target;

    public ValidatorDto(String value, int source, int target) {
        this.value = value;
        this.source = source;
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }
}
