package com.fgvmonserv.model;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.enums.SearchByRangeTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created by ievgeniit on 06.06.17.
 */
public class BaseTableDateFilter {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    private BaseTableNamesEnum baseTableNamesEnum;
    private SearchByRangeTypeEnum searchByRangeTypeEnum;

    public LocalDate getStartDate() {
        return startDate;
    }

    public BaseTableDateFilter setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public BaseTableNamesEnum getBaseTableNamesEnum() {
        return baseTableNamesEnum;
    }

    public BaseTableDateFilter setBaseTableNamesEnum(BaseTableNamesEnum baseTableNamesEnum) {
        this.baseTableNamesEnum = baseTableNamesEnum;
        return this;
    }

    public SearchByRangeTypeEnum getSearchByRangeTypeEnum() {
        return searchByRangeTypeEnum;
    }

    public BaseTableDateFilter setSearchByRangeTypeEnum(SearchByRangeTypeEnum searchByRangeTypeEnum) {
        this.searchByRangeTypeEnum = searchByRangeTypeEnum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTableDateFilter that = (BaseTableDateFilter) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (baseTableNamesEnum != that.baseTableNamesEnum) return false;
        return searchByRangeTypeEnum == that.searchByRangeTypeEnum;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (baseTableNamesEnum != null ? baseTableNamesEnum.hashCode() : 0);
        result = 31 * result + (searchByRangeTypeEnum != null ? searchByRangeTypeEnum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTableDateFilter{" +
                "startDate=" + startDate +
                ", baseTableNamesEnum=" + baseTableNamesEnum +
                ", searchByRangeTypeEnum=" + searchByRangeTypeEnum +
                '}';
    }
}
