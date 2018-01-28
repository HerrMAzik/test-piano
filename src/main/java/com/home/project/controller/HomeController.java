package com.home.project.controller;

import com.home.project.model.SearchRequest;
import com.home.project.model.SearchResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {
        SearchRequest request = new SearchRequest();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("request", request);
        return mav;
    }

    @PostMapping("/")
    public ModelAndView search(
            @ModelAttribute(name = "request")
            SearchRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("request", request);
        SearchResponse searchResponse = new SearchResponse();
        mav.addObject("questions", searchResponse.getData());
        return mav;
    }
}
