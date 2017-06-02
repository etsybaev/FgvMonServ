package com.fgvmonserv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fgvmonserv.converter.UrlEncoderDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "baseTableList"
})

public class BaseTableListHolder{

    @JsonProperty("baseTableList")
    private List<BaseTable> baseTableList = new ArrayList<>();

    @JsonProperty("baseTableList")
    public List<BaseTable> getBaseTableList() {
        return baseTableList;
    }

    @JsonProperty("baseTableList")
    public BaseTableListHolder setBaseTableList(List<BaseTable> baseTableList) {
        this.baseTableList = baseTableList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTableListHolder that = (BaseTableListHolder) o;

        return baseTableList != null ? baseTableList.equals(that.baseTableList) : that.baseTableList == null;
    }

    @Override
    public int hashCode() {
        return baseTableList != null ? baseTableList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BaseTableListHolder{" +
                "baseTableList=" + baseTableList +
                '}';
    }
}
