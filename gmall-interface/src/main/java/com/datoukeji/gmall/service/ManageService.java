package com.datoukeji.gmall.service;

import com.datoukeji.gmall.bean.BaseAttrInfo;
import com.datoukeji.gmall.bean.BaseCatalog1;
import com.datoukeji.gmall.bean.BaseCatalog2;
import com.datoukeji.gmall.bean.BaseCatalog3;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/17.
 */
public interface ManageService {

    List<BaseCatalog1> getBaseCatalog1List();

    List<BaseCatalog2> getCatalog2ListByCatalog1Id(String catalog1Id);

    List<BaseCatalog3> getCatalog3ListByCatalog2Id(String catalog2Id);

    List<BaseAttrInfo> getattrInfoListByCatalog3Id(String catalog3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    BaseAttrInfo getAttrValueList(String attrId);
}
