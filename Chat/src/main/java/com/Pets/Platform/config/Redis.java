package com.Pets.Platform.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
@EnableTransactionManagement 
public class Redis {
	 private final String host = "localhost";
	    private final int port = 6379;

	    // 🔹 Redis DB 2번 (채팅방 참여자용)
	    @Bean
	    public RedisConnectionFactory redisConnectionFactory2() {
	        LettuceConnectionFactory factory = new LettuceConnectionFactory(host, port);
	        factory.setDatabase(2);
	        factory.afterPropertiesSet(); // 중요
	        return factory;
	    }

	    @Bean(name = "Save_ChatMember")
	    public RedisTemplate<String, Object> redisTemplate2() {
	        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory2());
	        redisTemplate.setKeySerializer(new StringRedisSerializer());
	        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
	        redisTemplate.setEnableTransactionSupport(true);
	        return redisTemplate;
	    }

	    // 🔹 Redis DB 4번 (읽음 카운트용)
	    @Bean
	    public RedisConnectionFactory redisConnectionFactory4() {
	        LettuceConnectionFactory factory = new LettuceConnectionFactory(host, port);
	        factory.setDatabase(4);
	        factory.afterPropertiesSet();
	        return factory;
	    }

	    @Bean(name = "Save_ChatCnt")
	    public RedisTemplate<String, Object> redisTemplate4() {
	        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory4());
	        redisTemplate.setKeySerializer(new StringRedisSerializer());
	        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
	        redisTemplate.setEnableTransactionSupport(true);
	        return redisTemplate;
	    }

	    // ✅ 기본 redisTemplate는 계속 유지 가능
	    @Bean
	    @Primary
	    public RedisConnectionFactory redisConnectionFactory() {
	        LettuceConnectionFactory factory = new LettuceConnectionFactory(host, port);
	        factory.setDatabase(0); // 기본값
	        factory.afterPropertiesSet();
	        return factory;
	    }

	    @Bean
	    public RedisTemplate<String, Object> redisTemplate() {
	        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory());
	        redisTemplate.setKeySerializer(new StringRedisSerializer());
	        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
	        redisTemplate.setEnableTransactionSupport(true);
	        return redisTemplate;
	    }

	    @Bean
	    public StringRedisTemplate stringRedisTemplate(){
	        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
	        stringRedisTemplate.setConnectionFactory(redisConnectionFactory());
	        return stringRedisTemplate;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new JpaTransactionManager();
	    }
}
