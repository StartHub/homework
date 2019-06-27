package com.dx.dky.controller;

import com.dx.dky.config.rabbitmq.MqSenderService;
import com.dx.dky.config.rabbitmq.config.RabbitmqQueue;
import com.dx.dky.domain.Person;
import com.dx.dky.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-07-06 16:40
 **/

@Api(value = "用户相关API接口", tags = "1", description = "2")
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    static Map<Object, User> users = Collections.synchronizedMap(new HashMap<Object, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method= RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

    @Autowired
    MqSenderService mqSenderService;

    @RequestMapping("/sendmsg")
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

    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        User user = new User();

        Person person = new Person();

        users.add((User) person);

        persons.add(user);


    }


}