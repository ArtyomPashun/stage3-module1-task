package com.mjc.school.repository;

import java.util.List;

public interface BaseRepository<T> {

    T readById (Long id);

    List<T> readAll();

    T create (T t);

    T update (T t);

    Boolean delete (Long id);
}
