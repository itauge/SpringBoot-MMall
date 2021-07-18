package com.itauge.springbootmmall.vo;

import com.itauge.springbootmmall.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private String serialnumber;
    private String userAddress;
    private Float cost;
    private List<OrderDetailVO> orderDetailVO;

}
