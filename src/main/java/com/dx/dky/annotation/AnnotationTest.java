package com.dx.dky.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 测试自定义注解
 * 
 * @author admin
 *
 */
@Controller
public class AnnotationTest {

	private static final Logger logger = LoggerFactory.getLogger(AnnotationTest.class);

	@RequestNum(count = 10, time = 5000)
	@RequestMapping("/urltest")
	@ResponseBody
	public String requestLimit(HttpServletRequest request) {
		logger.info("请求一次");
		return "requestLimit";
	}

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Ordered.LOWEST_PRECEDENCE);
		System.out.println(Ordered.HIGHEST_PRECEDENCE);

		Hashtable<String, Object> hashtable = new Hashtable<>();
		// hashtable.put(null, 1234);l

		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put(null, 1111);
		hashMap.put("123", 890);

		hashMap.containsValue(890);

		System.out.println("HASHMAP:" + hashMap.containsValue(890));

		// hashtable.contains(value);
		//
		// hashMap.c

	}

	@RequestMapping("/anjularjs")
	@ResponseBody
	public String anjularjs(HttpServletRequest request) {
		logger.info("AnjularJS请求");
		String anju = "This is Anjularjs request!!!";
		return anju;
	}

//	@RequestMapping("/add")
//	@ResponseBody
//	@PreAuthorize("hasAuthority('add')")
//	public void add() {
//		System.out.println("add11111……");
//	}
//
//	@RequestMapping("/add2")
//	@ResponseBody
//	@PreAuthorize("hasAuthority('USER')")
//	public void add2() {
//		System.out.println("add11111……");
//	}
//
//	@RequestMapping("/update")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	public void update() {
//		System.out.println("update22222……");
//	}
//
//	@RequestMapping("/delete")
//	@PreAuthorize("hasRole('ADMIN')")
//	public void delete() {
//		System.out.println("delete33333……");
//	}
//
	@RequestMapping("/select")
	public void select() {
		System.out.println("delete33333……");
	}



}
