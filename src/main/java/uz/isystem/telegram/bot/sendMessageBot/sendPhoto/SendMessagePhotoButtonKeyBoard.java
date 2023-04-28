package uz.isystem.telegram.bot.sendMessageBot.sendPhoto;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.io.File;

public class SendMessagePhotoButtonKeyBoard {

    public SendPhoto sendPhoto(Long id,String text,File file,ReplyKeyboardMarkup replyKeyboardMarkup){
        SendPhoto sendPhoto=new SendPhoto();
        InputFile inputFile=new InputFile(file);
        sendPhoto.setChatId(id);
        sendPhoto.setCaption(text);
        sendPhoto.setPhoto(inputFile);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);

        return sendPhoto;
    }
}
