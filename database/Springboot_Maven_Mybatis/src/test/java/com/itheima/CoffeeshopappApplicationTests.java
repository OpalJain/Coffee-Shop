package com.itheima;

import com.itheima.mapper.item_listmapper;
import com.itheima.pojo.item_list;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoffeeshopappApplicationTests {
    @Autowired
    private item_listmapper item_listmapper;

    /*@Test
    public void testListitem_list(){
        List<item_list> item_listList = item_listmapper.list();
        item_listList.stream().forEach(itemList -> {
                System.out.println(itemList);
        });
    }*/

    @Test
    public void testUpdate() {
            item_list itemList = new item_list();
            itemList.setItem_id(6);
            itemList.setItem_detail("Delicious Pancake");
            itemList.setItem_inventory(130);
            item_listmapper.update(itemList);

    }

}
