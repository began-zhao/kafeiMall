package com.kafeimall.product.infrastructure.config.exception;

import com.kafeimall.common.exception.BizCodeEnum;
import com.kafeimall.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 集中处理所有异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.kafeimall.product.application")
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{}，异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item->{
            errorMap.put(item.getField(),item.getDefaultMessage());
        }));

        return  Result.error(Result.CODE_SYSTEM_ERROR,BizCodeEnum.VALID_EXCEPTION.toString(), BizCodeEnum.VALID_EXCEPTION.getMessage(),errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public  Result handleException(Throwable e){
        log.error("错误：",e);
        return Result.error(BizCodeEnum.UNKNOW_EXCEPTION.toString(),BizCodeEnum.UNKNOW_EXCEPTION.getMessage());
    }
}
