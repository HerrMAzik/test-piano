package com.home.project.service.stack_exchange;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class RequestBuilderTest {

    @Test
    public void Should_ReturnsStringStartsWithQuestionMark() {
        RequestBuilder requestBuilder = new RequestBuilder();

        requestBuilder.add("key", "value");
        String request = requestBuilder.build();

        Assert.assertThat(request, CoreMatchers.startsWith("?"));
    }

    @Test
    public void Should_HasOneAmpersandMark() {
        RequestBuilder requestBuilder = new RequestBuilder();

        requestBuilder.add("key", "value");
        requestBuilder.add("key2", "value2");
        String request = requestBuilder.build();

        Assert.assertEquals(1, StringUtils.countOccurrencesOf(request, "&"));
    }

    @Test
    public void Should_HasTwoEqualMark() {
        RequestBuilder requestBuilder = new RequestBuilder();

        requestBuilder.add("key", "value");
        requestBuilder.add("key2", "value2");
        String request = requestBuilder.build();

        Assert.assertEquals(2, StringUtils.countOccurrencesOf(request, "="));
    }
}
