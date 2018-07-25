package com.dance.east.restcontroller;

import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.jpa.UserRepository;
import com.dance.east.service.intf.UserService;
import com.dance.east.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("dataSourceDS2")
    private DataSource dataSourceDS2;

    @Autowired
    @Qualifier("dataSourceDS1")
    private DataSource dataSourceDS1;


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/byname/{userName}")
    public List<UserDetailVo> getUserInfoByName(@PathVariable(value = "userName") String userName){
            return userService.queryUserDetailByName(userName);
    }
    @GetMapping("/byname2/{userName}")
    public UserInfo getUserInfoByName2(@PathVariable(value = "userName") String userName){
            return userRepository.findByUserName(userName);
    }
}
