package ir.sheikhoo.url_shortener.modules.message.service;

import ir.sheikhoo.url_shortener.modules.message.model.Messages;
import ir.sheikhoo.url_shortener.modules.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public void addMessage(Messages messages) {
        messageRepository.save(messages);
    }
}
