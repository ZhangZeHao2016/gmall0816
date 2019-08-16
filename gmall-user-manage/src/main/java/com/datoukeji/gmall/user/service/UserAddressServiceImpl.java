package com.datoukeji.gmall.user.service;

import com.datoukeji.gmall.bean.UserAddress;
import com.datoukeji.gmall.service.UserAddressService;
import com.datoukeji.gmall.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
@com.alibaba.dubbo.config.annotation.Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> getAddressByuserId(String userId) {
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("userId",userId);
        return userAddressMapper.selectByExample(example);
    }

    @Override
    public List<UserAddress> getAddressByuserId(UserAddress userAddress) {
        return userAddressMapper.select(userAddress);
    }
}
