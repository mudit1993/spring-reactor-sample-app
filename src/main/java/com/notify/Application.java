package com.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static reactor.bus.selector.Selectors.$;
import com.notify.service.NotificationConsumer;

import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner{
	@Autowired
    private EventBus eventBus;
     
    @Autowired
    private NotificationConsumer notificationConsumer;
     
    @Bean
    Environment env() {
        return Environment.initializeIfEmpty().assignErrorJournal();
    }
     
    @Bean
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }
 
    @Override
    public void run(String... args) throws Exception {
        eventBus.on($("notificationConsumerId"), notificationConsumer);
    }
 
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
