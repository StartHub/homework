package com.dx.dky;

import com.dx.dky.config.redis.JedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({JedisUtil.class})
public class DkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkyApplication.class, args);

//		List<String> list = new ArrayList<String>();
//
//		list.add("00000001");
//		list.add("00000002");
//		list.add("00000003");
//		list.add("00000004");
//		list.add("00000005");
//
//		long start = System.currentTimeMillis();
//
//		OrderDelayWork orderDelayWork = new OrderDelayWork();
//
//		new Thread(() -> {
//
//			for (int i = 0; i < 5; i++) {
//				orderDelayWork.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(new Random().nextInt(10) + i, TimeUnit.SECONDS)));
//			}
//		}
//
//		).start();
	}
}
