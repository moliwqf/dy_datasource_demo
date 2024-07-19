package com.moli.dynamic.datasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author moli
 * @time 2024-07-19 22:00:38
 */
@Data
@TableName("t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    public static User newUser(User user) {
        User ret = new User();
        ret.setName(user.getName());
        return ret;
    }
}
