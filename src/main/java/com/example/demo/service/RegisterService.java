package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private UserMapper userMapper;
    public boolean insert(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",user.getEmail());
        List<User> users = userMapper.selectList(queryWrapper);
       if(users.size()==0) {
           userMapper.insert(user);
           return true;
       }
       else
           return false;
    }
}
