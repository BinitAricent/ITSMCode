
package com.aricent.eip.itsm.exception;

public class RestWebServiceException extends Exception{
    /**
     * 
     */
    private static final long serialVersionUID = -9045199127905503184L;


    public RestWebServiceException() {
        super();
    }


    public RestWebServiceException(Throwable cause) {
        super(cause);
    }


    public RestWebServiceException(String str, Throwable t) {
        super(str, t);
        System.out.println(str);
    }

}
