package com.dx.dky;

import com.dx.dky.config.redis.JedisUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({JedisUtil.class})
public class DkyApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DkyApplication.class, args);

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

		String a = "123";
		String b = "123";
		String c = new String("123");
		System.out.println(a == b);
		System.out.println(a == c);
	}
}
