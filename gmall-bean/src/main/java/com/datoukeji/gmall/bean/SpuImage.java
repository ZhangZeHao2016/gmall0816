package com.datoukeji.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Enzo Cotter on 2019/8/19.
 */
@Data
public class SpuImage implements Serializable {

    @Column
    @Id
    private String id;
    @Column
    private String spuId;
    @Column
    private String imgName;
    @Column
    private String imgUrl;


}
