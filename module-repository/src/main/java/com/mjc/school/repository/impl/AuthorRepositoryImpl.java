package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.entity.Author;

import java.util.List;

public class AuthorRepositoryImpl implements BaseRepository<Author> {

    private final DataSource dataSource;
    private static final String UNSUPPORTED_MESSAGE = "Operation should not be implemented.";

    public AuthorRepositoryImpl() {
        this.dataSource = DataSource.getInstance();
    }


    @Override
    public Author readById(Long id) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public List<Author> readAll() {
        return dataSource.getAuthorList();
    }

    @Override
    public Author create(Author author) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public Author update(Author author) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public Boolean delete(Long id) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}
