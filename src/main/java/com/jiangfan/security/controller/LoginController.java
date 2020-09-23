package com.jiangfan.security.controller;

import com.jiangfan.security.entity.AuthenticationRequest;
import com.jiangfan.security.entity.UserDto;
import com.jiangfan.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * ClassName: LoginController
 * Description:
 * date: 2020-8-21 10:05
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession httpSession) {
        UserDto authentication = authenticationService.authentication(authenticationRequest);
        httpSession.setAttribute("_user", authentication);
        return authentication.getUserName() + "登录成功";

    }

    @GetMapping("/user/resources1/{userName}")
    public UserDto getUserResouces(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute("_user");
//        if (userDto == null) {
//            userDto = new UserDto();
//            userDto.setUserName(userName + "没登录");
//            return userDto;
//        }
        return userDto;
    }

    @GetMapping("/user/resources2/{userName}")
    public UserDto getUserResouces2(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute("_user");
//        if (userDto == null) {
//            userDto = new UserDto();
//            userDto.setUserName(userName + "没登录");
//            return userDto;
//        }
        return userDto;
    }
}
