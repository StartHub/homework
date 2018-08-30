package com.dx.dky;

import com.dx.dky.config.rabbitmq.MqSenderService;
import com.dx.dky.config.rabbitmq.config.RabbitmqQueue;
import com.dx.dky.dao.UserMapper;
import com.dx.dky.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DkyApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DkyApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findById(2);
        Assert.assertEquals(20, u.getAge().intValue());
        System.out.println(u.getName());
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
