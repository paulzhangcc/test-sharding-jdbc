package com.paulzhangcc.shardingjdbc.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * UserLoginLogVO
 */
@JsonIgnoreProperties(ignoreUnknown = true)


@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserLoginLogVO {
    @JsonProperty("id")

    private String id = null;

    @JsonProperty("userId")

    private String userId = null;

    @JsonProperty("createTime")

    private String createTime = null;


    public UserLoginLogVO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserLoginLogVO userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     **/
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserLoginLogVO createTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Get createTime
     *
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
        UserLoginLogVO userLoginLogVO = (UserLoginLogVO) o;
        return Objects.equals(this.id, userLoginLogVO.id) &&
                Objects.equals(this.userId, userLoginLogVO.userId) &&
                Objects.equals(this.createTime, userLoginLogVO.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserLoginLogVO {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

