
/**************************************************************************

 **************************************************************************
 * Project: ITSM
 *
 * Class:   RoutingException
 *
 * Author:  Aricent 
 *
 * Date:   20/05/2016
 *
 * Desc:    Custom Exeception
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/

package com.aricent.eip.itsm.exception;

public class RoutingException extends Exception {

    public RoutingException() {
        super();
    }


    public RoutingException(Throwable cause) {
        super(cause);
    }


    public RoutingException(String str, Throwable t) {
        super(str, t);
        System.out.println(t + "\t" + str);
    }

}
