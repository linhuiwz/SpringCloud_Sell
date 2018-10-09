package com.imooc.product.service;

import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {


    /**
     * 查询所有上架产品.
     * @return
     */
    List<ProductInfo> findUpAll();
}