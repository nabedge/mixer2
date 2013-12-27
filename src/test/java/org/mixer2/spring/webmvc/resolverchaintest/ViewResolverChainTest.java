package org.mixer2.spring.webmvc.resolverchaintest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:org/mixer2/spring/webmvc/resolverchaintest/testContext.xml" })
@WebAppConfiguration
public class ViewResolverChainTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();
    }

    /**
     * Should be resolve by Mixer2ViewResolver
     * @throws Exception
     */
    @Test
    public void getFoo() throws Exception {
        mockMvc.perform(get("/foo")).andExpect(status().isOk())
                .andExpect(view().name("foo")).andExpect(model().hasNoErrors());
    }

    /**
     * Should be resolve as *.jsp
     * @throws Exception
     */
    @Test
    public void getBar() throws Exception {
        mockMvc.perform(get("/bar")).andExpect(status().isOk())
                .andExpect(view().name("bar")).andExpect(model().hasNoErrors());
    }

    /**
     * Should be 404 not found.
     * @throws Exception
     */
    @Test
    public void getForNoneExistURI() throws Exception {
        mockMvc.perform(get("/aaaaaa")).andExpect(status().isNotFound());
    }

}
