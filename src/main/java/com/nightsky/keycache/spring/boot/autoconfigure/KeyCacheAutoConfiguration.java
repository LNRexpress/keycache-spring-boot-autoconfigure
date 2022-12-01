package com.nightsky.keycache.spring.boot.autoconfigure;

import com.google.common.base.Preconditions;
import com.nightsky.keycache.JcaVersionedKeyPairCache;
import com.nightsky.keycache.JcaVersionedSecretKeyCache;
import com.nightsky.keycache.VersionedKeyPairCache;
import com.nightsky.keycache.VersionedSecretKeyCache;
import com.nightsky.keycache.builder.JcaVersionedKeyPairCacheBuilder;
import com.nightsky.keycache.builder.JcaVersionedSecretKeyCacheBuilder;
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

    @Bean("versionedSecretKeyCache")
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "secret-key-key-store.resource",
            "secret-key-key-store.password"
        })
    public VersionedSecretKeyCache versionedSecretKeyCacheWithPassword()
    {
        Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords(), "Passwords for secret keys not found");
        Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType(), "Key store type must be defined");

        JcaVersionedSecretKeyCacheBuilder builder = JcaVersionedSecretKeyCache.builder()
            .withKeyStoreType(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType())
            .withKeyStoreResource(keyCacheProperties.getSecretKeyKeyStore().getResource())
            .withKeyStorePassword(keyCacheProperties.getSecretKeyKeyStore().getPassword())
            .withKeyPasswords(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords());

        if ( keyCacheProperties.getSecretKeyKeyStore().getExpireAfterWrite() != null ) {
            builder.withExpireAfterWriteDuration(keyCacheProperties.getSecretKeyKeyStore().getExpireAfterWrite());
        }

        if ( keyCacheProperties.getSecretKeyKeyStore().getKeyNamePattern() != null ) {
            builder.withKeyNamePattern(keyCacheProperties.getSecretKeyKeyStore().getKeyNamePattern());
        }

        return builder.build();
    }

    @Bean("versionedSecretKeyCache")
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "secret-key-key-store.resource",
            "secret-key-key-store.password-resource"
        })
    public VersionedSecretKeyCache versionedSecretKeyCacheWithPasswordResource()
    {
        Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords(), "Passwords for secret keys not found");
        Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType(), "Key store type must be defined");

        JcaVersionedSecretKeyCacheBuilder builder = JcaVersionedSecretKeyCache.builder()
            .withKeyStoreType(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType())
            .withKeyStoreResource(keyCacheProperties.getSecretKeyKeyStore().getResource())
            .withKeyStorePasswordResource(keyCacheProperties.getSecretKeyKeyStore().getPasswordResource())
            .withKeyPasswords(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords());

        if ( keyCacheProperties.getSecretKeyKeyStore().getExpireAfterWrite() != null ) {
            builder.withExpireAfterWriteDuration(keyCacheProperties.getSecretKeyKeyStore().getExpireAfterWrite());
        }

        if ( keyCacheProperties.getSecretKeyKeyStore().getKeyNamePattern() != null ) {
            builder.withKeyNamePattern(keyCacheProperties.getSecretKeyKeyStore().getKeyNamePattern());
        }

        return builder.build();
    }

    @Bean("versionedKeyPairCache")
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "key-pair-key-store.resource",
            "key-pair-key-store.password"
        })
    public VersionedKeyPairCache versionedKeyPairCacheWithPassword()
    {
        Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords(), "Passwords for private keys not found");
        Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType(), "Key store type must be defined");

        JcaVersionedKeyPairCacheBuilder builder = JcaVersionedKeyPairCache.builder()
            .withKeyStoreType(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType())
            .withKeyStoreResource(keyCacheProperties.getKeyPairKeyStore().getResource())
            .withKeyStorePassword(keyCacheProperties.getKeyPairKeyStore().getPassword())
            .withKeyPasswords(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords());

        if ( keyCacheProperties.getKeyPairKeyStore().getExpireAfterWrite() != null ) {
            builder.withExpireAfterWriteDuration(keyCacheProperties.getKeyPairKeyStore().getExpireAfterWrite());
        }

        if ( keyCacheProperties.getKeyPairKeyStore().getKeyNamePattern() != null ) {
            builder.withKeyNamePattern(keyCacheProperties.getKeyPairKeyStore().getKeyNamePattern());
        }

        return builder.build();
    }

    @Bean("versionedKeyPairCache")
    @ConditionalOnProperty(
        prefix = "keycache",
        name = {
            "key-pair-key-store.resource",
            "key-pair-key-store.password-resource"
        })
    public VersionedKeyPairCache versionedKeyPairCacheWithPasswordResource()
    {
        Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords(), "Passwords for private keys not found");
        Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType(), "Key store type must be defined");

        JcaVersionedKeyPairCacheBuilder builder = JcaVersionedKeyPairCache.builder()
            .withKeyStoreType(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType())
            .withKeyStoreResource(keyCacheProperties.getKeyPairKeyStore().getResource())
            .withKeyStorePasswordResource(keyCacheProperties.getKeyPairKeyStore().getPasswordResource())
            .withKeyPasswords(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords());

        if ( keyCacheProperties.getKeyPairKeyStore().getExpireAfterWrite() != null ) {
            builder.withExpireAfterWriteDuration(keyCacheProperties.getKeyPairKeyStore().getExpireAfterWrite());
        }

        if ( keyCacheProperties.getKeyPairKeyStore().getKeyNamePattern() != null ) {
            builder.withKeyNamePattern(keyCacheProperties.getKeyPairKeyStore().getKeyNamePattern());
        }

        return builder.build();
    }

}
