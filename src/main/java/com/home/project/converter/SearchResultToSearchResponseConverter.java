package com.home.project.converter;

import com.home.project.model.SearchItem;
import com.home.project.model.SearchResponse;
import com.home.project.model.stack_exchange.SearchResult;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultToSearchResponseConverter implements Converter<SearchResult, SearchResponse> {
    @Override
    public SearchResponse convert(SearchResult source) {

        List<SearchItem> items = source.getItems().stream()
                .map(SearchItem::from)
                .collect(Collectors.toList());

        SearchResponse searchResponse = new SearchResponse(items);

        searchResponse.setPageSize(source.getPageSize());
        searchResponse.setCurrentPage(source.getPage());
        searchResponse.setTotalItemsCount(source.getTotalItems());

        return searchResponse;
    }
}
