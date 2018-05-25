package com.dx.dky;

import com.dx.dky.dao.UserMapper;
import com.dx.dky.domain.User;
import com.dx.dky.rabbitmq.MqSenderService;
import com.dx.dky.rabbitmq.config.RabbitmqQueue;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DkyApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Autowired
    MqSenderService mqSenderService;

    @Test
    public void sendMsg() throws InterruptedException {
        try {

            for (int i = 0; i < 5; i++) {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<已发送消息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                mqSenderService.sendDirect(RabbitmqQueue.CONTRACE_JF_MSGINFO, "恭喜你获得" + i * 10 + "积分！");
                System.out.println(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(10000);
    }

}
