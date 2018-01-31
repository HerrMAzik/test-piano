package com.home.project.controller;

import com.home.project.model.SearchRequest;
import com.home.project.model.SearchResponse;
import com.home.project.model.stack_exchange.SearchResult;
import com.home.project.service.stack_exchange.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
public class HomeController {

    private final SearchService searchService;
    private final ConversionService conversionService;

    @Autowired
    public HomeController(SearchService searchService, ConversionService conversionService) {

        this.searchService = searchService;
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("request", new SearchRequest());
        return mav;
    }

    @PostMapping("/")
    public ModelAndView search(
            @ModelAttribute(name = "request")
            SearchRequest request) throws UnsupportedEncodingException {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");

        SearchResult searchResult = searchService.findQuestionsByTitle(request.getTitle(), request.getPage(), request.getPageSize());

        request.setPage(1);
        mav.addObject("request", request);
        mav.addObject("result", conversionService.convert(searchResult, SearchResponse.class));
        return mav;
    }
}
