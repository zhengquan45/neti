package com.zhq.neti.common;

import com.zhq.neti.exception.NoSessionException;
import com.zhq.neti.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionResovler {

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(NoSessionException.class)
    public ServerResponse handleOpdRuntimeException(NoSessionException e) {
        // 不打印异常堆栈信息
        log.error(e.getMessage());
        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),e.getMessage());
    }

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse handleException(Exception e) {
        // 打印异常堆栈信息
        log.error(e.getMessage(), e);
        return ServerResponse.createByErrorMessage("系统错误");
    }

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(ParamException.class)
    public ServerResponse handleParamException(Exception e) {
        // 打印异常堆栈信息
        log.error(e.getMessage());
        return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),e.getMessage());
    }




}
