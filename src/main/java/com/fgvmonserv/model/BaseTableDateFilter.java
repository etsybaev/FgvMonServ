package com.fgvmonserv.model;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.enums.SearchByRangeTypeEnum;
import com.fgvmonserv.model.userauth.User;
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
    private User manager;
    private StatusOfDeal statusOfDeal;
    private Boolean isUnderControl;

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

    public User getManager() {
        return manager;
    }

    public BaseTableDateFilter setManager(User manager) {
        this.manager = manager;
        return this;
    }

    public StatusOfDeal getStatusOfDeal() {
        return statusOfDeal;
    }

    public BaseTableDateFilter setStatusOfDeal(StatusOfDeal statusOfDeal) {
        this.statusOfDeal = statusOfDeal;
        return this;
    }

    public Boolean getIsUnderControl() {
        return isUnderControl;
    }

    public BaseTableDateFilter setIsUnderControl(Boolean isUnderControl) {
        this.isUnderControl = isUnderControl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTableDateFilter that = (BaseTableDateFilter) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (baseTableNamesEnum != that.baseTableNamesEnum) return false;
        if (searchByRangeTypeEnum != that.searchByRangeTypeEnum) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (statusOfDeal != null ? !statusOfDeal.equals(that.statusOfDeal) : that.statusOfDeal != null) return false;
        return isUnderControl != null ? isUnderControl.equals(that.isUnderControl) : that.isUnderControl == null;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (baseTableNamesEnum != null ? baseTableNamesEnum.hashCode() : 0);
        result = 31 * result + (searchByRangeTypeEnum != null ? searchByRangeTypeEnum.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (statusOfDeal != null ? statusOfDeal.hashCode() : 0);
        result = 31 * result + (isUnderControl != null ? isUnderControl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTableDateFilter{" +
                "startDate=" + startDate +
                ", baseTableNamesEnum=" + baseTableNamesEnum +
                ", searchByRangeTypeEnum=" + searchByRangeTypeEnum +
                ", manager=" + manager +
                ", statusOfDeal=" + statusOfDeal +
                ", isOnControl='" + isUnderControl + '\'' +
                '}';
    }
}
