package com.mjc.school.service.mapStruct;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface NewsMapper {

    NewsResponseDto newsToResponseDto(News news);

    List<NewsResponseDto> newsListToDtoList(List<News> news);

    List<AuthorResponseDto> authorListToDtoList(List<Author> authors);

    @Mappings({
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true)
    })
    News requestDtoToNews(NewsRequestDto request);
}
