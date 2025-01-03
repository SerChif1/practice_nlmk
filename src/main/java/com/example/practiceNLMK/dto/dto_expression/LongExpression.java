package com.example.practiceNLMK.dto.dto_expression;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LongExpression {
    private List<Long> multipleChoice; // Множественный выбор
    private Long equal; // Равно
    private Long notEqual; // Не равно
    private Long greaterThan; // Больше чем
    private Long greaterThanOrEqual; // Больше или равно
    private Long lessThan; // Меньше чем
    private Long lessThanOrEqual; // Меньше или равно
    private List<Long> between; // Диапазон значений
}
