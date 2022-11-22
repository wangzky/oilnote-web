package com.tencent.wxcloudrun.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author wangzk
 * @Date 2022/11/22 10:08
 * @PackageName:com.wangzk.myoilnote.bean
 * @ClassName: OilNote
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class OilNote {
    private int id;
    private String odo;
    private String oilPrice;
    private String oilPriceTotal;
    private String oilNum;
    private String beforeState;
    private String afterState;
    private Date updateTime;
}


