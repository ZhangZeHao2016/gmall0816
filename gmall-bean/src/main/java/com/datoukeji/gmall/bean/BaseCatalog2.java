package com.datoukeji.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Enzo Cotter on 2019/8/17.
 */
@Data
public class BaseCatalog2 implements Serializable{

    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String catalog1Id;


}
