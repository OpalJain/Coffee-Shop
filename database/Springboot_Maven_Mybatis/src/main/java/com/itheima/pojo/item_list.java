package com.itheima.pojo;

import lombok.*;

/*@Getter
@Setter
@ToString
@EqualsAndHashCode
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class item_list {

    private Integer item_id;
    private String item_detail;
    private String item_name;
    private Double item_price;
    private Integer item_inventory;

 /*   public item_list() {
    }

    public item_list(Integer item_id, String item_detail, String item_name, Double item_price, String item_inventory) {
        this.item_id = item_id;
        this.item_detail = item_detail;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_inventory = item_inventory;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }

    public String getItem_inventory() {
        return item_inventory;
    }

    public void setItem_inventory(String item_inventory) {
        this.item_inventory = item_inventory;
    }

    @Override
    public String toString() {
        return "item_list{" +
                "item_id=" + item_id +
                ", item_detail='" + item_detail + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", item_inventory='" + item_inventory + '\'' +
                '}';
    }*/
}
