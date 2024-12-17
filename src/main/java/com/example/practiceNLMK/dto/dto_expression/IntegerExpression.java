package com.example.practiceNLMK.dto.dto_expression;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IntegerExpression {
    private List<Integer> multipleChoice; // Множественный выбор
    private Integer equal; // Равно
    private Integer notEqual; // Не равно
    private Integer greaterThan; // Больше чем
    private Integer greaterThanOrEqual; // Больше или равно
    private Integer lessThan; // Меньше чем
    private Integer lessThanOrEqual; // Меньше или равно
    private List<Integer> between; // Диапазон значений
}
