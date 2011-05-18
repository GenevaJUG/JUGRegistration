/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.entity;

import java.math.BigDecimal;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.fest.assertions.Assertions.*;

/**
 *
 * @author codingdojo
 */
public class EventValidationTest {
    
    @Test
    public void shouldNotBeValideWhenEventNameSizeIs1() {
        Event event = mock(Event.class);
        when(event.getName()).thenReturn("A");
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        
        assertThat(violations).hasSize(1);
    }
    
}
