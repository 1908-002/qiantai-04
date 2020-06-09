package com.lkc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FangAn implements Serializable {
    private Integer id;
    private String name;
    private String data;
    private Integer liuLan;
    private Integer xiaZai;
    private String flAs;
    private Integer aiBi;
    private String bq;
    private String files;

}
