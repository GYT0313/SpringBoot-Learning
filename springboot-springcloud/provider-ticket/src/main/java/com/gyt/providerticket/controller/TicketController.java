package com.gyt.providerticket.controller;

import com.gyt.providerticket.service.TicketService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket() {
        System.out.println("8002");
        return ticketService.getTicket();
    }
}
