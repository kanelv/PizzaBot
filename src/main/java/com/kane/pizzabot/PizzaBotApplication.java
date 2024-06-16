package com.kane.pizzabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@SpringBootApplication
public class PizzaBotApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(PizzaBotApplication.class, args);

    try {
      TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
      botsApi.registerBot(ctx.getBean("pizzaBot", AbilityBot.class));

    } catch (TelegramApiException e) {
      throw new RuntimeException(e);
    }
  }

}
