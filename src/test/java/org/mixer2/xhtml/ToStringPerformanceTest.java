package org.mixer2.xhtml;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.util.CastUtil;

public class ToStringPerformanceTest {

    private static Log log = LogFactory.getLog(ToStringPerformanceTest.class);
    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    private int loop = 1000;

    @BeforeClass
    public static void beforeClass() {
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

    @Test
    public void loopToString() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            html.toString();
        }
        stopWatch.stop();
        log.info("   normal toString(): loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

    @Test
    public void loopToStringByReflectionToStringBuilder() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            toStringByReflectionToStringBuilder(html);
        }
        stopWatch.stop();
        log.info("ReflectionToString(): loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

    private String toStringByReflectionToStringBuilder(Object bean) {
        return (new ReflectionToStringBuilder(bean,
                ToStringStyle.MULTI_LINE_STYLE) {
            public ToStringBuilder append(String fieldName, Object obj) {
                if (obj != null) {
                    if (obj instanceof List<?>) {
                        List<?> list = CastUtil.cast(obj);
                        if (0 < list.size()) {
                            super.append(fieldName, obj);
                        }
                    } else if (obj instanceof Map<?, ?>) {
                        Map<?, ?> map = CastUtil.cast(obj);
                        if (0 < map.size()) {
                            super.append(fieldName, obj);
                        }
                    } else {
                        super.append(fieldName, obj);
                    }
                }
                return this;
            }
        }).toString();
    }
    
}
