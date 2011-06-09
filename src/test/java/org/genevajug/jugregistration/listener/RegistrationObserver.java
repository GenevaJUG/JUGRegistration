/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.listener;

import javax.inject.Inject;
import org.genevajug.jugregistration.communication.Communicator;
import org.genevajug.jugregistration.event.RegistrationNotification;
import org.genevajug.jugregistration.qualifier.CommunicationMode;
import org.genevajug.jugregistration.qualifier.Mode;
import org.genevajug.jugregistration.service.EventService;

/**
 *
 * @author codingdojo
 */
public class RegistrationObserver {

    @Inject @CommunicationMode(mode=Mode.MAIL) Communicator mailer;
    
    @Inject @CommunicationMode(mode=Mode.TWEET) Communicator twitter;
    
    @Inject EventService eventService;
    
    public void listen(RegistrationNotification notification) {
        
        int remainingSeats = eventService.getRemainingSeats(notification.getEvent());
        
        mailer.send(notification);
        
        if(remainingSeats == 10){
            
            twitter.send(notification);
        }
    }
    
}
