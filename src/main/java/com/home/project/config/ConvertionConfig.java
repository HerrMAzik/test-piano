package com.home.project.config;

import com.home.project.converter.SearchResultToSearchResponseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConvertionConfig {

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new SearchResultToSearchResponseConverter());

        return converters;
    }
}
