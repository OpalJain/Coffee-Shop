package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class orders {
    private Integer order_id;
    private String order_status;
    private Double order_price;
    private LocalDateTime order_date;

}
