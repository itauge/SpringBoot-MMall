package com.itauge.springbootmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {
    private Integer productId;
    private String name;
    private Float price;
    private Integer quantity;
    private Float cost;
    private String fileName;
}
