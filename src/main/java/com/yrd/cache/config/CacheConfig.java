package com.yrd.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Component
public class CacheConfig {

	@Bean
	public Config configure() {
		return new Config().setInstanceName("hazlecast-instance").addMapConfig(new MapConfig().setName("employeeCache")
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE)));

	}
}
