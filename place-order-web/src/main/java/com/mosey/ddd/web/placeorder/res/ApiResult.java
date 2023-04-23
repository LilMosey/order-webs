package com.mosey.ddd.web.placeorder.res;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TangJie
 * @since 2023/4/19
 */
@Data
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 1296475017355846525L;

    private boolean success;
    private String code;
    private T data;
    private String message;

    public static <T> ApiResult<T> result(boolean success, String code, String msg, T data) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(code);
        result.setSuccess(success);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    public static <T> ApiResult<T> ok(T data) {
        return result(true, null, null, data);
    }

    public static <T> ApiResult<T> fail(String code, String msg) {
        return result(false, code, msg, null);
    }
}
