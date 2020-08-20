package com.stafftracking.project.chatblo;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class FirebaseMessagingGetInstance {
    @Test
    public void testGetInstance() {
        FirebaseApp.getInstance().getName();

        FirebaseMessaging messaging = FirebaseMessaging.getInstance();

        assertSame(messaging, FirebaseMessaging.getInstance());
    }

}
