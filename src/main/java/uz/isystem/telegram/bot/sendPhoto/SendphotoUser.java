package uz.isystem.telegram.bot.sendPhoto;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.InlineKeyboardButtonUser;

import java.io.File;

public class SendphotoUser {
    private final InlineKeyboardButtonUser inlineKeyboardButtonUser;

    public SendphotoUser() {
        this.inlineKeyboardButtonUser=new InlineKeyboardButtonUser();
    }

    public SendPhoto sendPhoto(Long chatId){
        File file=new File("/home/muhammad/Pictures/Screenshots/com.png");
        InputFile inputFile=new InputFile(file);
        SendPhoto sendPhoto=new SendPhoto();
        sendPhoto.setPhoto(inputFile);
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption("text tezlating Yaxyo \n" +
                "lskjdfnbl;snlbnsl'knb'lsknb'lksnfkbnsk'l;fdbs\n" +
                "ljknsl;dfkbjns;lfdkjnb'lszknfb'klzns'rkbn");
        sendPhoto.setReplyMarkup(inlineKeyboardButtonUser.getInllineButton());

        return sendPhoto;
    }
}
