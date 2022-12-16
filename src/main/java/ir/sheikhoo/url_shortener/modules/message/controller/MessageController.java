package ir.sheikhoo.url_shortener.modules.message.controller;

import ir.sheikhoo.url_shortener.modules.message.model.Messages;
import ir.sheikhoo.url_shortener.modules.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/cantactus",method = RequestMethod.POST)
    public String contactUs(@ModelAttribute Messages messages){
        messageService.addMessage(messages);
        return "redirect:/";
    }
}
