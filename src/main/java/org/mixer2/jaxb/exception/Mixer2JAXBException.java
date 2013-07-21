package org.mixer2.jaxb.exception;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import org.xml.sax.SAXParseException;

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

    /**
     * <p>
     * return true if this Exception links SAXParseException instance.
     * </p>
     * 
     * @return
     */
    public boolean hasSAXParseException() {
        if (getSAXParseException() == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * <p>
     * return SAXParseException.getMessage() . <br>
     * return null if exception has not link to SAXParseException.
     * </p>
     * 
     * @return
     */
    public String getSAXParseExceptionMessage() {
        if (hasSAXParseException()) {
            return getSAXParseException().getMessage();
        } else {
            return null;
        }
    }

    /**
     * <p>
     * return SAXParseException.<br>
     * return null if exception has not link to SAXParseException.
     * </p>
     * @return
     */
    public SAXParseException getSAXParseException() {
        SAXParseException ex = null;
        Throwable linkedException = this.getLinkedException();
        if (linkedException instanceof javax.xml.bind.UnmarshalException) {
            UnmarshalException ue = (UnmarshalException) linkedException;
            linkedException = ue.getLinkedException();
            if (linkedException instanceof org.xml.sax.SAXParseException) {
                ex = (SAXParseException) linkedException;
            }
        }
        return ex;
    }
}
