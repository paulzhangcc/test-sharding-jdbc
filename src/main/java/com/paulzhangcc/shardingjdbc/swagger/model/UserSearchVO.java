package com.paulzhangcc.shardingjdbc.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * UserSearchVO
 */
@JsonIgnoreProperties(ignoreUnknown = true)


@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserSearchVO {
    @JsonProperty("pageNumber")
    
    private Integer pageNumber = null;

    @JsonProperty("pageSize")
    
    private Integer pageSize = null;

    @JsonProperty("order")
    
    private String order = null;

    @JsonProperty("sort")
    
    private String sort = null;

    @JsonProperty("search")
    
    private UserVO search = null;

    @JsonProperty("startDate")
    
    private String startDate = null;

    @JsonProperty("endDate")
    
    private String endDate = null;


    public UserSearchVO pageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }
    /**
     * 页号
     * @return pageNumber
     **/
    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public UserSearchVO pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
    /**
     * 每页条数
     * @return pageSize
     **/
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public UserSearchVO order(String order) {
        this.order = order;
        return this;
    }
    /**
     * 升序还是降序
     * @return order
     **/
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }

    public UserSearchVO sort(String sort) {
        this.sort = sort;
        return this;
    }
    /**
     * 排序字段
     * @return sort
     **/
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }

    public UserSearchVO search(UserVO search) {
        this.search = search;
        return this;
    }
    /**
     * Get search
     * @return search
     **/
    public UserVO getSearch() {
        return search;
    }
    public void setSearch(UserVO search) {
        this.search = search;
    }

    public UserSearchVO startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }
    /**
     * 开始日期
     * @return startDate
     **/
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public UserSearchVO endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
    /**
     * 结束日期
     * @return endDate
     **/
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserSearchVO userSearchVO = (UserSearchVO) o;
        return Objects.equals(this.pageNumber, userSearchVO.pageNumber) &&
        Objects.equals(this.pageSize, userSearchVO.pageSize) &&
        Objects.equals(this.order, userSearchVO.order) &&
        Objects.equals(this.sort, userSearchVO.sort) &&
        Objects.equals(this.search, userSearchVO.search) &&
        Objects.equals(this.startDate, userSearchVO.startDate) &&
        Objects.equals(this.endDate, userSearchVO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize, order, sort, search, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserSearchVO {\n");
        
        sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
        sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
        sb.append("    search: ").append(toIndentedString(search)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

