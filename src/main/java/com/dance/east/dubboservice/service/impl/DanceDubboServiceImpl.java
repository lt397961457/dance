package com.dance.east.dubboservice.service.impl;

import com.dance.east.dubboservice.entity.City;
import com.dance.east.dubboservice.service.DanceDubboService;

// 注册为 Dubbo 服务  使用的是Dubbo提供的注解
//@Service(version = "1.0.0")
public class DanceDubboServiceImpl implements DanceDubboService {
    @Override
    public String findCityNameById(int id) {
        return "SC-CD";
    }

    @Override
    public City getCityById(int id) {
        return new City("BJ",1);
    }
}
