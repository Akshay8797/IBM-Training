package com.spring.FirstSpringDemo;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderMain {

	public static void main(String[] args) {
		int sum=0;
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("OrderSpring.xml");
		Map<String, Order> map = ctx.getBeansOfType(Order.class);
		for(String str : map.keySet())
		{
			Order order=map.get(str);
			sum+=order.getPrice();
		}
		System.out.println("Sum: "+sum);

	}

}
