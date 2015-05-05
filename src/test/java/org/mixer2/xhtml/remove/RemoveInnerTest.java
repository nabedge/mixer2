package org.mixer2.xhtml.remove;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.xhtml.Mixer2EngineSingleton;

/**
 * 
 * @author nabedge/watanabe
 */
public class RemoveInnerTest {

	private String templateFileName = "RemoveInnerTest.html";
	private String templateFilePath;
	private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
	private Html html;

	@AfterClass
	public static void afterClass() {
		m2e = null;
	}

	@Before
	public void init() throws Exception {
		templateFilePath = getClass().getResource(templateFileName).toString();
		String osname = System.getProperty("os.name");
		if (osname.indexOf("Windows") >= 0) {
			templateFilePath = templateFilePath.replaceFirst("file:/", "");
		} else {
			templateFilePath = templateFilePath.replaceFirst("file:", "");
		}
	}

	/**
	 * divタグの中身を削除してみる
	 * 
	 * @throws Exception
	 */
	@Test
	public void removeInnerDiv() throws Exception {
		html = m2e.loadHtmlTemplate(new File(templateFilePath));
		Div mainDiv = html.getById("main", Div.class);
		assertTrue(mainDiv.getContent().size() > 0);

		mainDiv.removeInner();

		assertTrue(mainDiv.getContent().size() == 0);
		assertNotNull(html.getById("main", Div.class));
	}
	
	@Test
	public void removeInnerTable() throws Exception {
		html = m2e.loadHtmlTemplate(new File(templateFilePath));
		Table tbl = html.getById("tbl",Table.class);
		assertTrue(tbl.getTbody().size() > 0);
		assertTrue(tbl.isSetThead());
		assertTrue(tbl.isSetTfoot());
		
		tbl.removeInner();
		
		assertFalse(tbl.getTbody().size() > 0);
		assertFalse(tbl.isSetThead());
		assertFalse(tbl.isSetTfoot());
		
	}

}
