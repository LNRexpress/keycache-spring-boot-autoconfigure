# keycache-spring-boot-autoconfigure

## Description

`keycache-spring-boot-autoconfigure` provides an auto-configuration class for auto-configuring `VersionedSecretKeyCache` and `VersionedKeyPairCache` instances in your Spring Boot application.

## Requirements

* Java 8 or higher
* Apache Maven 3.6 or higher
* Spring Boot 2.6.6 or higher
* [keycache](https://github.com/LNRexpress/keycache) 1.2.1 or higher

## Compilation

```
mvn clean package
```

## Installation

```
mvn install
```

## Usage

### Declare Dependencies (Apache Maven)

```
<dependency>
    <groupId>com.nightsky</groupId>
    <artifactId>keycache</artifactId>
    <version>1.2.1</version>
</dependency>
<dependency>
    <groupId>com.nightsky</groupId>
    <artifactId>keycache-spring-boot-autoconfigure</artifactId>
    <version>1.2.1.2</version>
</dependency>
```

### Configuration

`keycache-spring-boot-autoconfigure` uses Spring Resources for several configuration properties. If you have any questions about proper Resource location syntax, please see the Spring Core Resource documentation by clicking the link below:

[Spring Core - Resources](https://docs.spring.io/spring-framework/docs/5.3.18/reference/html/core.html#resources)

`keycache` logically separates symmetric and asymmetric key stores in case you want to maintain different key stores for different key types. The configuration for your symmetric key store should fall under the `keycache.secret-key-key-store` hierarchy, while the configuration for your asymmetric key store should fall under the `keycache.key-pair-key-store` hierarchy.

Each key store configuration must contain the following attributes:

**resource**
: The location of the key store, defined using a Spring resource location path.

**password-resource**
: The location of the password that protects the key store, defined using a Spring resource location path.

**key-store-type**
: The internal type, or format, of key store. See **Supported Key Store Types** below.

**key-passwords**
: A map that associates key names, or aliases, with the locations of the passwords that protect the keys. The map keys are the names, or aliases, of the keys in the key store. The map values are the locations of the resources that contain the passwords protecting the associated keys. Password resource locations are defined using Spring resource location paths.

Here is an example of what a complete configuration will look like in your Spring Boot `application.yml`:

```
keycache:
    secret-key-key-store:
        resource: file:/path/to/symmetric_key_store.ks
        password-resource: file:/path/to/symmetric_key_store.password
        key-store-type: JCEKS
        key-passwords:
            sample_sym_key-v1: file:/path/to/sample_sym_key_v1.password
            sample_sym_key-v2: file:/path/to/sample_sym_key_v2.password
    key-pair-key-store:
        resource: file:/path/to/asymmetric_key_store.ks
        password-resource: file:/path/to/asymmetric_key_store.password
        key-store-type: JCEKS
        key-passwords:
            sample_asym_key-v1: file:/path/to/sample_asym_key_v1.password
            sample_asym_key-v2: file:/path/to/sample_asym_key_v2.password
```

## Supported Key Store Types

* JCEKS
* BCFKS

*Please note that the `BCFKS` key store type requires the Bouncy Castle FIPS libraries in your classpath.*

Other key store types may work with this project, but the key store types listed above are the only key store types that have been tested.
