我在学习git，现在发现这真是个好东西，
使用起来真的很方便，我觉得我爱上她了！！！

【1】记一次关于mybatis使用的问题
    使用Springboot构建项目，若想使用自动配置实现mybatis的使用
    请注意查看mybatis相关的依赖是否存在 mybatis-spring-boot-starter
    若其存在 配置好数据库连接 使用mybatis-generator生成相应实体和mapper 即可使用
    这一次出现问题是忘记之前把 mybatis-spring-boot-starter 给注释了 切记！！！
    
【2】测试rabbitmq的vhost是否可以实现多应用使用同一rabbitmq
    就是一个rabbitmq配置多个vhost，区分虚拟主机及用户组
    实现之前 dev test 共用同一rabbitmq配置导致数据消费错乱及测试失败的问题
    总结：不同环境对应不同的vhost 添加不同的用户
    
【3】关于rabbitmq的持久化
    rabbitmq持久化分三部分：
        Exchange持久化(交换机)
            声明时指定durable => true(默认为true)
        Queue持久化(队列)
            声明时指定durable => true
        Message持久化(消息)
        
 【4】关于JDK动态代理
      面向接口，生成接口实现类的代理对象，对代理对象的某些方法进行扩展；
      如 Spring事务Transcational 生成代理类，在需要添加事务的方法前后，
      添加额外的业务逻辑；
      无具体要代理的类，生成的代理类就无法执行具体的业务逻辑。
      动态代理：增强类或增强方法的一种实现。
 【】
 【】
 【】
 【】
 【】
 【】
 【】
 【】
 
        