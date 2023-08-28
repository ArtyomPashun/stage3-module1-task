package com.mjc.school.service;

import java.util.List;

public interface BaseService<T, R> {
    R create (T t);

    R update (T t);

    R findById (Long id);

    List<R> findAll ();

    Boolean deleteById (Long id);
}
