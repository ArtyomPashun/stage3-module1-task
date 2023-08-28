package com.mjc.school.service.validation.impl;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exception.ValidationException;
import com.mjc.school.service.validation.BaseValidator;

public class NewsValidatorImpl implements BaseValidator<NewsDtoRequest> {

    @Override
    public void validate(NewsDtoRequest newsRequestDto) {
        String title = newsRequestDto.title();
        String content = newsRequestDto.content();
        if (title != null) {
            if (title.length() < 5 || title.length() > 30) {
                throw new ValidationException("Title field should have length from 5 to 30.");
            }
        }
        if (content != null) {
            if (content.length() < 5 || content.length() > 255) {
                throw new ValidationException("Content field should have length from 5 to 255.");
            }
        }
    }
}
