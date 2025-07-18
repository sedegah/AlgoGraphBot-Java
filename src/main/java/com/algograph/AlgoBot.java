package com.algograph;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class AlgoBot {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new AlgoHandler());
            System.out.println("AlgoGraphBot is running...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
