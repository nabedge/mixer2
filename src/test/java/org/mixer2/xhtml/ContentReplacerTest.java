package org.mixer2.xhtml;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Span;

public class ContentReplacerTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Test
    public void testReplaceTT() {
//        fail("Not yet implemented");
    }

    @Test
    public void testReplaceTString() {
//        fail("Not yet implemented");
    }

    @Test
    public void testReplaceTListOfObject() {
        Span span = TagCreator.span();
        span.getContent().add("foo");
        A a = TagCreator.a();
        a.setHref("/x/y.html");
        a.getContent().add("before");
        List<Object> list = new ArrayList<Object>();
        list.add(span);
        list.add("bar");
        ContentReplacer.replace(a, list);
        String str = m2e.saveToString(a);
        assertThat(str, is("<a href=\"/x/y.html\"><span>foo</span>bar</a>"));
    }

}
