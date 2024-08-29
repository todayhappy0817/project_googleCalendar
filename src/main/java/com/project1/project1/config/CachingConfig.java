package com.project1.project1.config;


import jdk.jfr.Enabled;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@EnableCaching
////SpringBootApplication에 추가해도 되지만 Config 클래스 추가할 경우 여기서 추가 가능
//@Configuration
//public class CachingConfig {
//    @Bean
//    public CacheManager cacheManager() {
//        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
//        cacheManager.setAllowNullValues(false); //null 값 캐싱 불가
//
//        return cacheManager;
//    }
//}
