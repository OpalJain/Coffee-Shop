package com.itheima.mapper;

import com.itheima.pojo.item_list;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface item_listmapper {
    /*@Select("select * from item_list")
    public List<item_list> list();*/

    /*@Update("update item_list set item_detail = #{item_detail} where item_id = #{item_id}")
    public void update(item_list itemList);*/

    public void update(item_list itemList);
}
