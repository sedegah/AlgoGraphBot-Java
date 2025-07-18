package com.algograph;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AlgoBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new AlgoHandler());
            System.out.println("AlgoGraphBot is running...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
