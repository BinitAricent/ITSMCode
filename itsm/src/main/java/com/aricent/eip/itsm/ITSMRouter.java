/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   ITSMRouter
 *
 * Author:  TCL 
 *
 * Date:    06-06-2016
 *
 * Desc:    Camel route configuration
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/
package com.aricent.eip.itsm;

import java.io.IOException;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aricent.eip.itsm.exception.handler.WebServiceExceptionHandler;
import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.processors.ITSMTicketCreaterProcessor;
import com.aricent.eip.itsm.processors.PollerProcessor;
import com.aricent.eip.itsm.processors.ServiceNowTicketDetailProcessor;

@Component
public class ITSMRouter extends RouteBuilder {

    @Value("${poller.timer}")
    String pollerTimer;

    @Value("${queue.ticketId}")
    String queueTicketId;

    @Value("${route.queueTicketDetails}")
    String queueTicketDetails;

    @Value("${south.create.error.queue}")
    String errorQueue;

    @Autowired
    WebServiceExceptionHandler webServiceExceptionHandler;

    @Autowired
    ServiceNowTicketDetailProcessor serviceNowTicketDetailProcessor;

    @Autowired
    ITSMTicketCreaterProcessor itsmTicketCreatorProcessor;

    @Autowired
    ITSMLogger logger;


    @Override
    public void configure() throws IOException {

        // onException(RestWebServiceException.class).process(
        // webServiceExceptionHandler);// to("jpa://com.aricent.eip.itsm.domains.TicketDetails");

        try {
            
            //Route 1 will start polling newly created ticket Ids from Service Now and send them to queue.
            from(pollerTimer).bean(PollerProcessor.class, "poll");

            //Route 2 will start fetching ticket details from Service Now and send them to queue.
            from(queueTicketId).errorHandler(deadLetterChannel(errorQueue).useOriginalMessage().maximumRedeliveries(2).redeliveryDelay(0))
                    .threads(10).process(serviceNowTicketDetailProcessor).to(queueTicketDetails);

            //Route 3 will map SNOW ticket details with ITSM ticket details and create ticket in ITSM.
            from(queueTicketDetails)
                    .errorHandler(deadLetterChannel(errorQueue).useOriginalMessage().maximumRedeliveries(2).redeliveryDelay(0))
                    .to("dozer:transformOrder?mappingFile=service-itsm-dozer-configration-mapping.xml&targetModel=com.aricent.eip.itsm.pojo.TicketDetailsITSM&sourceModel=com.aricent.eip.itsm.pojo.TicketDetailsSNOW")
                    .process(itsmTicketCreatorProcessor);

        } catch (Exception ee) {
            ee.printStackTrace();
            logger.severe(ee.getMessage());
        }
    }

}