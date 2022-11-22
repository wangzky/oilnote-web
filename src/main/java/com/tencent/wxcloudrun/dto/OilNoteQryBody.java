package com.tencent.wxcloudrun.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author wangzk
 * @Date 2022/11/22 10:34
 * @PackageName:com.wangzk.myoilnote.dto
 * @ClassName: OilNoteQryBody
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class OilNoteQryBody {
    private Date startTime;
    private Date endTime;
}
