package org.robatipoor;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestTelegramBot
 */
public class TestTelegramBot extends BotHandler {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final String TOKEN = System.getenv("TELEGRAM_TOKEN");
    private final TelegramBot bot = new TelegramBot(TOKEN);

    @Override
    void onWebhookUpdate(Update update) {
        Long chatId = update.message().chat().id();
        LOG.info("get update chatId = {}",chatId);
        bot.execute(new SendMessage(chatId, "Bot Work !"));
    }

    @Override
    String getToken() {
        return TOKEN;
    }

    @Override
    TelegramBot getBot() {
        return bot;
    }

}