package com.extra.first.model;

import com.extra.first.dto.BaseResult;

/**
 * @author KeeYang on 2017/7/28.
 * @Description :
 */
public class ResponseBuilder {

    public ResponseBuilder() {
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult<T>(true,data);
    }

    public static <T>  BaseResult<T> error(String erroeMsg){
        return new BaseResult<T>(false,erroeMsg);
    }
}
