package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsControllerImpl implements BaseController<NewsDtoRequest, NewsDtoResponse> {

    private final BaseService<NewsDtoRequest, NewsDtoResponse> newsService;

    public NewsControllerImpl() {
        this.newsService = new NewsServiceImpl();
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest newsRequestDto) {
        return newsService.create(newsRequestDto);
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest newsRequestDto) {
        return newsService.update(newsRequestDto);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.deleteById(id);
    }
}
