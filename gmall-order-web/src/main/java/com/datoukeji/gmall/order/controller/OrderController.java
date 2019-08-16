package com.datoukeji.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.datoukeji.gmall.bean.UserAddress;
import com.datoukeji.gmall.service.UserAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
@Controller
public class OrderController {

    @Reference
    private UserAddressService userAddressService;

    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade (String userId) {
        return userAddressService.getAddressByuserId(userId);
    }


}
