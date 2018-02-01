package com.home.project.controller;

import com.home.project.ProjectApplication;
import com.home.project.model.SearchRequest;
import com.home.project.model.SearchResponse;
import com.home.project.model.stack_exchange.SearchResult;
import com.home.project.service.stack_exchange.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ProjectApplication.class)
public class HomeControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    private ConversionService conversionService;

    @Before
    public void setUp() {
        conversionService = Mockito.mock(ConversionService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(searchService, conversionService)).build();
    }

    @Test
    public void Should_ReturnsHomeView_When_SearchGetRequest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("request", new SearchRequest()));
    }

    @Test
    public void Should_Returns404Result_When_WrongPathRequest() throws Exception {
        mockMvc.perform(get("/error/404"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void Should_ReturnsSearchView_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();

        mockMvc.perform(post("/").requestAttr("request", searchRequest))
                .andExpect(status().isOk())
                .andExpect(view().name("search"));
    }

    @Test
    public void Should_ReturnsTheSameSearchRequest_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();

        mockMvc.perform(post("/").requestAttr("request", searchRequest))
                .andExpect(status().isOk())
                .andExpect(model().attribute("request", searchRequest));
    }

    @Test
    public void Should_ReturnsSearchRequestWithPageEqualsToOne_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setPage(20);

        SearchRequest expectedSearchRequest = new SearchRequest();
        expectedSearchRequest.setPage(1);

        mockMvc.perform(post("/").requestAttr("request", searchRequest))
                .andExpect(status().isOk())
                .andExpect(model().attribute("request", expectedSearchRequest));
    }

    @Test
    public void Should_ReturnSearchResponse_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        SearchResponse searchResponse = new SearchResponse(Collections.emptyList());

        ConversionService mockConversionService = when(conversionService.convert(any(),any()))
                .thenReturn(searchResponse)
                .getMock();
        HomeController homeController = new HomeController(searchService, mockConversionService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

        mockMvc.perform(post("/").requestAttr("request", searchRequest))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", searchResponse));
    }

    @Test
    public void Should_CallFindMethodInSearchService_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();

        mockMvc.perform(post("/").requestAttr("request", searchRequest));

        Mockito.verify(searchService).findQuestionsByTitle(
                searchRequest.getTitle(),
                searchRequest.getPage(),
                searchRequest.getPageSize());
    }

    @Test
    public void Should_CallConvertMethodInConversionService_When_SearchPostRequestOccurred() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        SearchResponse searchResponse = new SearchResponse(Collections.emptyList());
        SearchResult searchResult = new SearchResult();

        SearchService mockSearchService = when(searchService.findQuestionsByTitle(
                searchRequest.getTitle(),
                searchRequest.getPage(),
                searchRequest.getPageSize()
        )).thenReturn(searchResult).getMock();
        ConversionService mockConversionService = when(conversionService.convert(
                searchResult,
                SearchResponse.class
        )).thenReturn(searchResponse).getMock();
        HomeController homeController = new HomeController(mockSearchService, mockConversionService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

        mockMvc.perform(post("/").requestAttr("request", searchRequest));

        Mockito.verify(conversionService).convert(searchResult, SearchResponse.class);
    }
}
