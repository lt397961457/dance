package com.dance.east.restcontroller;

import com.dance.east.service.dynamic.intf.DynamicUserService;
import com.dance.east.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Autowired
    DynamicUserService dynamicUserService;
    @PostMapping("/save")
    public Boolean saveUserDetail(@ModelAttribute UserDetailVo vo){
        return dynamicUserService.saveUserDetail(vo);
    }
}
