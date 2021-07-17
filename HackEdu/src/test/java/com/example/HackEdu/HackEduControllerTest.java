package com.example.HackEdu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HackEduControllerTest {

    @Test
    void hello() {
        HackEduController hackEduController = new HackEduController();
        String response = hackEduController.hello();
        assertEquals("Hello", response);
    }
}