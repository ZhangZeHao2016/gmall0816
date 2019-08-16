package com.datoukeji.gmall.user.service;

import com.datoukeji.gmall.bean.UserInfo;
import com.datoukeji.gmall.service.UserInfoService;
import com.datoukeji.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUser(UserInfo userInfo) {

    }

    @Override
    public List<UserInfo> getUserInfoByName(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo selectById(String id) {
        return null;
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {

    }

    @Override
    public Boolean deleteUser(UserInfo userInfo) {
        return null;
    }
}
