package com.ai.spring.gpt4mini;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")

public class ChatController {
    private final OpenAiChatModel chatModel;

    public ChatController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    private static final String PROMPT = "Enlist IMDB ids with their movie names using this plot given after colon:";

    @GetMapping("/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "recommend me world war movies to understand the idea") String message) {
        message = PROMPT + message;
        System.out.println(message);
        return Map.of("generation", chatModel.call(message));
    }

    @GetMapping("/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        message = PROMPT + message;
        Prompt prompt = new Prompt(new UserMessage(message));
        System.out.println(prompt);
        return chatModel.stream(prompt);
    }
}
