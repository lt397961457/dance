package com.dance.east.service;

import com.dance.east.entity.UserImg;
import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.dance.UserImageMapper;
import com.dance.east.mapper.dance.UserMapper;
import com.dance.east.service.intf.UserService;
import com.dance.east.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserImageMapper userImageMapper;
    @Override
    public List<UserDetailVo> queryUserDetailByName(String userName) {
        List<UserDetailVo> result = new ArrayList<>();
        List<UserInfo> userInfos = userMapper.queryByUserName(userName);
        for(UserInfo info: userInfos){
            UserDetailVo vo = new UserDetailVo();
            vo.setUserInfo(info);
            List<UserImg> imgs = userImageMapper.queryByUserId(info.getID());
            vo.setImgs(imgs);
            result.add(vo);
        }
        return result;
    }
}
