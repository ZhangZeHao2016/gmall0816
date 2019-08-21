package com.datoukeji.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.datoukeji.gmall.bean.*;
import com.datoukeji.gmall.manage.mapper.*;
import com.datoukeji.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/17.
 */
@Service
public class ManageServiceImpl implements ManageService{

    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Autowired
    private SpuInfoMapper spuInfoMapper;

    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    private SpuImageMapper spuImageMapper;

    @Autowired
    private SkuInfoMapper skuInfoMapper;

    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    private SkuImageMapper skuImageMapper;

    /**
     * 获取所有一级分类
     * @return
     */
    @Override
    public List<BaseCatalog1> getBaseCatalog1List() {
        return baseCatalog1Mapper.selectAll();
    }

    /**
     * 通过一级分类id获取二级分类
     * @param catalog1Id
     * @return
     */
    @Override
    public List<BaseCatalog2> getCatalog2ListByCatalog1Id(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }
    /**
     * 通过二级分类id获取三级分类
     * @param catalog2Id
     * @return
     */
    @Override
    public List<BaseCatalog3> getCatalog3ListByCatalog2Id(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    /**
     * 通过三级分类id获取平台属性
     * @param catalog3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfoListByCatalog3Id(String catalog3Id) {
//        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
//        baseAttrInfo.setCatalog3Id(catalog3Id);
//        return baseAttrInfoMapper.select(baseAttrInfo);
        List<BaseAttrInfo> list =
        baseAttrInfoMapper.getAttrInfoListByCatalog3Id(Long.parseLong(catalog3Id));
        return list;
    }

    /**
     * 保存平台属性
     * @param baseAttrInfo
     */
    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo.getId()!=null && baseAttrInfo.getId().length()>0) {
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }else {
            baseAttrInfoMapper.insert(baseAttrInfo);
        }
        BaseAttrValue baseAttrValueDel = new BaseAttrValue();
        baseAttrValueDel.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValueDel);

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        if (attrValueList!=null && attrValueList.size()>0){
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }
    }


    /**
     *获取商品spu属性以及属性值
     * @param attrId
     * @return
     */
    @Override
    public BaseAttrInfo getAttrValueList(String attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValueList(baseAttrValueList);
        return baseAttrInfo;
    }

    /**
     * 通过三级分类id获取spuinfo信息
     * @param catalog3Id
     * @return
     */
    @Override
    public List<SpuInfo> getAllList(String catalog3Id) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public List<SpuInfo> getAllList(SpuInfo spuInfo) {
        return spuInfoMapper.select(spuInfo);
    }

    /**
     * 获取所有的销售属性集合
     * @return
     */
    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    /**
     * 添加商品属性,图片,销售属性,销售属性值
     * @param spuInfo
     */
    @Override
    @Transactional
    public void saveSpuInfo(SpuInfo spuInfo) {

        spuInfoMapper.insert(spuInfo);

        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList!=null && spuImageList.size()>0){
            for (SpuImage spuImage : spuImageList) {
                spuImage.setSpuId(spuInfo.getId());
                spuImageMapper.insert(spuImage);
            }
        }

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList!=null && spuSaleAttrList.size()>0) {
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insert(spuSaleAttr);
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if (spuSaleAttrValueList!=null && spuSaleAttrValueList.size()>0) {
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValueMapper.insert(spuSaleAttrValue);
                    }
                }
            }
        }



    }

    /**
     * 根据商品id获取所有的图片集合
     * @param spuId
     * @return
     */
    @Override
    public List<SpuImage> spuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        return spuImageMapper.select(spuImage);
    }

    /**
     * 通过商品id获取销售属性集合
     * @param spuId
     * @return
     */
    @Override
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
        return spuSaleAttrMapper.getSpuSaleAttrListBySpuId(spuId);
    }

    /**
     * 添加sku
     * @param skuInfo
     */
    @Override
    @Transactional
    public void saveSkuInfo(SkuInfo skuInfo) {
        skuInfoMapper.insert(skuInfo);

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        if (skuAttrValueList!=null && skuAttrValueList.size()>0) {
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfo.getId());
                skuAttrValueMapper.insert(skuAttrValue);
            }
        }

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        if (skuSaleAttrValueList!=null && skuSaleAttrValueList.size()>0){
            for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                skuSaleAttrValue.setSkuId(skuInfo.getId());
                skuSaleAttrValueMapper.insert(skuSaleAttrValue);
            }
        }

        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        if (skuImageList!=null && skuImageList.size()>0) {
            for (SkuImage skuImage : skuImageList) {
                skuImage.setSkuId(skuInfo.getId());
                skuImageMapper.insert(skuImage);
            }
        }


    }

    /**
     * 通过skuid获取skuinfo信息
     * @param skuId
     * @return
     */
    @Override
    public SkuInfo getSkuInfo(String skuId) {
        SkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(skuId);
        SkuImage skuImage = new SkuImage();
        skuImage.setSkuId(skuId);
        List<SkuImage> skuImageList = skuImageMapper.select(skuImage);
        skuInfo.setSkuImageList(skuImageList);
        return skuInfo;
    }

    /**
     * 根据skuid,spuid查询销售属性集合
     * @param skuInfo
     * @return
     */
    @Override
    public List<SpuSaleAttr> getSpuAttrValueList(SkuInfo skuInfo) {
        return spuSaleAttrMapper.getSpuSaleAttrListBySpuIdAndSkuId(skuInfo.getId(),skuInfo.getSpuId());
    }

    /**
     * 通过spuid查询所有spu下所有的sku中的属性值
     * @param spuId
     * @return
     */
    @Override
    public List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId) {
        return skuSaleAttrValueMapper.getSkuSaleAttrValueListBySpu(spuId);
    }
}
