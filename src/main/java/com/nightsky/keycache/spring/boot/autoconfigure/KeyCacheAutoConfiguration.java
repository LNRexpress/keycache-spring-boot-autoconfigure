package com.nightsky.keycache.spring.boot.autoconfigure;

import com.google.common.base.Preconditions;
import com.google.common.cache.LoadingCache;
import com.nightsky.keycache.JcaVersionedKeyPairCache;
import com.nightsky.keycache.JcaVersionedSecretKeyCache;
import com.nightsky.keycache.VersionedKeyPairCache;
import com.nightsky.keycache.VersionedSecretKeyCache;
import com.nightsky.keycache.builder.JcaVersionedKeyPairCacheBuilder;
import com.nightsky.keycache.builder.JcaVersionedSecretKeyCacheBuilder;
import com.nightsky.keycache.spring.boot.autoconfigure.annotation.ConditionalOnMap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
@ConditionalOnClass({
    JcaVersionedKeyPairCacheBuilder.class,
    JcaVersionedSecretKeyCacheBuilder.class,
    VersionedKeyPairCache.class,
    VersionedSecretKeyCache.class
})
@EnableConfigurationProperties(KeyCacheProperties.class)
public class KeyCacheAutoConfiguration {

    private static final String ERR_PASSWORDS_NOT_FOUND = "Passwords for secret keys not found";

    private static final String ERR_KEY_STORE_UNDEFINED = "Key store type must be defined";

    private static final String ERR_PRIVATE_KEY_PASSWORDS_NOT_FOUND = "Passwords for private keys not found";

    @Configuration
    @ConditionalOnClass({
        LoadingCache.class,
        Resource.class
    })
    @ConditionalOnMap("keycache.secret-key-key-store.key-passwords")
    @ConditionalOnProperty(
        prefix = "keycache.secret-key-key-store",
        name = { "resource", "password", "key-store-type" }
    )
    public class VersionedSecretKeyCacheWithPasswordAutoConfiguration {

        @Bean("versionedSecretKeyCache")
        @ConditionalOnMissingBean
        VersionedSecretKeyCache versionedSecretKeyCacheWithPassword(KeyCacheProperties keyCacheProperties)
        {
            Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords(), ERR_PASSWORDS_NOT_FOUND);
            Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType(), ERR_KEY_STORE_UNDEFINED);

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

    }

    @Configuration
    @ConditionalOnClass({
        LoadingCache.class,
        Resource.class
    })
    @ConditionalOnMap("keycache.secret-key-key-store.key-passwords")
    @ConditionalOnProperty(
        prefix = "keycache.secret-key-key-store",
        name = { "resource", "password-resource", "key-store-type" }
    )
    public class VersionedSecretKeyCacheWithPasswordResourceAutoConfiguration {

        @Bean("versionedSecretKeyCache")
        @ConditionalOnMissingBean
        VersionedSecretKeyCache versionedSecretKeyCacheWithPasswordResource(KeyCacheProperties keyCacheProperties)
        {
            Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyPasswords(), ERR_PASSWORDS_NOT_FOUND);
            Preconditions.checkNotNull(keyCacheProperties.getSecretKeyKeyStore().getKeyStoreType(), ERR_KEY_STORE_UNDEFINED);

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

    }

    @Configuration
    @ConditionalOnClass({
        LoadingCache.class,
        Resource.class
    })
    @ConditionalOnMap("keycache.key-pair-key-store.key-passwords")
    @ConditionalOnProperty(
        prefix = "keycache.key-pair-key-store",
        name = { "resource", "password", "key-store-type" }
    )
    public class VersionedKeyPairCacheWithPasswordAutoConfiguration {

        @Bean("versionedKeyPairCache")
        @ConditionalOnMissingBean
        VersionedKeyPairCache versionedKeyPairCacheWithPassword(KeyCacheProperties keyCacheProperties)
        {
            Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords(), ERR_PRIVATE_KEY_PASSWORDS_NOT_FOUND);
            Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType(), ERR_KEY_STORE_UNDEFINED);

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

    }

    @Configuration
    @ConditionalOnClass({
        LoadingCache.class,
        Resource.class
    })
    @ConditionalOnMap("keycache.key-pair-key-store.key-passwords")
    @ConditionalOnProperty(
        prefix = "keycache.key-pair-key-store",
        name = { "resource", "password-resource", "key-store-type" }
    )
    public class VersionedKeyPairCacheWithPasswordResource {

        @Bean("versionedKeyPairCache")
        @ConditionalOnMissingBean
        VersionedKeyPairCache versionedKeyPairCacheWithPasswordResource(KeyCacheProperties keyCacheProperties)
        {
            Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyPasswords(), ERR_PRIVATE_KEY_PASSWORDS_NOT_FOUND);
            Preconditions.checkNotNull(keyCacheProperties.getKeyPairKeyStore().getKeyStoreType(), ERR_KEY_STORE_UNDEFINED);

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

}
