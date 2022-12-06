package com.jerry.myproject.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/12/05 16:23
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Configuration
public class CacheConfig {

    /**
     * 创建基于Caffeine的Cache Manager
     * @return CacheManager
     */
    @Bean
    public CacheManager caffeineCacheManager() {

        System.out.println("咖啡因配置日志");
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1,TimeUnit.SECONDS)
                .maximumSize(100));
        return cacheManager;
    }
}
