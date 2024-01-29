package ru.zhenabomzha.parser;

public class ParserDto {

    private final String value;
    private final String source;
    private final String target;

    public ParserDto(String value, String source, String target) {
        this.value = value;
        this.source = source;
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }
}
