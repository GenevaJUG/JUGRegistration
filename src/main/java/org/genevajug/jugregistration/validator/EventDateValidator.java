/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.genevajug.jugregistration.entity.Event;

/**
 *
 * @author codingdojo
 */
public class EventDateValidator implements ConstraintValidator<EventDate, Event> {
    
    @Override
    public void initialize(EventDate constraintAnnotation) {}
    
    @Override
    public boolean isValid(Event event, ConstraintValidatorContext context) {
        if (event.getCloseRegistrationDate() == null  ||
                event.getOpenRegistrationDate() == null)
            return true;
        
        return event.getCloseRegistrationDate().after(event.getOpenRegistrationDate());
    }
}
