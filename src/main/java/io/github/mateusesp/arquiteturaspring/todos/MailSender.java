package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void send(String mensagem) {
        System.out.println("Email enviado com sucesso!");
    }
}
