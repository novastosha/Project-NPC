package net.zoda.npc.api.beauty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.CONSTRUCTOR,ElementType.TYPE})

/*
 This annotation is purely cosmetic,
 it just means that annotated class / constructor will spawn the NPC entity
 */
public @interface ConstructorSpawnsByDefault {
    boolean value() default true;
}
