package com.vadelic.lexicon.exampleservice.service;

import com.vadelic.lexicon.exampleservice.data.ExampleModelRepository;
import com.vadelic.lexicon.exampleservice.data.ExampleModelRepositoryService;
import com.vadelic.lexicon.exampleservice.data.ExampleModelRepositoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by GreenNun on 29/10/2018.
 */
@ActiveProfiles(profiles = {"junit"})
@RunWith(SpringRunner.class)
@WebMvcTest(value = ExampleRestService.class, secure = false)
@ContextConfiguration(classes = {ExampleRestServiceTest.Config.class})
public class ExampleRestServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/test")
                .param("id", "42")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals("42", result.getResponse().getContentAsString(), false);
    }

    @TestConfiguration
    public static class Config {
        @Bean
        public ExampleModelRepository exampleModelRepository() {
            return Mockito.mock(ExampleModelRepository.class);
        }

        @Bean
        public ExampleModelRepositoryService exampleModelRepositoryService() {
            return new ExampleModelRepositoryServiceImpl(exampleModelRepository());
        }
    }
}