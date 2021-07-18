package com.itauge.springbootmmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itauge.springbootmmall.entity.OrderDetail;
import com.itauge.springbootmmall.entity.Orders;
import com.itauge.springbootmmall.entity.Product;
import com.itauge.springbootmmall.entity.User;
import com.itauge.springbootmmall.service.CartService;
import com.itauge.springbootmmall.service.OrderDetailService;
import com.itauge.springbootmmall.service.OrderService;
import com.itauge.springbootmmall.service.ProductService;
import com.itauge.springbootmmall.vo.OrderDetailVO;
import com.itauge.springbootmmall.vo.OrderVO;
import com.itauge.springbootmmall.vo.ProductCategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
@Controller
@RequestMapping("//orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ProductService productService;

    @PostMapping("/settlement3")
    public ModelAndView settlement3(HttpSession session,
                                    Orders orders,
                                    String address,
                                    String remark){
        User user = (User) session.getAttribute("user");
        orderService.save(orders,user,address,remark);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement3");
        modelAndView.addObject("orders",orders);
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }

    @GetMapping("/orderList")
    public ModelAndView orderList(HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderList");

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        List<Orders> orders = orderService.list(wrapper);

        List<OrderVO> orderVO = orders.stream()
                .map(e -> new OrderVO(e.getSerialnumber(),e.getUserAddress(),e.getCost(),null)).collect(Collectors.toList());


        for (int i = 0; i < orders.size(); i++) {
            wrapper = new QueryWrapper();
            wrapper.eq("order_id",orders.get(i).getId());
            List<OrderDetail> orderDetailList = orderDetailService.list(wrapper);

            List<OrderDetailVO> orderDetailVO = orderDetailList.stream()
                    .map(e -> new OrderDetailVO(e.getProductId(),null,null,e.getQuantity(),e.getCost(),null)).collect(Collectors.toList());

            for (OrderDetailVO detailVO : orderDetailVO) {
                wrapper = new QueryWrapper();
                wrapper.eq("id",detailVO.getProductId());
                Product product = productService.getOne(wrapper);
                detailVO.setName(product.getName());
                detailVO.setPrice(product.getPrice());
                detailVO.setFileName(product.getFileName());
            }
            orderVO.get(i).setOrderDetailVO(orderDetailVO);

        }

//        List<OrderVO> orderVOList = new ArrayList<>();
//        OrderVO orderVO = new OrderVO();
//        List<OrderDetailVO> orderDetailVOList = new ArrayList<>();
//        OrderDetailVO orderDetailVO = new OrderDetailVO();
//
//        for (Orders order : orders) {
//            BeanUtils.copyProperties(order,orderVO);
//            wrapper = new QueryWrapper();
//            wrapper.eq("order_id",order.getId());
//            List<OrderDetail> orderDetailList = orderDetailService.list(wrapper);
//
//            for (OrderDetail detail : orderDetailList) {
//                BeanUtils.copyProperties(detail,orderDetailVO);
//                wrapper = new QueryWrapper();
//                wrapper.eq("id",detail.getProductId());
//                Product product = productService.getOne(wrapper);
//                BeanUtils.copyProperties(product,orderDetailVO);
//            }
//
//            orderVO.setOrderDetailVO(orderDetailVOList);
//            orderVOList.add(orderVO);
//        }

        modelAndView.addObject("orderList",orderVO);
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));

        return modelAndView;

    }



}

