package com.datoukeji.gmall.manage.mapper;

import com.datoukeji.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/17.
 */
public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    List<BaseAttrInfo> getAttrInfoListByCatalog3Id(long catalog3Id);
}
