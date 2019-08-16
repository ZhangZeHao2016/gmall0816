package com.datoukeji.gmall.service;

import com.datoukeji.gmall.bean.UserAddress;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
public interface UserAddressService {

    List<UserAddress> getAddressByuserId(String userId);

    List<UserAddress> getAddressByuserId(UserAddress userAddress);

}
