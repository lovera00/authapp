package com.authapp.Shared.infrastructure;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("user.registered.queue", true);
    }

    // Configurar Exchange y Binding si es necesario
}