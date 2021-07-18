package com.itauge.springbootmmall.vo;

import lombok.Data;

import java.util.List;

@Data
public class CartVO {
    private Integer id;
    private Integer quantity;
    private String name;
    private Integer productId;
    private Float cost;
    private Float price;
    private String fileName;
    private Integer stock;

}
