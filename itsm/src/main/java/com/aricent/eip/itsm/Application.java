/**************************************************************************
 
 **************************************************************************
 * Project: ITSM
 *
 * Class:   Application
 *
 * Author:  TCL 
 *
 * Date:    06-06-2016
 *
 * Desc:    Application starter
 *
 **************************************************************************
 *
 * $Revision: 1.0 $
 * 
 **************************************************************************/

package com.aricent.eip.itsm;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.aricent.eip.itsm.logger.ITSMLogger;
import com.aricent.eip.itsm.logger.ITSMSetup;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aricent.eip.itsm.logger", "com.aricent.eip.itsm" })
public class Application {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {

        ApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        ITSMLogger logger = configurableApplicationContext.getBean(ITSMLogger.class);

        try {
            ITSMSetup.setup();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem with creating the log file ");

        }

        logger.info("****************APPLICATON STARTED ****************");

    }

}
