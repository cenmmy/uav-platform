package com.lxlib.uavplatform.repository.dao;

import com.lxlib.uavplatform.repository.enity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testGetAllUser() {
        List<User> allUser = userDao.getAllUser();
        System.out.println(allUser);
    }
}
