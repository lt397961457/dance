package com.dance.east.service.intf;

import com.dance.east.utils.page.PageParam;
import com.dance.east.utils.page.PageResult;
import com.dance.east.vo.UserDetailVo;

import java.util.List;

public interface UserService {
    public List<UserDetailVo> queryUserDetailByName(String userName);
    public Boolean saveUserDetail(UserDetailVo vo);

    PageResult<UserDetailVo> getUserWithPageToTable(PageParam pageParam);
}
