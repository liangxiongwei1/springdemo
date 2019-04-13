package com.example.springboot1;

import com.example.springboot1.dao.UserDao;
import com.example.springboot1.dao.UserMapperDao;
import com.example.springboot1.dto.User;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private UserMapperDao userMapperDao;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa1", "aa@126.com", "aa", formattedDate));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc",formattedDate));
//
//
//        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
//        User user1 = userRepository.findByUserName("aa1");
//        System.out.println("first"+user1.getEmail());
//        userRepository.updateNameById(user1.getId(),"aa@126.com");
//        User user2 = userRepository.findByUserName("aa1");
//        System.out.println("second"+user2.getEmail());
//        User user = userMapperDao.queryUserById(4L);
//        System.out.println("user"+user.getEmail());
//          Map<String ,Object> map = userMapperDao.queryAccessInfo(4L);
//          System.out.println("first"+map.get("accessId"));
//          Map<String ,Object> map1 = userMapperDao.queryAccessInfo(4L);
//          System.out.println("Second"+map.get("accessId"));
          userRepository.updateNameById(4L,"HAHAHA");

    }

}
