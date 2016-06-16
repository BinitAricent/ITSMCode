package com.aricent.itsm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

       @RequestMapping("/ticket")
       
       public String ticketInfo(){
              
              return "300";
       }
       
       @RequestMapping("/ticketDetail")
       
       public String ticketDetail(){
              return "Aricent";
       }

       
}

