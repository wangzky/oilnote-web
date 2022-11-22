package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.OilNote;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author wangzk
 * @Date 2022/11/22 10:15
 * @PackageName:com.wangzk.myoilnote.dto
 * @ClassName: OilNodeHandleBody
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class OilNoteHandleBody {

    private String handleType;
    private OilNote oilNote;

}
