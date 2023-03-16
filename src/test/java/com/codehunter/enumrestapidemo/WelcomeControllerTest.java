package com.codehunter.enumrestapidemo;

import com.codehunter.enumrestapidemo.controller.WelcomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {"app.welcome.user=user-test"})
class WelcomeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WelcomeController welcomeController;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
    }

    @Test
    void sayHelloTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello user-test"));
    }

}
