package com.lxlib.uavplatform.repository.dao;

import com.lxlib.uavplatform.repository.enity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testSelectUserFromName() {
        User chengmanyuan = userDao.getUserByName("chengmanyuan");
        System.out.println(chengmanyuan);
    }

    @Test
    public void testInsert() {
        User chengmanyuan = User.builder().uuid(UUID.randomUUID().toString().replaceAll("-", ""))
                .uname("chengmanyuan")
                .password("123456")
                .email("2282805045@qq.com")
                .ctime(System.currentTimeMillis()).build();
        int res = userDao.insert(chengmanyuan);
        assert res == 1;
    }
}
