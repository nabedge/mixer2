package org.mixer2.spring.webmvc.resolverchaintest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mixer2.Mixer2Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:org/mixer2/spring/webmvc/resolverchaintest/testContext2.xml" })
@WebAppConfiguration
public class ViewResolverChainTest2 {

    @Autowired
    private Mixer2Engine mixer2Engine;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();
    }

    /**
     * Should be resolve by Mixer2ViewResolver
     * 
     * @throws Exception
     */
    @Test
    public void getFoo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/foo")).andReturn();
        String htmlString = mvcResult.getResponse().getContentAsString();
        mixer2Engine.checkAndLoadHtmlTemplate(htmlString);
    }

    /**
     * Should NOT be resolve to *.jsp because
     * "returnNullIfTemplateFileNotFound=false" on Mixer2ViewResolver config.
     * 
     * @throws Exception
     */
    @Test(expected = FileNotFoundException.class)
    public void getBar() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/bar")).andReturn();
    }

}
