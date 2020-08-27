package com.jiangfan.security.entity;

import lombok.Data;

/**
 * ClassName: AuthenticationRequest
 * Description:
 * date: 2020-8-21 9:14
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Data
public class AuthenticationRequest {

    private String userName;
    private String userPass;
}
