package org.mixer2.spring.webmvc.resolverchaintest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FooController {

    @RequestMapping(value = "/foo")
    public String useHtmlTemplate() {
        return "foo";
    }
    
    @RequestMapping(value = "/bar")
    public String useJsp() {
        return "bar";
    }
}
