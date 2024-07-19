package com.moli.dynamic.datasource.controller;

import com.moli.dynamic.datasource.annotation.DynamicDs;
import com.moli.dynamic.datasource.context.DynamicDatasourceHolder;
import com.moli.dynamic.datasource.entity.User;
import com.moli.dynamic.datasource.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author moli
 * @time 2024-07-19 21:58:28
 */
@RestController
@RequestMapping("/dynamic/datasource")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @DynamicDs(datasource = "master")
    @PostMapping("/saveUserMaster")
    public String saveUserMaster(User user) {
//        DynamicDatasourceHolder.setDataSource("master");
        User save = User.newUser(user);
        int insert = userMapper.insert(save);
        if (insert == 1) return "success";
        return "error";
    }

    @DynamicDs(datasource = "slave")
    @PostMapping("/saveUserSlave")
    public String saveUserSlave(User user) {
//        DynamicDatasourceHolder.setDataSource("slave");
        User save = User.newUser(user);
        int insert = userMapper.insert(save);
        if (insert == 1) return "success";
        return "error";
    }
}
