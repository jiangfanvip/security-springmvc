package com.jiangfan.security.entity;

import lombok.Data;

/**
 * ClassName: UserDto
 * Description:
 * date: 2020-8-21 9:12
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Data
public class UserDto {
    private String id;
    private String userName;
    private String userPass;
    private String fullName;
    private String mobile;

    private String authentication;

}
