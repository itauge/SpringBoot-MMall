package com.itauge.springbootmmall.exception;

import com.itauge.springbootmmall.enums.ResultEnum;

/**
 * unchecked 不用去處理，交給JVM處理，繼承RuntimeException
 * checked 需要自己處理，繼承Exception
 */
public class MallException extends RuntimeException{

    public MallException(String error) {
        super(error);
    }

    public MallException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
