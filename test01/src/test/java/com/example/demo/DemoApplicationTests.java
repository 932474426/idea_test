package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
@Autowired
private UserMapper userMapper;
	@Test
	void contextLoads() {
		List<User> userList = userMapper.selectList(null);
		User user=new User("999@qq.com","111");
	//	int i =userMapper.insert(user);
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("email","99966@qq.com");
		List<User> users = userMapper.selectList(queryWrapper);
		userList.forEach(System.out::println);
		System.out.println("***");
		users.forEach(System.out::println);
        if(users.size()==0)
		{
			System.out.println("null");
		}
        else{
			System.out.println("notnull");
		}
	}

}
