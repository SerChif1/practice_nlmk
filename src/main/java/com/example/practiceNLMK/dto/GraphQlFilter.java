package com.example.practiceNLMK.dto;

import com.example.practiceNLMK.dto.dto_expression.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphQlFilter {
    // Название поля, к которому применяется фильтр (обязательное)
    private String field;
    // Фильтр для строковых данных
    private StringExpression stringExpression;
    // Фильтр для целых чисел
    private IntegerExpression integerExpression;
    // Фильтр для Long чисел
    private LongExpression longExpression;
    // Фильтр для чисел с плавающей точкой
    private DoubleExpression doubleExpression;
    // Фильтр для данных с датой и временем
    private DateTimeExpression dateTimeExpression;
}
