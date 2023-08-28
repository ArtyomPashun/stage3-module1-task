package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.entity.News;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepositoryImpl implements BaseRepository<News> {

    private final DataSource dataSource;

    public NewsRepositoryImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public News readById(Long id) {
        return dataSource.getNewsList().stream()
                .filter(news -> news.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<News> readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public News create(News news) {
        Long id = readAll().get(readAll().size() - 1).getId() + 1L;
        news.setId(id);
        news.setCreateDate(LocalDateTime.now());
        news.setLastUpdateDate(LocalDateTime.now());
        dataSource.getNewsList().add(news);
        return news;
    }

    @Override
    public News update(News updatedNews) {
        News news = readById(updatedNews.getId());
        news.setTitle(updatedNews.getTitle());
        news.setContent(updatedNews.getContent());
        news.setLastUpdateDate(updatedNews.getLastUpdateDate());
        news.setAuthorId(updatedNews.getAuthorId());
        return news;
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.getNewsList().removeIf(news -> news.getId().equals(id));
    }
}
