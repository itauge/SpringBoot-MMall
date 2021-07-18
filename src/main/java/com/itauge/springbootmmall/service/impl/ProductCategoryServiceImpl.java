package com.itauge.springbootmmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itauge.springbootmmall.entity.Product;
import com.itauge.springbootmmall.entity.ProductCategory;
import com.itauge.springbootmmall.mapper.ProductCategoryMapper;
import com.itauge.springbootmmall.mapper.ProductMapper;
import com.itauge.springbootmmall.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itauge.springbootmmall.vo.ProductCategoryVO;
import com.itauge.springbootmmall.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductCategoryVO> getAllProductCategoryVO() {
        //一級分類
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", 1);
        List<ProductCategory> levelOne = mapper.selectList(wrapper);
        //方法一：
//        List<ProductCategoryVO> levelOneVO = new ArrayList<>();
//        for (ProductCategory productCategory : levelOne) {
//            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
//            BeanUtils.copyProperties(productCategory,productCategoryVO);
//            levelOneVO.add(productCategoryVO);
//        }
        //方法二：
        List<ProductCategoryVO> levelOneVO = levelOne.stream()
                .map(e -> new ProductCategoryVO(e.getId(),e.getName())).collect(Collectors.toList());

        //將主頁顯示的圖片寫進每個類目，圖片賦值
        //商品信息賦值
        for (int i = 0; i < levelOneVO.size(); i++){
            levelOneVO.get(i).setBannerImg("/images/banner"+i+".png");
            levelOneVO.get(i).setTopImg("/images/top"+i+".png");
            wrapper = new QueryWrapper();
            wrapper.eq("categorylevelone_id",levelOneVO.get(i).getId());
            List<Product> list = productMapper.selectList(wrapper);
            List<ProductVO> productVOList = list.stream()
                    .map(e -> new ProductVO(
                            e.getId(),
                            e.getName(),
                            e.getPrice(),
                            e.getFileName()
                    )).collect(Collectors.toList());
            levelOneVO.get(i).setProductVOList(productVOList);
        }

        for (ProductCategoryVO LevelOneProductCategoryVO : levelOneVO) {
            wrapper = new QueryWrapper();
            wrapper.eq("type", 2);
            wrapper.eq("parent_id",LevelOneProductCategoryVO.getId());
            List<ProductCategory> levelTwo = mapper.selectList(wrapper);
            List<ProductCategoryVO> levelTwoVO = levelTwo.stream()
                    .map(e -> new ProductCategoryVO(e.getId(),e.getName())).collect(Collectors.toList());
            LevelOneProductCategoryVO.setChildren(levelTwoVO);

            for (ProductCategoryVO LevelTwoProductCategoryVO : levelTwoVO) {
                wrapper = new QueryWrapper();
                wrapper.eq("type", 3);
                wrapper.eq("parent_id",LevelTwoProductCategoryVO.getId());
                List<ProductCategory> levelThree = mapper.selectList(wrapper);
                List<ProductCategoryVO> levelThreeVO = levelThree.stream()
                        .map(e -> new ProductCategoryVO(e.getId(),e.getName())).collect(Collectors.toList());
                LevelTwoProductCategoryVO.setChildren(levelThreeVO);
            }
        }

//
//        wrapper = new QueryWrapper();
//        wrapper.eq("type", 2);
//        List<ProductCategory> levelTwo = mapper.selectList(wrapper);
//        wrapper = new QueryWrapper();
//        wrapper.eq("type", 3);
//        List<ProductCategory> levelThree = mapper.selectList(wrapper);


        return levelOneVO;
        }
    }

