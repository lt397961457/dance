package com.dance.east.restcontroller;

import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.jpa.UserRepository;
import com.dance.east.service.intf.UserService;
import com.dance.east.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     *  不可以使用PUT 方式，不能自动将参数组装为对象
     * @param vo
     * @param files
     * @return
     */
    @PostMapping("/save")
    public Boolean saveUserDetail(@ModelAttribute UserDetailVo vo,@RequestParam("files")MultipartFile[] files){
        return userService.saveUserDetail(vo);
    }

    @PostMapping("/save2")
    public void saveUserDetail2( UserInfo info){
        System.out.println(info);
    }
}
