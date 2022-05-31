package com.nightsky.keycache.spring.boot.autoconfigure;

import com.google.common.base.Preconditions;
import com.nightsky.keycache.BcfksVersionedKeyPairCache;
import com.nightsky.keycache.BcfksVersionedSecretKeyCache;
import com.nightsky.keycache.VersionedKeyPairCache;
import com.nightsky.keycache.VersionedSecretKeyCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Chris
 */
@Configuration
@EnableConfigurationProperties(KeyCacheProperties.class)
public class KeyCacheAutoConfiguration {

    @Autowired
    private KeyCacheProperties keyCacheProperties;

    @Bean
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "secret-key-key-store.resource",
            "secret-key-key-store.password"
        })
    public VersionedSecretKeyCache versionedSecretKeyCache()
    {
        Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords(), "Passwords for secret keys not found");

        return new BcfksVersionedSecretKeyCache(
            keyCacheProperties.getSecretKeyKeyStore().getResource(),
            keyCacheProperties.getSecretKeyKeyStore().getPassword(),
            keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords());
    }

    @Bean
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "key-pair-key-store.resource",
            "key-pair-key-store.password"
        })
    public VersionedKeyPairCache versionedKeyPairCache()
    {
        Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords(), "Passwords for private keys not found");

        return new BcfksVersionedKeyPairCache(
            keyCacheProperties.getKeyPairKeyStore().getResource(),
            keyCacheProperties.getKeyPairKeyStore().getPassword(),
            keyCacheProperties.getKeyPairKeyStore().getKeyPasswords());
    }

}
