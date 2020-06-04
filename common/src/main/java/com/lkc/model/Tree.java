package com.lkc.model;

import lombok.Data;

import java.util.List;

@Data
public class Tree {

    private Integer id;
    private String text;
    private Integer pid;
    private String href;
    private List<Tree> nodes;
    private Boolean selectable;




}
