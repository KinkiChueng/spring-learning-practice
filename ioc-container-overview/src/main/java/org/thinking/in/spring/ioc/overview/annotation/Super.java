package org.thinking.in.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lasia on 2020/2/24.
 */
//合法标注范围
@Target(ElementType.TYPE)
//存储策略 运行时 保留反射
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
