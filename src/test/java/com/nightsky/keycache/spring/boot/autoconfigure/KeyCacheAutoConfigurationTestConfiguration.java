package com.nightsky.keycache.spring.boot.autoconfigure;

import com.nightsky.keycache.spring.boot.autoconfigure.config.YamlPropertySourceFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "classpath:KeyCacheAutoConfiguration.yaml", factory = YamlPropertySourceFactory.class)
public class KeyCacheAutoConfigurationTestConfiguration {

    @Bean
    AssertableApplicationContext assertableApplicationContext(ConfigurableApplicationContext applicationContext) {
        return AssertableApplicationContext.get(() -> applicationContext);
    }

}
