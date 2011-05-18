/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author codingdojo
 */
@Documented
@Constraint(validatedBy = EventDateValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventDate {

    String message() default "Close date before Open date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
