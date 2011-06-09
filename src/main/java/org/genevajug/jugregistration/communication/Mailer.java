/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.communication;

import org.genevajug.jugregistration.qualifier.Mode;

/**
 *
 * @author codingdojo
 */
@org.genevajug.jugregistration.qualifier.CommunicationMode(mode=Mode.MAIL)
public class Mailer implements Communicator {

    @Override
    public void send(Object anyObject) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
