package com.datoukeji.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.datoukeji.gmall.bean.SpuImage;
import com.datoukeji.gmall.bean.SpuInfo;
import com.datoukeji.gmall.bean.SpuSaleAttr;
import com.datoukeji.gmall.service.ManageService;
import com.sun.javafx.logging.PulseLogger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/19.
 */
@RestController
@CrossOrigin
public class SpuManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
    }

    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(String spuId){
        return manageService.spuImageList(spuId);
    }
    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        return manageService.spuSaleAttrList(spuId);
    }

}
