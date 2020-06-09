package com.lkc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@Document(indexName = "1908_order_index",type="1908_order_type")
public class OrderDetailEntity implements Serializable {

    @Id
    private Integer id;//id
    @Field(name = "order_id",type = FieldType.Integer,index = false)
    private Integer order_id;//编号
    @Field(name = "user_id",type = FieldType.Integer,index = false)
    private Integer user_id;//用户id
    @Field(name = "sku_id",type = FieldType.Integer,index = false)
    private Integer sku_id;//商品id
    @Field(name = "sku_name",type = FieldType.Text,analyzer = "ik_max_word ",store = true)
    private String sku_name;//商品名称
    @Field(name = "order_price",type = FieldType.Double,index = false)
    private double order_price;//商品价钱
    @Field(name = "sku_num",type = FieldType.Integer,index = false)
    private Integer sku_num;//商品数量
    @Field(name = "create_time",type = FieldType.Keyword,index = false)
    private String create_time;//创建时间
    @Field(name = "orderstatus",type = FieldType.Integer,index = false)
    private Integer orderstatus;//订单状态
    @Field(name = "miaosu",type = FieldType.Keyword,index = false)
    private String miaosu;//商品描述别名
    @Field(name = "imgpath",type = FieldType.Keyword,index = false)
    private String imgpath;//商品照片
    @Field(name = "shifukuan",type = FieldType.Double,index = false)
    private double shifukuan;//实付款
    @Field(name = "shangPinType",type = FieldType.Integer,index = false)
    private Integer shangPinType;//商品类型


}
