package com.kafeimall.product;


import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Test {

    @GetMapping("/test")
    public String test(){
        try {
            System.out.print("进入方法");
            log.info("开始日志，跟随项目");
            return "success";
        } catch (Exception e) {
            log.error("出现错误"+ Throwables.getStackTraceAsString(e));
            throw new RuntimeException(e);
        }
    }
}
