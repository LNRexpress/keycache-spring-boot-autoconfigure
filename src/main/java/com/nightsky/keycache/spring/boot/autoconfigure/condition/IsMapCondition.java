package com.nightsky.keycache.spring.boot.autoconfigure.condition;

import com.nightsky.keycache.spring.boot.autoconfigure.annotation.ConditionalOnMap;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

public class IsMapCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MergedAnnotation<ConditionalOnMap> mergedAnnotation = metadata.getAnnotations()
                .get(ConditionalOnMap.class);

        if ( !mergedAnnotation.isPresent() ) {
            return ConditionOutcome.noMatch("ConditionalOnMap annotation is missing");
        }

        String propertyKey = null;
        try {
            propertyKey = mergedAnnotation.getString("value");
        } catch (NoSuchElementException e) {
            return ConditionOutcome.noMatch("ConditionalOnMap: 'value' attribute is missing");
        }

        if ( !StringUtils.hasLength(propertyKey) ) {
            return ConditionOutcome.noMatch("ConditionalOnMap: 'value' attribute is invalid");
        }

        Map<Object, Object> map = new TreeMap<>();
        Binder.get(context.getEnvironment()).bind(propertyKey, Bindable.ofInstance(map));

        if ( map == null || map.isEmpty() ) {
            return ConditionOutcome.noMatch("Map was not found for '" + propertyKey + "'");
        } else {
            return ConditionOutcome.match("Map was found for '" + propertyKey + "'");
        }
    }

}
