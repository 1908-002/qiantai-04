package com.lkc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    private Integer userId;
    private String userCode;
    private String userName;
    private String password;
    private String salt;
    private String locked;
    private String iphone;
    private String code;

}
