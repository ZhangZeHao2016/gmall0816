package com.datoukeji.gmall.user.controller;

import com.datoukeji.gmall.bean.UserInfo;
import com.datoukeji.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userInfoService.selectAll();
    }


}
