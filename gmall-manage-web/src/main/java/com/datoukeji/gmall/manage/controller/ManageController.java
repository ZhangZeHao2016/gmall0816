package com.datoukeji.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.datoukeji.gmall.bean.*;
import com.datoukeji.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/16.
 */
@Controller
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getBaseCatalog1List();
    }
    //http://localhost:8082/getCatalog2?catalog1Id=2
    @RequestMapping("getCatalog2")
    @ResponseBody
    public  List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2ListByCatalog1Id(catalog1Id);
    }
    //http://localhost:8082/getCatalog3?catalog2Id=16
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3ListByCatalog2Id(catalog2Id);
    }

    //http://localhost:8082/attrInfoList?catalog3Id=87
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getattrInfoListByCatalog3Id(catalog3Id);
    }
    //http://localhost:8082/saveAttrInfo
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }
    //http://localhost:8082/getAttrValueList?attrId=98
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(String attrId){
        BaseAttrInfo baseAttrInfo = manageService.getAttrValueList(attrId);
        return baseAttrInfo.getAttrValueList();
    }

}
