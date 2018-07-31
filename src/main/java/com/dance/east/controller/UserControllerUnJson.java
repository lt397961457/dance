package com.dance.east.controller;

import com.dance.east.service.intf.UserService;
import com.dance.east.utils.page.PageParam;
import com.dance.east.utils.page.PageResult;
import com.dance.east.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user2")
public class UserControllerUnJson {

    @Autowired
    private UserService userService;

    @GetMapping("/page/all2")
    public ModelAndView getAllWithPage2(PageParam pageParam){
        ModelAndView modelAndView = new ModelAndView("dance/user_list");
        PageResult<UserDetailVo> result = userService.getUserWithPageToTable(pageParam);
        modelAndView.addObject("result",result);
        return modelAndView;
    }

}
