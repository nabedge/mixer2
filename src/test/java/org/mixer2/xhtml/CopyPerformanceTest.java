package org.mixer2.xhtml;

import java.io.File;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meta;


public class CopyPerformanceTest {

    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e;

    private int loop = 500;

    @BeforeClass
    public static void beforeClass() {
        m2e = new Mixer2Engine();
    }

    @Before
    public void before() {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test()
    public void wholeHtmlCopy() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Html tmp = null;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            tmp = html.copy(Html.class);
        }
        stopWatch.stop();
        System.out.println("normal Copy: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

    @Test()
    public void smallTagCopy() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Meta tmp = html.getById("meta-content-type", Meta.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            tmp = tmp.copy(Meta.class);
        }
        stopWatch.stop();
        System.out.println("normal Copy: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

//    @Test()
//    public void honestCopy() throws Exception {
//        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i=0; i<loop; i++) {
//            Html tmp = new Html();
//            tmp.setHead(html.getHead().copy(Head.class));
//            tmp.setBody(html.getBody().copy(Body.class));
//        }
//        stopWatch.stop();
//        System.out.println("honest Copy: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
//    }

    //    @Test()
//    public void apacheCommonsClone() throws Exception {
//        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        Html tmp = null;
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i=0; i<loop; i++) {
//            BeanUtilsBean bu = BeanUtilsBean.getInstance();
//            bu.getConvertUtils().register(false, true, 0);
//            tmp = (Html) bu.cloneBean(html);
//        }
//        stopWatch.stop();
//        System.out.println("normal Copy: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
//    }
//
//    @Test()
//    public void apacheCommonsCloneBean() throws Exception {
//        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        Html tmp = null;
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i=0; i<loop; i++) {
//            BeanUtils.cloneBean(html);
//        }
//        stopWatch.stop();
//        System.out.println("cloneBean: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
//    }
}
