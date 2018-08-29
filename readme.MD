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