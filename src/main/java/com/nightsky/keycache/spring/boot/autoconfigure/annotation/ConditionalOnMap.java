package com.nightsky.keycache.spring.boot.autoconfigure.annotation;

import com.nightsky.keycache.spring.boot.autoconfigure.condition.IsMapCondition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(IsMapCondition.class)
public @interface ConditionalOnMap {

    String value();

}
