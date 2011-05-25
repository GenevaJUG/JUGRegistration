/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 *
 * @author codingdojo
 */
public class AttendeeValidationTest {

    @Test
    public void emailValidationTestShouldDetectIncorrectEmail() {
        //GIVEN
        Attendee attendee = new Attendee();
        attendee.setEmail("coding*@dojo.com");
        attendee.setName("Coding");
        attendee.setFirstName("Coding");
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        //WHEN
        Set<ConstraintViolation<Attendee>> result = validator.validate(attendee);
               
        //THEN
        for (ConstraintViolation<Attendee> constraintViolation : result) {
            Assertions.assertThat(constraintViolation.getMessage()).isEqualTo("Not a valid e-mail");
        }
        Assertions.assertThat(result).hasSize(1);
        
    }

    @Test
    public void lowercaseNameShoulThrowAValidationError() {
        
        //GIVEN
        Attendee attendee = new Attendee();
        attendee.setName("coding");
        attendee.setFirstName("Coding");
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        //WHEN
        Set<ConstraintViolation<Attendee>> result = validator.validate(attendee);
               
        Assertions.assertThat(result).hasSize(1);
        
    }

    @Test
    public void lowercaseFirstNameShoulThrowAValidationError() {
        
        //GIVEN
        Attendee attendee = new Attendee();
        attendee.setName("Coding");
        attendee.setFirstName("coding");
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        //WHEN
        Set<ConstraintViolation<Attendee>> result = validator.validate(attendee);
               
        Assertions.assertThat(result).hasSize(1);
        
    }
}
