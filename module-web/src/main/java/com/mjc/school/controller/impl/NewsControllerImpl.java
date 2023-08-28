package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsControllerImpl implements BaseController<NewsRequestDto, NewsResponseDto> {

    private final BaseService<NewsRequestDto, NewsResponseDto> newsService;

    public NewsControllerImpl() {
        this.newsService = new NewsServiceImpl();
    }

    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        return newsService.create(newsRequestDto);
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return newsService.findAll();
    }

    @Override
    public NewsResponseDto readById(Long id) {
        return newsService.findById(id);
    }

    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        return newsService.update(newsRequestDto);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.deleteById(id);
    }
}
