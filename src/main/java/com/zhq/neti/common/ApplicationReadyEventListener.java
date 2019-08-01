package com.zhq.neti.common;

import com.zhq.neti.config.SwaggerPrintEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private SwaggerPrintEvent swaggerPrintEvent;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        swaggerPrintEvent.printAddress();
    }
}
