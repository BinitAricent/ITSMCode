package com.aricent.eip.itsm.exception.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aricent.eip.itsm.domains.ITSMTicketDetails;
import com.aricent.eip.itsm.domains.ITSMTicketDetails.ITSMStatus;
import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.pojo.TicketDetailsITSM;
import com.aricent.eip.itsm.service.ConsumeRestWebservice;

@Component
public class WebServiceExceptionHandler implements Processor {

	@Autowired
	ConsumeRestWebservice consumeRestWebservice;

	@Autowired
	private ProducerTemplate producer;

	@Autowired
	ITSMLogger logger;

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.severe("TestOnException :RestWebServiceException ::Unable to fetch Detail from web services");
		TicketDetailsITSM ticketDetailsITSM = exchange.getIn().getBody(
				TicketDetailsITSM.class);
		
		System.out.println("--------ticketDetailsITSM---------------"+ticketDetailsITSM);

	}

}
