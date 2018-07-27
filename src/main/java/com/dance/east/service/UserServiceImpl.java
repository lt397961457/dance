package com.dance.east.service;

import com.dance.east.entity.UserImg;
import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.dance.UserImageMapper;
import com.dance.east.mapper.dance.UserMapper;
import com.dance.east.service.intf.UserService;
import com.dance.east.vo.UserDetailVo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@Service("userService")
@Transactional("transactionManagerDS2")
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

    @Override
    public Boolean saveUserDetail(UserDetailVo vo) {
        try {
            UserInfo userInfo = vo.getUserInfo();
            if(userInfo == null){
                return false;
            }
            userMapper.saveUser(userInfo);
            int a = 1/0;
            List<UserImg> userImgs = vo.getImgs();
            if(userImgs != null && userImgs.size()>0){
                Long userId = userInfo.getID();
                if(userId == null){
                    return false;
                }
                String rootPath = ResourceUtils.getURL("classpath:").getPath();
                for(UserImg img : userImgs){
                    img.setUserId(userId);
                    InputStream is = img.getFile().getInputStream();
                    OutputStream os = new FileOutputStream(rootPath + "/static/upload/"+img.getFile().getOriginalFilename());

                    IOUtils.copy(is,os);
                    img.setImageUrl("/static/upload/"+img.getFile().getOriginalFilename());
                }
                userImageMapper.batchSave(userImgs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
