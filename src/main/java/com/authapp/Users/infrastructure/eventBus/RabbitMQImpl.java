package com.authapp.Users.infrastructure.eventBus;

import com.authapp.Users.domain.Users;
import com.authapp.Shared.domain.PublishDomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQImpl implements PublishDomainEvent {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Users push(Users user) {

        String message = convertUserToJson(user);

        // Enviar el mensaje a la cola
        rabbitTemplate.convertAndSend("user.registered.queue", message);

        return user;
    }

    private String convertUserToJson(Users user) {
        try {
            // Serializar el objeto a JSON
            return objectMapper.writeValueAsString(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir el objeto Users a JSON", e);
        }
    }
}
