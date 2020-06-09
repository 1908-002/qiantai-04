package com.lkc.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class GouWu implements Serializable {

    private Integer gouwuid;
    private Integer sku_id;
    private Integer user_id;
    private Integer shuliang;
    private String img;
    private String sku_name;
    private String price;
    private String xiaoji;
}
