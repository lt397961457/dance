package com.dance.east.service.dynamic;

import com.dance.east.config.DynamicDatasouce.DS;
import com.dance.east.entity.UserImg;
import com.dance.east.entity.UserInfo;
import com.dance.east.mapper.dynamic.DynamicUserImageMapper;
import com.dance.east.mapper.dynamic.DynamicUserMapper;
import com.dance.east.service.dynamic.intf.DynamicUserService;
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
@Service("dynamicUserService")
@Transactional("transactionManagerDynamic")
public class DynamicUserServiceImpl implements DynamicUserService {
    @Autowired
    private DynamicUserMapper dynamicUserMapper;
    @Autowired
    private DynamicUserImageMapper dynamicUserImageMapper;

    @DS(value = "dynamic-master")
    @Override
    public List<UserDetailVo> queryUserDetailByName(String userName) {
        List<UserDetailVo> result = new ArrayList<>();
        List<UserInfo> userInfos = dynamicUserMapper.queryByUserName(userName);

        for(UserInfo info: userInfos){
            UserDetailVo vo = new UserDetailVo();
            vo.setUserInfo(info);
            List<UserImg> imgs = dynamicUserImageMapper.queryByUserId(info.getID());
            vo.setImgs(imgs);
            result.add(vo);
        }
        return result;
    }
    @DS(value = "dynamic-master")
    @Override
    public Boolean saveUserDetail(UserDetailVo vo) {
        try {
            UserInfo userInfo = vo.getUserInfo();
            if(userInfo == null){
                return false;
            }
            dynamicUserMapper.saveUser(userInfo);
//            int a = 1/0;
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
                dynamicUserImageMapper.batchSave(userImgs);
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
