package com.infinityeyes.lettercounter.controllers;


import com.infinityeyes.lettercounter.services.LetterCounterService;
import com.infinityeyes.lettercounter.services.domain.CountedLetter;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@RunWith(SpringJUnit4ClassRunner.class)
public class LetterCounterControllerTests {

    @Mock
    private LetterCounterService letterCounterService;

    @InjectMocks
    private LetterCounterController letterCounterController;


    private MockMvc mockMvc;

    private String sentence;
    private String letter;
    private CountedLetter countedLetter;
    @Before
    public void setUp(){

        //Create excepted entity
        sentence="this is just a test sentence";
        letter = "e";
        countedLetter = new CountedLetter(sentence,letter,3);
        int count = countedLetter.getCount();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(letterCounterController).setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(new ViewResolver() {
                    @Override
                    public View resolveViewName(String viewName, Locale locale) throws Exception {
                        return new MappingJackson2JsonView();
                    }
                }).build();

    }

    @Test
    public void countLetterTest() throws Exception{

        when(letterCounterService.countLetters(sentence,letter)).thenReturn(countedLetter);
        mockMvc.perform(post("/count")
                .content(toJson(countedLetter))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
