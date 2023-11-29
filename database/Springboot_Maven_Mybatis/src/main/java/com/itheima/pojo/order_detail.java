package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class order_detail {
    private Integer order_detail_id;
    private Integer order_id;
    private Integer item_id;
    private Integer item_amount;
    private Double item_price;
}
