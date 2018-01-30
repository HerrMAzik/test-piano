package com.home.project.service.stack_exchange;

import com.home.project.model.stack_exchange.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class SearchService {
    private static final String STACKOVERFLOW = "stackoverflow";
    private static final String FILTER = "!-*jbN0L_TqSV";

    @Value("${com.home.project.data-source-base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public SearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SearchResult findQuestionsByTitle(final String title, final int page, final int pageSize) throws UnsupportedEncodingException {

        if (StringUtils.isEmpty(title)) {
            return SearchResult.empty();
        }

        String params = new RequestBuilder()
                .add("order", "asc")
                .add("site", STACKOVERFLOW)
                .add("filter", FILTER)
                .add("pagesize", pageSize)
                .add("page", page)
                .add("intitle", URLEncoder.encode(title, StandardCharsets.UTF_8.toString()))
                .build();

        String url = baseUrl + "/search" + params;
        SearchResult searchResult = restTemplate.getForObject(url, SearchResult.class);

        return searchResult;
    }
}
