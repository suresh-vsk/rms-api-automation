package com.rms.test.hooks;

import com.rms.test.steps.SharedContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    
    @Before
    public void setUp() {
        // Clear any previous context
        SharedContext.clear();
    }
    
    @After
    public void tearDown() {
        // Clean up after each scenario
        SharedContext.clear();
    }
}