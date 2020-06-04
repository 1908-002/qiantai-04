package com.lkc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FangAn implements Serializable {
    private Integer id;
    private String name;
    private String img;
    private String data;
    private Integer liuLan;
    private Integer xiaZai;
    private Integer flAs;
}
