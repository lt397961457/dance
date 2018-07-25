package com.dance.east.mapper.jpa;

import com.dance.east.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring jpa 形式的dao
 */
public interface UserRepository extends JpaRepository<UserInfo,Long> {
    /**
     * 自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy
     * 也使用一些加一些关键字And、 Or
     * 详细参见：http://www.cnblogs.com/ityouknow/p/5891443.html
     * @param userName
     * @return
     */
    UserInfo findByUserName(String userName);
    UserInfo findByPhoneNum(String phoneNum);
}
