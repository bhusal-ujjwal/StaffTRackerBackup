//package com.stafftracking.project.chatblo;
//
//import org.junit.Test;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//
//public class EmailValidatorTest {
//
//    @Test
//    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
//        assertTrue(EmailValidator.isValidEmail("name@email.com"));
//    }
//
//    @Test
//    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
//        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"));
//    }
//
//    @Test
//    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
//        assertFalse(EmailValidator.isValidEmail("name@email"));
//    }
//
//    @Test
//    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
//        assertFalse(EmailValidator.isValidEmail("name@email..com"));
//    }
//
//}
