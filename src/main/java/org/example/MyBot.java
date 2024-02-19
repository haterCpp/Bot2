package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot() {
        super("6893445269:AAGByx-RxG0xRs_9jvgeE_hVTSjdFEa1rck");
    }

    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text =update.getMessage().getText();
        try {
        var message = new SendMessage();
if(text.equals("/start")){
    message.setText("Hello!");
}else if (text.equals("btc")) {
var price= CryptoPrice.spotPrice("BTC");
    message.setText("BTC price: " + price.getAmount().doubleValue());
}else if (text.equals("eth")) {
    var price= CryptoPrice.spotPrice("ETH");
    message.setText("ETH price: " + price.getAmount().doubleValue());
}else if (text.equals("doge")) {
    var price= CryptoPrice.spotPrice("Doge");
    message.setText("DogeCoin price: " + price.getAmount().doubleValue());
}else {
    message.setText("Unknown command!");
}
        message.setChatId(chatId);

            execute(message);
        } catch (Exception e){
            System.out.println("Error");
        }
    }
    @Override
    public String getBotUsername() {
        return "Crying_java_4_bot";
    }
}
