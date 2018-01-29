package com.home.project.controller;

import com.home.project.model.SearchRequest;
import com.home.project.model.SearchResponse;
import com.home.project.model.StackExchange.SearchResult;
import com.home.project.service.StackExchange.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final SearchService searchService;

    @Autowired
    public HomeController(SearchService searchService) {

        this.searchService = searchService;
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
            SearchRequest request) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("request", request);

        SearchResult searchResult = searchService.findQuestionsByTitle(request.getTitle(), request.getPage(), request.getPageSize());

        mav.addObject("questions", searchResult.getItems());
        return mav;
    }
}
