package com.lkc.model;

import lombok.Data;

@Data
public class ItemEntity {
    private Integer id;//id
    private Double price;//价钱
    private Integer sku_name;//名称
    private Integer sku_desc;//描述
    private Integer tm_id;//品牌id|商店id
    private Integer create_time;//创建时间
}
