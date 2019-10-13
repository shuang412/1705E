package com.bawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis.xml")
public class RedisTest {
	@Autowired
	RedisTemplate redisTemplate;
	/*
	 * 测试hash类型
	*/
	/*@SuppressWarnings("unchecked")
	@Test
	public void testRedisHash() {
		HashMap<String, Object> hashMap = new HashMap<String , Object>();
		//开始时间
		long start = System.currentTimeMillis();
		
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setBirthday(UserUtils.getBirthday());
			user.setEmial(UserUtils.getMail());
			user.setPhone(UserUtils.getPhone());
			user.setSex(UserUtils.getSex());
			hashMap.put("key"+i, JSON.toJSONString(user));
			redisTemplate.opsForHash().putAll("myhash", hashMap);
		}
		Map entries = redisTemplate.opsForHash().entries("myhash");
		Set entrySet = entries.entrySet();
		for (Object object : entrySet) {
			System.out.println(object);
		}
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式：hash");
		System.out.println("保存数量10w个对象");
		System.out.println("序列化时间："+(end-start));
	}*/
	/*
	 * 测试hash类型
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void testRedisJdk() {
		HashMap<String, Object> hashMap = new HashMap<String , Object>();
		//开始时间
		long start = System.currentTimeMillis();
		
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setBirthday(UserUtils.getBirthday());
			user.setEmial(UserUtils.getMail());
			user.setPhone(UserUtils.getPhone());
			user.setSex(UserUtils.getSex());
			hashMap.put("key"+i, JSON.toJSONString(user));
			redisTemplate.opsForHash().putAll("myjdk", hashMap);
		}
		Map entries = redisTemplate.opsForHash().entries("myjdk");
		Set entrySet = entries.entrySet();
		for (Object object : entrySet) {
			System.out.println(object);
		}
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式：hash");
		System.out.println("保存数量10w个对象");
		System.out.println("序列化时间："+(end-start));
	}
	
	

}
