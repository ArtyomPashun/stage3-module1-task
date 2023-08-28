package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.exception.EntityNotFoundException;
import com.mjc.school.service.mapStruct.NewsMapper;
import com.mjc.school.service.validation.BaseValidator;
import com.mjc.school.service.validation.impl.NewsValidatorImpl;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.NoSuchElementException;

public class NewsServiceImpl implements BaseService<NewsDtoRequest, NewsDtoResponse> {

    private final BaseRepository<NewsModel> newsRepository;
    private final NewsMapper newsMapper;
    private final BaseValidator<NewsDtoRequest> newsRequestDtoBaseValidator;

    public NewsServiceImpl() {
        this.newsRepository = new NewsRepositoryImpl();
        this.newsMapper = Mappers.getMapper(NewsMapper.class);
        newsRequestDtoBaseValidator = new NewsValidatorImpl();
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest newsRequestDto) {
        newsRequestDtoBaseValidator.validate(newsRequestDto);
        NewsModel news = newsMapper.requestDtoToNews(newsRequestDto);
        NewsModel savedNews = newsRepository.create(news);
        return newsMapper.newsToResponseDto(savedNews);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest newsRequestDto) {
        newsRequestDtoBaseValidator.validate(newsRequestDto);
        NewsModel news = getNewsById(newsRequestDto.id());
        news.setTitle(newsRequestDto.title());
        news.setContent(newsRequestDto.content());
        news.setAuthorId(newsRequestDto.authorId());

        NewsModel savedNews = newsRepository.update(news);
        return newsMapper.newsToResponseDto(savedNews);
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        NewsModel news;
        try {
            news = newsRepository.readById(id);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("News with such ID %d not found.", id));
        }
        return newsMapper.newsToResponseDto(news);
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsMapper.newsListToDtoList(newsRepository.readAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            return newsRepository.delete(id);
        } catch (Exception e) {
            throw new EntityNotFoundException(String.format("News with such ID %d not found.", id));
        }
    }

    private NewsModel getNewsById(Long id) {
        NewsModel news;
        try {
            news = newsRepository.readById(id);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("News with such ID %d not found.", id));
        }
        return news;
    }
}
