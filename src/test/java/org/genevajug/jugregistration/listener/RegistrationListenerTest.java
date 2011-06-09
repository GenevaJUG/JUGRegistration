/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.listener;

import org.genevajug.jugregistration.communication.Communicator;
import org.genevajug.jugregistration.entity.Event;
import org.genevajug.jugregistration.service.EventService;
import org.genevajug.jugregistration.event.RegistrationNotification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 *
 * @author codingdojo
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationListenerTest {
    
    @Mock Communicator mailer;
    
    @Mock Communicator twitter;
    
    @Mock EventService eventService;
    
    @InjectMocks RegistrationObserver registrationObserver = new RegistrationObserver();

    @Test 
    public void shouldSendMailWhenAttendeeRegister() {
        RegistrationNotification event = mock(RegistrationNotification.class);
        
        registrationObserver.listen(event);
        
        verify(mailer, times(1)).send(anyObject());
    }
    
    @Test 
    public void shouldTweetWhen10SeatsLeft() {
        RegistrationNotification event = mock(RegistrationNotification.class);
        when(eventService.getRemainingSeats(any(Event.class))).thenReturn(10);
        
        registrationObserver.listen(event);
        
        verify(twitter, times(1)).send(anyObject());
    }
    
    @Test 
    public void shouldNotTweetWhenMoreThan10SeatsLeft() {
        RegistrationNotification event = mock(RegistrationNotification.class);
        when(eventService.getRemainingSeats(any(Event.class))).thenReturn(20);
        
        registrationObserver.listen(event);
       
        verifyZeroInteractions(twitter);
    }
    
}
