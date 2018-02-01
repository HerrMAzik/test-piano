package com.home.project.converter;

import com.home.project.model.SearchItem;
import com.home.project.model.SearchResponse;
import com.home.project.model.stack_exchange.Question;
import com.home.project.model.stack_exchange.SearchResult;
import com.home.project.model.stack_exchange.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
public class SearchResultToSearchResponseConverterTest {

    SearchResultToSearchResponseConverter converter;

    @Before
    public void setUp() {
        converter = new SearchResultToSearchResponseConverter();
    }

    @Test
    public void Should_Convert_When_ItemsFieldIsNull() {
        SearchResult searchResult = new SearchResult();
        searchResult.setItems(null);

        SearchResponse searchResponse = converter.convert(searchResult);

        final SearchResponse actual = new SearchResponse(Collections.emptyList());
        Assert.assertEquals(searchResponse, actual);
    }

    @Test
    public void Should_Convert_When_ItemsFieldIsEmpty() {
        SearchResult searchResult = new SearchResult();
        searchResult.setItems(Collections.emptyList());

        SearchResponse searchResponse = converter.convert(searchResult);

        final SearchResponse actual = new SearchResponse(Collections.emptyList());
        Assert.assertEquals(searchResponse, actual);
    }

    @Test
    public void Should_Convert_When_ItemsFieldIsNotEmpty() {
        SearchResult searchResult = new SearchResult();
        Question question = new Question();
        question.setOwner(new User());
        searchResult.setItems(Arrays.asList(question));

        SearchResponse searchResponse = converter.convert(searchResult);

        SearchItem item = new SearchItem();
        SearchResponse actual = new SearchResponse(Arrays.asList(item));

        Assert.assertEquals(searchResponse, actual);
    }
}
