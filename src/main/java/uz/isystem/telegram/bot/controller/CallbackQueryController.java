package uz.isystem.telegram.bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import uz.isystem.telegram.bot.TelegramBotConnection;
import uz.isystem.telegram.bot.model.BotUser;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.kurs.SetContact;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.BizHaqimizdaKeyboardButton;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.SetContactUser;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.StartKeyBoardButton;
import uz.isystem.telegram.bot.repository.UserRepository;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageKeyBoardButton;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageUser;
import uz.isystem.telegram.bot.sendMessageBot.sendPhoto.SendMessagePhotoButtonKeyBoard;

import java.io.File;
import java.time.LocalDateTime;

public class CallbackQueryController {
    private SendMessageUser sendMessageUser;
    private final CallbackQuery callbackQuery;
    private final SetContactUser setContactUser;
    private final StartKeyBoardButton startKeyBoardButton;
    private final TelegramBotConnection telegramBotConnection;
    private final SendMessageKeyBoardButton sendMessageKeyBoardButton;
    private final SendMessagePhotoButtonKeyBoard sendMessagePhotoButtonKeyBoard;

    public CallbackQueryController(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
        this.setContactUser=new SetContactUser();
        this.sendMessageUser=new SendMessageUser();
        this.startKeyBoardButton=new StartKeyBoardButton();
        this.telegramBotConnection=new TelegramBotConnection();
        this.sendMessageKeyBoardButton=new SendMessageKeyBoardButton();

        this.sendMessagePhotoButtonKeyBoard=new SendMessagePhotoButtonKeyBoard();
    }

    String bizningTel="Tezlashing Yaxyo \n" +
            "Bizning tel raqamimiz \n" +
            "+998998846060 +\n" +
            "+998998826060 ";

    File fileContact=new File("C:\\Users\\Isystem\\Documents\\Telegram Bot Isystem\\src\\main\\java\\uz\\isystem\\telegram\\bot\\photo\\photoBizHaqimizda\\trekir3.jpg");
    File fileHome=new File("C:\\Users\\Isystem\\Documents\\Telegram Bot Isystem\\src\\main\\java\\uz\\isystem\\telegram\\bot\\photo\\photoBizHaqimizda\\bin.gif");

    public SendMessage contact(){
        System.out.println("hasCallback");
        if (callbackQuery.getData().equals("roziman")) {
            System.out.println("roziman");
            return sendMessageKeyBoardButton.sendButton(callbackQuery.getFrom().getId(), "contact jonatish", setContactUser.contact());
        }
        if (callbackQuery.getData().equals("rozi_emasman")){
            System.out.println("yoq");
            return sendMessageKeyBoardButton.sendButton(callbackQuery.getFrom().getId(), "Bosh menu", startKeyBoardButton.start());
        }
        if (callbackQuery.getData().equals("tekshir")){
            if (telegramBotConnection.checkChanel(callbackQuery.getMessage().getChatId())){
                System.out.println("true");
                System.out.println(callbackQuery.getId());
                System.out.println(callbackQuery.getMessage().getChatId());
                return sendMessageKeyBoardButton.sendButton(callbackQuery.getFrom().getId(), "Kanalga a'zo bo'lganingiz uchun rahmat ✅",startKeyBoardButton.start());

            }else {
                System.out.println("folse");
                return sendMessageUser.sendMessages(String.valueOf(callbackQuery.getMessage().getChatId()), "Kanalga a'zo Bo'lmagansiz ❌");
             }
        }

        return null;
    }


}
