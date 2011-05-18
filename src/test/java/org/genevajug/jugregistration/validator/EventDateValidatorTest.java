/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.ConstraintValidatorContext;
import org.genevajug.jugregistration.entity.Event;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.fest.assertions.Assertions.*;

/**
 *
 * @author codingdojo
 */
public class EventDateValidatorTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    EventDateValidator eventDateValidator = new EventDateValidator();
    ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
    
    @Test
    public void shouldReturnTrueWhenCloseDateAfterOpenDate() throws ParseException {
        Event event = buildEvent("17052011", "18052011");
        
        boolean isValid = eventDateValidator.isValid(event, context);
        
        assertThat(isValid).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenCloseDateBeforeOpenDate() throws ParseException {
        Event event = buildEvent("18052011", "17052011");
        
        boolean isValid = eventDateValidator.isValid(event, context);
        
        assertThat(isValid).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenCloseDateIsNull() throws ParseException {
        Event event = buildEvent("18052011", null);
        
        boolean isValid = eventDateValidator.isValid(event, context);
        
        assertThat(isValid).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenOpenDateIsNull() throws ParseException {
        Event event = buildEvent(null, "18052011");
        
        boolean isValid = eventDateValidator.isValid(event, context);
        
        assertThat(isValid).isTrue();
    }

    private Event buildEvent(String openDate, String closeDate) throws ParseException {
        Event event = mock(Event.class);
        when(event.getOpenRegistrationDate()).thenReturn(openDate == null ? null : sdf.parse(openDate));
        when(event.getCloseRegistrationDate()).thenReturn(closeDate == null ? null : sdf.parse(closeDate));
        return event;
    }
}
