package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.OilNoteQryBody;
import com.tencent.wxcloudrun.model.OilNote;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author wangzk
 * @Date 2022/11/22 10:26
 * @PackageName:com.wangzk.myoilnote.dao
 * @ClassName: OilNoteDao
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface OilNoteDao {



    @Insert("insert into oil_note " +
            "(odo,oilPrice,oilPriceTotal,oilNum,beforeState,afterState,updateTime) " +
            "values " +
            "(#{odo},#{oilPrice},#{oilPriceTotal},#{oilNum},#{beforeState},#{afterState},#{updateTime}) ")
    int add(OilNote oilNote);

    @Update("update oil_note " +
            "set " +
            "odo = #{odo} " +
            ", oilPrice = #{oilPrice}" +
            ", oilPriceTotal = #{oilPriceTotal}" +
            ", oilNum = #{oilNum} " +
            " where id = #{id} ")
    int update(OilNote oilNote);


    @Delete("delete from oil_note where id = #{id} ")
    int del(OilNote oilNote);

    @Select("select * from oil_note where updateTime >= #{startTime} and updateTime <= #{endTime} order by updateTime desc  ")
    List<OilNote> qry(OilNoteQryBody body);





}
