package com.datoukeji.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.datoukeji.gmall.bean.SkuInfo;
import com.datoukeji.gmall.bean.SkuSaleAttrValue;
import com.datoukeji.gmall.bean.SpuSaleAttr;
import com.datoukeji.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/8/20.
 */
@Controller
public class ItemController {

    @Reference
    private ManageService manageService;

    @RequestMapping("{skuId}.html")
    public String getSkuInfo(@PathVariable String skuId,Model model){
        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        model.addAttribute("skuInfo",skuInfo);

        List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuAttrValueList(skuInfo);
        model.addAttribute("spuSaleAttrList",spuSaleAttrList);

        List<SkuSaleAttrValue> skuSaleAttrValueListBySpu = manageService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());
        System.out.println(skuSaleAttrValueListBySpu);
        String valueIdKey = "";
        Map<String,String> valueMap = new HashMap<>();
        for (int i = 0; i < skuSaleAttrValueListBySpu.size(); i++) {
            SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueListBySpu.get(i);
            if(valueIdKey.length()!=0){
                valueIdKey= valueIdKey+"|";
            }
            valueIdKey = valueIdKey + skuSaleAttrValue.getSaleAttrValueId();
            if ((i+1)==skuSaleAttrValueListBySpu.size()||!skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueListBySpu.get(i+1).getSkuId())){
                valueMap.put(valueIdKey,skuSaleAttrValue.getSkuId());
                valueIdKey = "";
            }

        }
        String valueJson = JSON.toJSONString(valueMap);
        model.addAttribute("valueJson",valueJson);
        System.out.println(valueJson);
        return "item";
    }

}
