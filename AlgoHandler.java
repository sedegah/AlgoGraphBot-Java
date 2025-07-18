package com.algobot;

import org.springframework.core.env.StandardEnvironment;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AlgoHandler extends TelegramLongPollingBot {

    private final String BOT_TOKEN;
    private final String BOT_USERNAME;

    public AlgoHandler() {
        StandardEnvironment env = new StandardEnvironment();
        BOT_TOKEN = env.getProperty("bot.token");
        BOT_USERNAME = env.getProperty("bot.username");
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return;

        String msg = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        String reply;

        try {
            if (msg.equalsIgnoreCase("/start")) {
                reply = " Welcome to AlgoBot! Send /sort or /search to begin.";
            } else if (msg.startsWith("/sort")) {
                reply = AlgoSelector.handleTelegramSort(msg);
            } else if (msg.startsWith("/search")) {
                reply = AlgoSelector.handleTelegramSearch(msg);
            } else {
                reply = " Unknown command. Try /sort or /search.";
            }

            SendMessage response = new SendMessage(Long.toString(chatId), reply);
            execute(response);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
