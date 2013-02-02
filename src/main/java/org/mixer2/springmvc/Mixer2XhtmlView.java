package org.mixer2.springmvc;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.web.servlet.view.AbstractView;

/**
 * View for Mixer2 Html object.
 * see {@link org.mixer2.springmvc.Mixer2XhtmlViewResolver}
 *
 * @author watanabe
 *
 */
public class Mixer2XhtmlView extends AbstractView {

    private Mixer2Engine mixer2Engine;

    private String docType = null;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Html html = (Html) model
                .get(org.mixer2.jaxb.xhtml.Html.class.getName());
        response.setContentType(getContentType());
        PrintWriter writer = response.getWriter();
        StringBuffer sb = new StringBuffer();
        if (docType != null) {
            sb.append(docType.trim());
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(mixer2Engine.saveToString(html).trim());
        writer.write(sb.toString());
        writer.close();
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public Mixer2Engine getMixer2Engine() {
        return mixer2Engine;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}
