package com.paulzhangcc.shardingjdbc.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * UserPage
 */
@JsonIgnoreProperties(ignoreUnknown = true)


@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserPage {
    @JsonProperty("total")
    
    private Long total = null;

    @JsonProperty("pageSize")
    
    private Integer pageSize = null;

    @JsonProperty("pageNumber")
    
    private Integer pageNumber = null;

    @JsonProperty("pages")
    
    private Integer pages = null;

    @JsonProperty("data")
    
        
    private List<UserVO> data = null;


    public UserPage total(Long total) {
        this.total = total;
        return this;
    }
    /**
     * 总条数
     * @return total
     **/
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }

    public UserPage pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
    /**
     * 每页显示条数，默认 10
     * @return pageSize
     **/
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public UserPage pageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }
    /**
     * 当前页
     * @return pageNumber
     **/
    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public UserPage pages(Integer pages) {
        this.pages = pages;
        return this;
    }
    /**
     * 总页数
     * @return pages
     **/
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public UserPage data(List<UserVO> data) {
        this.data = data;
        return this;
    }
    public UserPage addDataItem(UserVO dataItem) {
        if (this.data == null) {
        this.data = new ArrayList<UserVO>();
        }
        this.data.add(dataItem);
        return this;
    }
    /**
     * Get data
     * @return data
     **/
    public List<UserVO> getData() {
        return data;
    }
    public void setData(List<UserVO> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPage userPage = (UserPage) o;
        return Objects.equals(this.total, userPage.total) &&
        Objects.equals(this.pageSize, userPage.pageSize) &&
        Objects.equals(this.pageNumber, userPage.pageNumber) &&
        Objects.equals(this.pages, userPage.pages) &&
        Objects.equals(this.data, userPage.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, pageSize, pageNumber, pages, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserPage {\n");
        
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
        sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
        sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

