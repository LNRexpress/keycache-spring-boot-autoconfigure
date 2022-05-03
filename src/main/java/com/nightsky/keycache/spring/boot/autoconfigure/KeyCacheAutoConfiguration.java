package com.nightsky.keycache.spring.boot.autoconfigure;

import com.nightsky.keycache.BcfksVersionedKeyPairCache;
import com.nightsky.keycache.BcfksVersionedSecretKeyCache;
import com.nightsky.keycache.VersionedKeyPairCache;
import com.nightsky.keycache.VersionedSecretKeyCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 *
 * @author Chris
 */
@Configuration
@EnableConfigurationProperties(KeyCacheProperties.class)
public class KeyCacheAutoConfiguration {

    @Bean
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "secret-key-key-store.resource",
            "secret-key-key-store.password"
        })
    public VersionedSecretKeyCache versionedSecretKeyCache(
        @Value("${keycache.secret-key-key-store.resource}") Resource keyStoreResource,
        @Value("${keycache.secret-key-key-store.password}") String keyStorePassword)
    {
        return new BcfksVersionedSecretKeyCache(keyStoreResource, keyStorePassword);
    }

    @Bean
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "key-pair-key-store.resource",
            "key-pair-key-store.password"
        })
    public VersionedKeyPairCache versionedKeyPairCache(
        @Value("${keycache.key-pair-key-store.resource}") Resource keyStoreResource,
        @Value("${keycache.key-pair-key-store.password}") String keyStorePassword)
    {
        return new BcfksVersionedKeyPairCache(keyStoreResource, keyStorePassword);
    }

}
