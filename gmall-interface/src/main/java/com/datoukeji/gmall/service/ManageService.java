package com.datoukeji.gmall.service;

import com.datoukeji.gmall.bean.*;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/17.
 */
public interface ManageService {

    List<BaseCatalog1> getBaseCatalog1List();

    List<BaseCatalog2> getCatalog2ListByCatalog1Id(String catalog1Id);

    List<BaseCatalog3> getCatalog3ListByCatalog2Id(String catalog2Id);

    List<BaseAttrInfo> getAttrInfoListByCatalog3Id(String catalog3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    BaseAttrInfo getAttrValueList(String attrId);

    List<SpuInfo> getAllList(String catalog3Id);

    List<SpuInfo> getAllList(SpuInfo spuInfo);

    List<BaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(SpuInfo spuInfo);

    List<SpuImage> spuImageList(String spuId);

    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    void saveSkuInfo(SkuInfo skuInfo);

    SkuInfo getSkuInfo(String skuId);

    List<SpuSaleAttr> getSpuAttrValueList(SkuInfo skuInfo);

    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);
}
