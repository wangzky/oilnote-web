package com.tencent.wxcloudrun.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.StrUtil;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.OilNoteDao;
import com.tencent.wxcloudrun.dto.OilNoteHandleBody;
import com.tencent.wxcloudrun.model.OilNote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wangzk
 * @Date 2022/11/22 10:13
 * @PackageName:com.wangzk.myoilnote.controller
 * @ClassName: OilRestController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/oil")
@Slf4j
public class OilRestController {
    private static final String add = "add";
    private static final String update = "update";
    private static final String del = "del";

    @Autowired
    OilNoteDao oilNoteDao;


    @PostMapping("/handle")
    public Object handlerData(@RequestBody OilNoteHandleBody body) {
        String handleType = body.getHandleType();
        if (StrUtil.equals(handleType , add)){
            oilNoteDao.add(body.getOilNote());
        }else if (StrUtil.equals(handleType , update)){
            oilNoteDao.update(body.getOilNote());
        }else if (StrUtil.equals(handleType , del)){
            oilNoteDao.del(body.getOilNote());
        }

        return ApiResponse.ok();
    }



    @GetMapping("/init")
    public void init(){
        final CsvReader reader = CsvUtil.getReader();
        final List<OilNote> result = reader.read(
                ResourceUtil.getUtf8Reader("config/油耗记录.csv"), OilNote.class);


        int total = 0;
        for (OilNote item : result){
            int i = oilNoteDao.add(item);
            total = total + i;
        }

        log.info("保存成功【{}】" , total);

    }







}
