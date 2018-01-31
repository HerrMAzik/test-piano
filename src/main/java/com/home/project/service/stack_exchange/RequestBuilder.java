package com.home.project.service.stack_exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

class RequestBuilder {
    private Map<String, Object> parameters = new HashMap<>();

    RequestBuilder add(String paramName, Object paramValue) {
        this.parameters.put(paramName, paramValue);
        return this;
    }

    String build() {
        StringJoiner sj = new StringJoiner("&", "?", "");
        for (Map.Entry<String, Object> param : this.parameters.entrySet()) {
            sj.add(param.getKey() + "=" + param.getValue().toString());
        }

        return sj.toString();
    }
}
