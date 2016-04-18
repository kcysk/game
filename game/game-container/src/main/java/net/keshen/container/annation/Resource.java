package net.keshen.container.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shenke
 * @date 2016-4-15 下午6:37:50
 */
@Target({ElementType.FIELD})
@Retention(value=RetentionPolicy.CLASS)
public @interface Resource {
	
	String name() default "";
}
