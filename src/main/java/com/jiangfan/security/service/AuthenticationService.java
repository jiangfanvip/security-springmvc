package com.jiangfan.security.service;

import com.jiangfan.security.entity.AuthenticationRequest;
import com.jiangfan.security.entity.UserDto;

/**
 * ClassName: AuthenticationService
 * Description:
 * date: 2020-8-21 9:11
 *
 * @author LENOVO
 * @since JDK 1.8
 */
public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest authenticationREquest);
}
