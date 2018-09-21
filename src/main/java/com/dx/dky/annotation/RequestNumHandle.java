package com.dx.dky.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Aspect  //声明为一个切面
@Component
public class RequestNumHandle {

	private static final Logger logger = LoggerFactory.getLogger("RequestLimitLogger");
	
	//实例化一个map，对请求ip进行计数
    private Map<String, Integer> redisTemplate = new HashMap<String,Integer>();

    @Pointcut("@annotation(com.dx.dky.annotation.RequestNum)")
    public void methodAspect() {
    }

//    @Around("methodAspect()")
//    public Object process(ProceedingJoinPoint jp) {
//        Object rvt = null;
//        String methodInfo = jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
//        long startTime = System.currentTimeMillis();
//        try {
//            rvt = jp.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            logger.error(throwable.getMessage());
//        }
//        logger.info(MessageFormat.format("****************request_end:{0}  time_cost:{1}**************", methodInfo, System.currentTimeMillis() - startTime));
//        return rvt;
//    }
    
//    @Before是在所拦截方法执行之前执行一段逻辑。 
//    execution() 	匹配连接点的执行方法
//    @annotation 	限制匹配带有指定注解的连接点
//    @Before("execution(* com.gbdex.credit.controller.*.*(..)) && @annotation(limit)")
    @Around("methodAspect()")
    public void requestLimit(final JoinPoint joinPoint, RequestNum limit) {
         
//    	获取连接点中的request信息
		Object[] args = joinPoint.getArgs();  
        HttpServletRequest request = null;  
        for (int i = 0; i < args.length; i++) {  
            if (args[i] instanceof HttpServletRequest) {  
                request = (HttpServletRequest) args[i];  
                break;  
            }  
        }
        
        if (request == null) {  
            throw new RequestLimitException("方法中缺失HttpServletRequest参数");  
        }
        
//      从request中获取 IP URL
        String ip = request.getLocalAddr();
        String url = request.getRequestURL().toString();
        
//        拼接url和ip为map的key
        final String key = "req_limit_".concat(url).concat(ip);
        
//        key不存在就put到redisTemplate中，已存在就加1
        if(redisTemplate.get(key) == null || redisTemplate.get(key) == 0){  
            redisTemplate.put(key, 1);  
        }else{  
            redisTemplate.put(key, redisTemplate.get(key) + 1);  
        }  
        
        int count = redisTemplate.get(key);  
        
//        当key大于0时创建计时器任务，在限制时间内移除redisTemplate中的key
        if (count > 0) { 
        	
            Timer timer = new Timer(); 
            
            //创建一个新的计时器任务。  
            TimerTask task = new TimerTask(){    
                
            	@Override  
                public void run() {  
                    redisTemplate.remove(key);  
                }  
            }; 
            
            /**
             * 安排在指定延迟后执行指定的任务。
             * task : 所要安排的任务。
             * limit.time() : 执行任务前的延迟时间，单位是毫秒。  
             */
            timer.schedule(task, limit.time());  
        }
        
        logger.info("count={}", count);
//        当key的value值大于限定的值进行异常处理
        if (count > limit.count()) {  
            logger.info("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
            throw new RequestLimitException("HTTP请求超出设定的限制");  
        }  
    }
}
