package com.home.project.service.stack_exchange;

import com.home.project.model.stack_exchange.SearchResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SearchServiceTest {

    private SearchService searchService;

    @Before
    public void setUp() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        searchService = new SearchService(restTemplate);
    }

    @Test
    public void Should_ReturnEmptyResult_When_RequestTitleIsNull() throws UnsupportedEncodingException {
        SearchResult searchResult = SearchResult.empty();

        SearchResult actual = searchService.findQuestionsByTitle(null, 1, 1);

        Assert.assertEquals(actual, searchResult);
    }

    @Test
    public void Should_ReturnEmptyResult_When_RequestTitleIsEmpty() throws UnsupportedEncodingException {
        SearchResult searchResult = SearchResult.empty();

        SearchResult actual = searchService.findQuestionsByTitle("", 1, 1);

        Assert.assertEquals(actual, searchResult);
    }

    @Test
    public void Should_NotCallRestGettingMethod_When_RequestTitleIsEmpty() throws UnsupportedEncodingException {
        RestTemplate restTemplate = mock(RestTemplate.class);
        RestTemplate mockRestTemplate = when(restTemplate.getForObject(any(), any()))
                .thenReturn(null)
                .getMock();
        SearchService searchService = new SearchService(mockRestTemplate);

        searchService.findQuestionsByTitle("", 1, 1);

        verify(mockRestTemplate, never()).getForObject(any(), any());
    }

    @Test
    public void Should_CallRestGettingMethod_When_RequestTitleIsNotEmpty() throws UnsupportedEncodingException {
        RestTemplate restTemplate = mock(RestTemplate.class);
        RestTemplate mockRestTemplate = when(restTemplate.getForObject(any(), any()))
                .thenReturn(null)
                .getMock();
        SearchService searchService = new SearchService(mockRestTemplate);

        searchService.findQuestionsByTitle("not empty string", anyInt(), anyInt());

        verify(mockRestTemplate).getForObject(any(), any());
    }
}
