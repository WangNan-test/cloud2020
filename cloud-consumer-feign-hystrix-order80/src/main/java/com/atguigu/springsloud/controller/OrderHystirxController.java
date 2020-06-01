package com.atguigu.springsloud.controller;

import com.atguigu.springsloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paument_Glabel_FallBackMethod")
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = this.paymentHystrixService.paymentInfo_OK(id);
        log.info("*******"+result);
        return result;
    }
//    @HystrixCommand(fallbackMethod ="paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3500")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int age= 10/0;
        String result = this.paymentHystrixService.paymentInfo_TimeOut(id);
        log.info(result);
        return result;
    }
    public String  paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒后再试！！o(╥﹏╥)o";
    }

    //全局fallBack方法

    public String paument_Glabel_FallBackMethod(){
        return "全局FallBack方法，有超时异常，或者代码错误。请检查";
    }
}
