package com.example.practiceNLMK.dto.dto_expression;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoubleExpression {
    private List<Double> multipleChoice; // Множественный выбор
    private Double equal; // Равно
    private Double notEqual; // Не равно
    private Double greaterThan; // Больше чем
    private Double greaterThanOrEqual; // Больше или равно
    private Double lessThan; // Меньше чем
    private Double lessThanOrEqual; // Меньше или равно
    private List<Double> between; // Диапазон значений
}
