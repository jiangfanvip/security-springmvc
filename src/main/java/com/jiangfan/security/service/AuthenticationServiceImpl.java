package com.jiangfan.security.service;

import com.jiangfan.security.entity.AuthenticationRequest;
import com.jiangfan.security.entity.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AuthenticationServiceImpl
 * Description:
 * date: 2020-8-21 9:15
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static Map<String, UserDto> hashMap = new HashMap<>();

    static {
        UserDto userDto = new UserDto();
        userDto.setId("1");
        userDto.setFullName("江帆");
        userDto.setMobile("18665901617");
        userDto.setUserName("jiangfan");
        userDto.setUserPass("123456");
        userDto.setAuthentication("p1");   //分配p1权限
        UserDto userDto2 = new UserDto();
        userDto2.setId("2");
        userDto2.setFullName("大叔");
        userDto2.setMobile("18665901200");
        userDto2.setUserName("dashu");
        userDto2.setUserPass("123456");
        userDto2.setAuthentication("p2");  //分配p2权限

        hashMap.put("jiangfan", userDto);
        hashMap.put("dashu", userDto2);

    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getUserName()) || StringUtils.isEmpty(authenticationRequest.getUserPass())) {
            throw new RuntimeException("账号密码为空!");
        }
        UserDto userDto = hashMap.get(authenticationRequest.getUserName());
        if (userDto == null) {
            throw new RuntimeException("用户不存在!");

        }
        String userName = userDto.getUserName();
        String userPass = userDto.getUserPass();
        if (!authenticationRequest.getUserName().equals(userName) || !authenticationRequest.getUserPass().equals(userPass)) {
            throw new RuntimeException("用户名或密码错误!");

        }
        return userDto;
    }
}
