package com.nightsky.keycache.spring.boot.autoconfigure;

import com.nightsky.keycache.VersionedKeyPairCache;
import com.nightsky.keycache.VersionedSecretKeyCache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
    KeyCacheAutoConfigurationTestConfiguration.class,
    KeyCacheAutoConfiguration.class
})
class KeyCacheAutoConfigurationTest {

    @Autowired
    private AssertableApplicationContext context;

    @Test
    void shouldAutoConfigureVersionedSecretKeyCache() {
        assertThat(context)
            .hasSingleBean(VersionedSecretKeyCache.class)
            .hasBean("versionedSecretKeyCache");
    }

    @Test
    void shouldAutoConfigureVersionedKeyPairCache() {
        assertThat(context)
            .hasSingleBean(VersionedKeyPairCache.class)
            .hasBean("versionedKeyPairCache");
    }

}
