package com.gyt.ticket.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

// 将服务发布出去
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《魁拔》";
    }
}
