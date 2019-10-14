package com.paulzhangcc.shardingjdbc.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * UserVO
 */
@JsonIgnoreProperties(ignoreUnknown = true)


@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserVO {
    @JsonProperty("id")
    
    private String id = null;

    @JsonProperty("mobile")
    
    private String mobile = null;

    @JsonProperty("username")
    
    private String username = null;

    @JsonProperty("createTime")
    
    private String createTime = null;


    public UserVO id(String id) {
        this.id = id;
        return this;
    }
    /**
     * Get id
     * @return id
     **/
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public UserVO mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
    /**
     * Get mobile
     * @return mobile
     **/
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserVO username(String username) {
        this.username = username;
        return this;
    }
    /**
     * Get username
     * @return username
     **/
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public UserVO createTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
    /**
     * Get createTime
     * @return createTime
     **/
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserVO userVO = (UserVO) o;
        return Objects.equals(this.id, userVO.id) &&
        Objects.equals(this.mobile, userVO.mobile) &&
        Objects.equals(this.username, userVO.username) &&
        Objects.equals(this.createTime, userVO.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobile, username, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserVO {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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

