package com.datoukeji.gmall.service;

import com.datoukeji.gmall.bean.UserInfo;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
public interface UserInfoService {

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 根据name查找一个用户
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoByName(UserInfo userInfo);

    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> selectAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserInfo selectById(String id);

    /**
     * 修改对象
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 根据主键删除userinfo
     * @param userInfo
     * @return
     */
    Boolean deleteUser(UserInfo userInfo);

}
