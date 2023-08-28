package com.mjc.school.service.mapStruct;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface NewsMapper {

    NewsDtoResponse newsToResponseDto(NewsModel news);

    List<NewsDtoResponse> newsListToDtoList(List<NewsModel> news);

    List<AuthorDtoResponse> authorListToDtoList(List<AuthorModel> authors);

    @Mappings({
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true)
    })
    NewsModel requestDtoToNews(NewsDtoRequest request);
}
