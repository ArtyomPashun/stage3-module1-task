package com.mjc.school.service;

import java.util.List;

public interface BaseService<T, R> {
    R create (T t);

    R update (T t);

    R readById(Long id);

    List<R> readAll();

    Boolean deleteById (Long id);
}
