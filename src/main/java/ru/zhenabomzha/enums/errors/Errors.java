package ru.zhenabomzha.enums.errors;

public enum Errors {

    MINIMUM_ARGUMENTS_ERROR("Вы ввели недостаточное количество данных для конвертации! Повторите ввод!"),
    VALUE_ERROR("Вы ввели число для конвертации с ошибкой или не в указаной системе исчисления!"),
    SOURCE_NUMERAL_SYSTEM_ERROR("Вы ввели исходную систему исчисления с ошибкой!"),
    TARGET_NUMERAL_SYSTEM_ERROR("Вы ввели целевую систему исчисления с ошибкой!");

    private final String error;

    Errors(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
