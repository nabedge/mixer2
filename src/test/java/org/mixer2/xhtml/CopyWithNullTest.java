package org.mixer2.xhtml;

import org.junit.AfterClass;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Td;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CopyWithNullTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Test
    public void test_null_and_blank() throws Exception {
        Div div = TagCreator.div();
        div.getContent().add(Arrays.asList(null, " "));
        Div copy = div.copy(Div.class);
        assertEquals(m2e.saveToString(div), m2e.saveToString(copy));
    }

    @Test
    public void test_td_null() throws Exception {
        Td td = TagCreator.td();
        td.getContent().add(null);
        Td copy = td.copy(Td.class);
        assertEquals(m2e.saveToString(td), m2e.saveToString(copy));
    }

    @Test
    public void test_span_null() throws Exception {
        Span span = TagCreator.span();
        span.getContent().add(null);
        Span copy = span.copy(Span.class);
        assertEquals(m2e.saveToString(span), m2e.saveToString(copy));
    }

    @Test
    public void test_td_empty() throws Exception {
        Td td = TagCreator.td();
        td.getContent().add("");
        Td copy = td.copy(Td.class);
        assertEquals(m2e.saveToString(td), m2e.saveToString(copy));
    }

    @Test
    public void test_body_null() throws Exception {
        Body body = TagCreator.body();
        body.getContent().add(null);
        Body copy = body.copy(Body.class);
        assertEquals(m2e.saveToString(body), m2e.saveToString(copy));
    }

    @Test
    public void test_body_empty() throws Exception {
        Body body = TagCreator.body();
        body.getContent().add("");
        body.copy(Body.class);
    }
}
