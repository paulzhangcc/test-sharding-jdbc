package com.paulzhangcc.shardingjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author root
 *         前后端交互数据标准
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */

    private boolean success;

    /**
     * 返回消息
     */

    private String message;

    /**
     * 返回代码
     */

    private Integer code;

    /**
     * 时间戳
     */

    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */

    private T result;
}
