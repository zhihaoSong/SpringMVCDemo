package com.szh.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    // @Scope(
    //       value = WebApplicationContext.SCOPE_SESSION,
    //     proxyMode = ScopedProxyMode.INTERFACES)
    public void simple() throws Exception {
        System.out.println("sfsd是多少");
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
        String str = ",,, ,sd,d, ,,,,";
        String[] ary = str.split(",");
        for (int i = 0; i < ary.length; i++) {
            System.out.println(ary[i]);

        }
        System.out.println(str.split(",").length);
        System.out.println(str.split(",", -1).length);
        System.out.println(str.split(",", -2).length);

        System.out.println(str.split(",", 5).length);
        System.out.println(str.split(",", 8).length);

        System.out.println(str.split(",", 10).length);
        System.out.println(str.split(",", 100).length);

        Map<String, String> map
                = new HashMap();
        map.put("sdfsf", "sdfsww");
        map.put("sdfssf", "sdfsww");
        map.put("sddffsf", "sdfsww");
        map.put("sdfffgsf", "sdfsww");

        for (Map.Entry<String, String> enrty : map.entrySet()
                ) {
            System.out.println(enrty);
        }

    }
}
