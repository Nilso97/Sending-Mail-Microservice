package br.com.springboot.sendemailmicroservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

import br.com.springboot.sendemailmicroservice.dto.EmailDTO;
import br.com.springboot.sendemailmicroservice.model.EmailModel;
import br.com.springboot.sendemailmicroservice.service.EmailService;

@Component
public class EmailConsumer {
    
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("E-mail status: " + emailModel.getStatusEmail().toString());
    }
}
