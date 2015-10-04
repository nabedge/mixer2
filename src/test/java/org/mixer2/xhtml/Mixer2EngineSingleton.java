package org.mixer2.xhtml;

import org.mixer2.Mixer2Engine;

public class Mixer2EngineSingleton {

    private Mixer2EngineSingleton() {
    }

    private static class SingletonHolder {
        private static final Mixer2Engine instance = new Mixer2Engine();
    }

    public static Mixer2Engine getInstance() {
        System.setProperty("com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.fastBoot","true");
        return SingletonHolder.instance;
    }

}
