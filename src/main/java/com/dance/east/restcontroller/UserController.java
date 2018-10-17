package com.dance.east.restcontroller;

import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.jpa.UserRepository;
import com.dance.east.service.intf.UserService;
import com.dance.east.utils.page.PageParam;
import com.dance.east.utils.page.PageResult;
import com.dance.east.vo.UserDetailVo;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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

    /**
     * JSON请求形式的 的分页接口，前端未实现
     * @param pageParam
     * @return
     */
    @PostMapping("/page/all")
    public PageResult<UserDetailVo> getAllWithPage(@RequestBody PageParam pageParam){
        return userService.getUserWithPageToTable(pageParam);
    }

    /**
     * 非JSON形式的分页请求接口
     * 注意参数对象里面有MAP的需要这样写参数名：params[userName]
     * @param pageParam
     * @return
     */
    @PostMapping("/page/all2")
    public PageResult<UserDetailVo> getAllWithPage2(PageParam pageParam){
        return userService.getUserWithPageToTable(pageParam);
    }

    @PostMapping("/save2")
    public void saveUserDetail2( UserInfo info){
        System.out.println(info);
    }

    @GetMapping("/jsonview")
    @JsonView(UserDetailVo.MyView.class)
    public UserDetailVo testJsonView(){
        UserDetailVo vo = new UserDetailVo();
        vo.setImgs(new ArrayList<>());
        vo.setUserInfo(new UserInfo());
        return vo;
    }

}
