package com.datoukeji.gmall.manage.mapper;

import com.datoukeji.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/19.
 */
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr>{
    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);
    List<SpuSaleAttr> getSpuSaleAttrListBySpuIdAndSkuId(String skuId,String spuId);
}
