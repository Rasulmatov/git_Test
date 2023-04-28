package uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.checkChanel;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CheckChanelUser {

    File file=new File("C:\\Users\\Isystem\\Documents\\Telegram Bot Isystem\\src\\main\\java\\uz\\isystem\\telegram\\bot\\photo\\chackChanel\\checkChanel.jpg");
    InputFile inputFile=new InputFile(file);

    public SendPhoto check(Long chatId){
        SendPhoto sendMessage=new SendPhoto();
        sendMessage.setChatId(chatId);
        sendMessage.setCaption("Botdan to'laqonlik foydalanish uchun Telegram Kanalga a'zo Bo'lishingiz Kerak!!! ");
        sendMessage.setReplyMarkup(chanel());
        sendMessage.setPhoto(inputFile);
        return sendMessage;
    }
    private InlineKeyboardMarkup chanel(){
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists=new ArrayList<>();
        List<InlineKeyboardButton> telegram=new ArrayList<>();
        List<InlineKeyboardButton> tekshir=new ArrayList<>();

        InlineKeyboardButton telegramB=new InlineKeyboardButton();
        telegramB.setText("Telegram Join \uD83C\uDFAF");
        telegramB.setUrl("t.me/isystemuz");

        InlineKeyboardButton tekshirB=new InlineKeyboardButton();
        tekshirB.setText("Tekshirish ✅");
        tekshirB.setCallbackData("tekshir");

        telegram.add(telegramB);
        tekshir.add(tekshirB);
        lists.add(telegram);
        lists.add(tekshir);
        inlineKeyboardMarkup.setKeyboard(lists);
        return inlineKeyboardMarkup;
    }
}
