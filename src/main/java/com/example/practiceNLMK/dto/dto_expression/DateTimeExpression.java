package com.example.practiceNLMK.dto.dto_expression;

import java.time.LocalDateTime;
import java.util.List;

public class DateTimeExpression {
    private List<LocalDateTime> multipleChoice; // Множественный выбор
    private LocalDateTime equal; // Равно
    private LocalDateTime notEqual; // Не равно
    private LocalDateTime greaterThan; // Больше чем
    private LocalDateTime greaterThanOrEqual; // Больше или равно
    private LocalDateTime lessThan; // Меньше чем
    private LocalDateTime lessThanOrEqual; // Меньше или равно
    private List<LocalDateTime> between; // Диапазон значений
}
