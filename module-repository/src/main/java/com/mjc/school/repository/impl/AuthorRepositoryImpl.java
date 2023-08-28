package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.AuthorModel;

import java.util.List;

public class AuthorRepositoryImpl implements BaseRepository<AuthorModel> {

    private final DataSource dataSource;
    private static final String UNSUPPORTED_MESSAGE = "Operation should not be implemented.";

    public AuthorRepositoryImpl() {
        this.dataSource = DataSource.getInstance();
    }


    @Override
    public AuthorModel readById(Long id) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAuthorList();
    }

    @Override
    public AuthorModel create(AuthorModel author) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public AuthorModel update(AuthorModel author) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public Boolean delete(Long id) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}
