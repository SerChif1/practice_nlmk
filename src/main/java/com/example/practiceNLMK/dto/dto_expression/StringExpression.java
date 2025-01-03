package com.example.practiceNLMK.dto.dto_expression;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StringExpression {
    private List<String> multipleChoice; // Множественный выбор
    private String contains; // Строка содержит
    private String notContains; // Строка не содержит
    private String startsWith; // Начинается с
    private String endsWith; // Заканчивается на
    private String equal; // Равно (полностью совпадает)
    private String notEqual; // Не равно (полностью не совпадает)
}
