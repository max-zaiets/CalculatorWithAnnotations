package calculator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Calculator initializes variables number1 and number2
 * @author Maksym Zaiets
 * @version 1.0
 * @since 03-01-2022
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Calculator {
    /**
     * @return integer number1
     */
    int number1() default 0;
    /**
     * @return integer number2
     */
    int number2() default 0;

}
