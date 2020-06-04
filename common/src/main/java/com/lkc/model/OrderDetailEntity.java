package com.lkc.model;

import lombok.Data;

@Data
public class OrderDetailEntity {

    private Integer id;//id
    private Integer order_id;//编号
    private Integer user_id;//用户id
    private Integer sku_id;//商品id
    private String sku_name;//商品名称
    private double order_price;//商品价钱
    private Integer sku_num;//商品数量
    private String create_time;//创建时间
    private Integer orderstatus;//订单状态

    private String miaosu;//商品描述别名
    private String imgpath;//商品照片
    private double shifukuan;//实付款



}
