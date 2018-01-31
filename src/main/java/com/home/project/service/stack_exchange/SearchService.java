package com.home.project.service.stack_exchange;

import com.home.project.model.stack_exchange.SearchResult;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class SearchService {
    private static final String STACKOVERFLOW = "stackoverflow";
    private static final String FILTER = "!-*jbN0L_TqSV";
    private static final String ASC = "asc";

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
                .add("order", ASC)
                .add("site", STACKOVERFLOW)
                .add("filter", FILTER)
                .add("pagesize", pageSize)
                .add("page", page)
                .add("intitle", URLEncoder.encode(title, StandardCharsets.UTF_8.toString()))
                .build();

        String url = baseUrl + "/search" + params;
        // TODO to translate it later
        // без этого преобразования знак процента в строке запроса экранируется и преобразуется в '%25'
        URI uri = URI.create(url);
        SearchResult searchResult = restTemplate.getForObject(uri, SearchResult.class);

        return searchResult;
    }
}
