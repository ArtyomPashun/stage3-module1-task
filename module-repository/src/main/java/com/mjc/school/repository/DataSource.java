package com.mjc.school.repository;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.utils.TxtFileReader;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

    private final static String NEWS_FILE_PATH = "news.txt";
    private final static String AUTHOR_FILE_PATH = "authors.txt";
    private final static String CONTENT_FILE_PATH = "content.txt";

    private final static int MAX_RECORDS_AMOUNT = 20;

    private static DataSource instance;

    @Getter
    private final List<News> newsList;

    @Getter
    private final List<Author> authorList;

    @Getter
    private final TxtFileReader txtFileReader;

    private DataSource() {
        txtFileReader = new TxtFileReader();
        newsList = new ArrayList<>();
        authorList = new ArrayList<>();

        List<String> authorsList = txtFileReader.read(NEWS_FILE_PATH);
        List<String> titlesList = txtFileReader.read(AUTHOR_FILE_PATH);
        List<String> contentsList = txtFileReader.read(CONTENT_FILE_PATH);

        initNews(titlesList, contentsList);
        initAuthors(authorsList);
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private void initAuthors(List<String> authorsList) {
        for (int i = 0; i < MAX_RECORDS_AMOUNT; i++) {
            authorList.add(new Author((long) i, authorsList.get(i)));
        }
    }

    private void initNews(List<String> titlesList, List<String> contentsList) {
        for (int i = 0; i < MAX_RECORDS_AMOUNT; i++) {
            String title = titlesList.get(i);
            String content = contentsList.get(i);
            LocalDateTime now = LocalDateTime.now();

            Random random = new Random();
            LocalDateTime createdAt = now.minusDays(30 + random.nextInt(30));
            LocalDateTime updatedAt = now.minusDays(random.nextInt(30));

            News news = new News((long) i, title, content, createdAt, updatedAt, (long) i);
            newsList.add(news);
        }
    }
}

