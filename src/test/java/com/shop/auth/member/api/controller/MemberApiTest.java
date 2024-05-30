package com.shop.auth.member.api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class MemberApiTest {

    @InjectMocks
    private MemberApi memberApi;
    private MockMvc mockMvc;
    private Gson gson;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(memberApi).build();
    }

    @Test
    public void mockMvc가NULL이아님(){
        assertThat(memberApi).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

}
