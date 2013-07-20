package org.mixer2.xhtml.exception;

import javax.xml.bind.JAXBException;

public class Mixer2JAXBException extends JAXBException {

    private static final long serialVersionUID = 8467912128175039180L;

    public Mixer2JAXBException(String message) {
        super(message);
    }
    
    public Mixer2JAXBException(Throwable exception) {
        super(exception);
    }

    public Mixer2JAXBException(String message, String errorCode) {
        super(message, errorCode);
    }

    public Mixer2JAXBException(String message, String errorCode,
            Throwable exception) {
        super(message, errorCode, exception);
    }

    public Mixer2JAXBException(String message, Throwable exception) {
        super(message, exception);
    }

}
