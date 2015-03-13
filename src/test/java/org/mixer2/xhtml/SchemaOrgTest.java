package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Article;
import org.mixer2.jaxb.xhtml.Html;

public class SchemaOrgTest {

	private Log log = LogFactory.getLog(SchemaOrgTest.class);
    private String templateFileName = "SchemaOrgTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test() throws Exception {
    	log.trace("");
        File file = new File(templateFilePath);
        Html html = m2e.loadHtmlTemplate(file);
        Article article = html.getById("ITEM0001", Article.class);
        Assert.assertTrue(article.getItemtype().equals("http://data-vocabulary.org/Product"));
    }
}
