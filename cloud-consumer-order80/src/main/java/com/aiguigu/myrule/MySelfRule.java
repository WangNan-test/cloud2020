package com.aiguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    public IRule MyRule(){
        return new RandomRule();    //定义为随机
    }
}
