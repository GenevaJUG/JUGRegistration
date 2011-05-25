/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.validator;

import java.math.BigDecimal;
import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 *
 * @author codingdojo
 */
public class FirstUpperTest {

    @Test
    public void shouldDetectInvalidLowerWords() {
        //GIVEN
        String invalidString = "coding";

        FirstUpperValidator validator = new FirstUpperValidator();

        //WHEN
        boolean isValid = validator.isValid(invalidString, null);

        //THEN
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    public void shouldDetectValidLowerWords() {
        //GIVEN
        String invalidString = "Coding";

        FirstUpperValidator validator = new FirstUpperValidator();

        //WHEN
        boolean isValid = validator.isValid(invalidString, null);

        //THEN
        Assertions.assertThat(isValid).isTrue();
    }
}
