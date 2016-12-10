package com.yx.statistics.config;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;


@Configuration
public class RedisConfig {
	
	//@Bean
	public JedisCluster JedisCluster(){
		// 数据库链接池配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(50);
		config.setMinIdle(20);
		config.setMaxWaitMillis(6 * 1000);
		config.setTestOnBorrow(true);
		// Redis集群的节点集合
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.1.112", 7112));
		jedisClusterNodes.add(new HostAndPort("192.168.1.113", 7113));
		jedisClusterNodes.add(new HostAndPort("192.168.1.114", 7114));
		jedisClusterNodes.add(new HostAndPort("192.168.1.115", 7115));
		jedisClusterNodes.add(new HostAndPort("192.168.1.116", 7116));
		// 根据节点集创集群链接对象
		// JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
		// 集群各节点集合，超时时间，最多重定向次数，链接池
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100, config);
		int num = 10;
		String key = "zhang";
		String value = "";
		for (int i=1; i <= num; i++){
			// 存数据
			jedisCluster.set(key+i, "zhang"+i); 
			// 取数据
			value = jedisCluster.get(key+i); 
			System.out.println(key+i + "=" + value);
			// 删除数据
			//jedisCluster.del(key+i); 
			//value = jedisCluster.get(key+i); 
			//log.info(key+i + "=" + value);
		}
		return jedisCluster;
	}
	
	
	@Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
		ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        
        template.setValueSerializer(jackson2JsonRedisSerializer); //1
        template.setKeySerializer(new StringRedisSerializer()); //2
        
        template.afterPropertiesSet();  
		return template;
	}

}
