package com.datoukeji.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/8/19.
 */
@Data
public class SpuSaleAttr implements Serializable {

    @Id
    @Column
    String id ;

    @Column
    String spuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrName;

    @Transient
    private List<SpuSaleAttrValue> spuSaleAttrValueList;


}
